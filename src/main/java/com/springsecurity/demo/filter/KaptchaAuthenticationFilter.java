package com.springsecurity.demo.filter;

import com.google.code.kaptcha.Constants;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class KaptchaAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private String servletPath;

    public KaptchaAuthenticationFilter(String servletPath, String failureUrl) {
        super(servletPath);
        this.servletPath = servletPath;
        setAuthenticationFailureHandler(new SimpleUrlAuthenticationFailureHandler(failureUrl));
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        if ("POST".equalsIgnoreCase(req.getMethod()) && servletPath.equals(req.getServletPath())) {
            String expect = (String) req.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);

            System.out.println("注意： expect的值："+expect);
            System.out.println("注意： kaptcha的值："+req.getParameter("kaptcha"));

            if (expect != null && !expect.equalsIgnoreCase(req.getParameter("kaptcha"))) {
                unsuccessfulAuthentication(req, res, new InsufficientAuthenticationException("输入的验证码不正确"));

                System.out.println("注意： 输入的验证码不正确！");

                return;
            }

            else if(expect.equalsIgnoreCase(req.getParameter("kaptcha")))
            {
                System.out.println("注意： 输入的验证码完全正确！");
            }

        }
        chain.doFilter(request, response);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        return null;
    }
}