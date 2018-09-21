package com.hashirama.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Order(0)
@WebFilter(urlPatterns = "/*")
@Configuration
public class WebTestFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(WebTestFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("WebTestFilter do filter init.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("WebTestFilter do filter start, request path: {}.",((HttpServletRequest)servletRequest).getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("WebTestFilter do filter end.");
    }

    @Override
    public void destroy() {
        logger.info("WebTestFilter do filter destroy.");
    }
}
