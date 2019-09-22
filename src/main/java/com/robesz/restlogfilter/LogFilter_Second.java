package com.robesz.restlogfilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class LogFilter_Second implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        String uuid = (req.getHeader("UUID") == null ? LocalDateTime.now() : req.getHeader("UUID") ) + "_SECOND";

        LocalThreadUUID.setUuid(uuid);
        res.setHeader("UUID", uuid);
        filterChain.doFilter(servletRequest, servletResponse);
        LocalThreadUUID.cleanUp();
    }
}
