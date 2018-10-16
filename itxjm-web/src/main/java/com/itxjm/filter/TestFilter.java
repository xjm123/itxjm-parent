package com.itxjm.filter;

import com.itxjm.entity.VideoType;
import com.itxjm.service.VideoTypeService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import java.io.IOException;
import java.util.List;

public class TestFilter implements Filter {

    VideoTypeService videoTypeService;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext servletContext = filterConfig.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        VideoTypeService videoTypeService = webApplicationContext.getBean(VideoTypeService.class);
        this.videoTypeService = videoTypeService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        List<VideoType> videoTypes = videoTypeService.getVideoType(null);
        for(VideoType vt:videoTypes){
            System.out.println("filter:"+vt);
        }
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
