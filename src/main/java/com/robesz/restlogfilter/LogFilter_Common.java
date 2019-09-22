package com.robesz.restlogfilter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class LogFilter_Common implements Filter {

    @Autowired
    Logger logger;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("Filter init....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        System.out.println("doFilter.. set threadLocal");
        LocalThreadUUID.setUuid("ABC-DEF-123-GHI");

       // logger.writeLog("doFilter. Server port" + servletRequest.getServerPort());
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("After the request doFilter..");
        LocalThreadUUID.cleanUp();
    }

    @Override
    public void destroy() {
        System.out.println("Filter destroy....");
    }
}
