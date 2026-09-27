package com.exp.InterceptorDemo.interceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;



@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        System.out.println("Incomming request---------");
        System.out.println("Method Name: "+ request.getMethod());
        System.out.println("Request Uri: "+ request.getRequestURI());
        System.out.println("Request Parameter: "+ request.getQueryString());
        System.out.println("Client Ip: "+ request.getRemoteAddr());
        System.out.println("Method Name: "+ request.getMethod());
        System.out.println("header Name: "+ request.getHeader("token"));

        //handler specific details
        System.out.println("prehandle called");
        HandlerMethod method=(HandlerMethod) handler;
        String controllerName= method.getBeanType().getName();
        String methodName= method.getMethod().getName();
        System.out.println("Controller Name: "+ controllerName);
        System.out.println("Controller Method Name: "+ methodName);

        return true; // age nhi to return false

    }



    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                  Exception ex) throws Exception {
        System.out.println("AfterCompletion called");
        System.out.println("Response Status: "+ response.getStatus());
    }


}
