package com.exp.InterceptorDemo.config;

import com.exp.InterceptorDemo.interceptor.AuthenticationInterceptor;
import com.exp.InterceptorDemo.interceptor.AutherisationInterceptor;
import com.exp.InterceptorDemo.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    public LoggingInterceptor loggingInterceptor;
    public AuthenticationInterceptor authenticationInterceptor;
    public AutherisationInterceptor autherisationInterceptor;


    @Autowired
    public WebConfig(LoggingInterceptor  loggingInterceptor ,
                     AuthenticationInterceptor authenticationInterceptor,
                     AutherisationInterceptor autherisationInterceptor ){
        this.loggingInterceptor=loggingInterceptor;
        this.authenticationInterceptor=authenticationInterceptor;
        this.autherisationInterceptor= autherisationInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")  /*** 1. api/student/random --work but 2. /api/* work only api/student and 3. /api/ means exact ***/
                .excludePathPatterns("/api/auth/login" , "/api/public/*")
                        .order(1);


        registry.addInterceptor(authenticationInterceptor)
                .addPathPatterns("/api/**")
                        .order(2);

        registry.addInterceptor(autherisationInterceptor)
                .order(3);

    }
}
