package com.springsecurity.demo.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ErrorPageConfig implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {

        //按错误的类型显示错误的网页
        ErrorPage e403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
        errorPageRegistry.addErrorPages(e403);
    }

}