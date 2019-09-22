package com.robesz.restlogfilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogFilter_First implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        LocalThreadUUID.setUuid((req.getHeader("UUID") == null ? LocalDateTime.now() : req.getHeader("UUID") ) + "_FIRST");
        filterChain.doFilter(servletRequest, servletResponse);
        LocalThreadUUID.cleanUp();
    }
}
