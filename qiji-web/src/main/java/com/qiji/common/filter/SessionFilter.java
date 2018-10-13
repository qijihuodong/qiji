package com.qiji.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.qiji.domain.MicroUsers;
import com.qiji.service.IMicroUsersService;


/**
 * 拦截请求，判断session是否失效
 * @author zjw
 *
 */
@WebFilter(filterName="sessionFilter",urlPatterns="/qiji/users/*")
public class SessionFilter implements Filter {
	private final static Logger logger = LoggerFactory.getLogger(SessionFilter.class);
	
	@Autowired
	private IMicroUsersService microUsersService;
	
	//标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{
    		"/qiji/users/login","/qiji/users/register","/qiji/users/getVCode","/qiji/users/forget",
    		"/qiji/users/login.html","/qiji/users/register.html","/qiji/users/getVCode.html","/qiji/users/forget.html"
    };
    
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain filterChain) throws IOException, ServletException {
		try{
			HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        HttpSession session = request.getSession(false);
	        String uri = request.getRequestURI();
	        System.out.println(uri);
			
	        //是否需要过滤
	        boolean needFilter = isNeedFilter(uri);
			
	        if (!needFilter) { //不需要过滤直接传给下一个过滤器
	            filterChain.doFilter(servletRequest, servletResponse);
	        } else { //需要过滤器
	            // session中包含user对象,则是登录状态
	          if(session!=null&&session.getAttribute("user") != null){
	                // System.out.println("user:"+session.getAttribute("user"));
	                filterChain.doFilter(request, response);
	          }else{
					String utel = request.getParameter("utel");
					String upwd = request.getParameter("upwd");
					MicroUsers loginUser = null;
					if(StringUtils.isNotBlank(utel) && StringUtils.isNotBlank(upwd)){
						MicroUsers user = new MicroUsers();
						user.setUtel(utel);
						user.setUpwd(upwd);
						loginUser = microUsersService.login(user );
						session.setAttribute("user", loginUser);
					}
					
					if(session!=null&&session.getAttribute("user") != null){
		                // System.out.println("user:"+session.getAttribute("user"));
		                filterChain.doFilter(request, response);
					}else{
						String requestType = request.getHeader("X-Requested-With");
						// 判断是否是ajax请求
						if (requestType != null
								&& "XMLHttpRequest".equals(requestType)) {
							response.getWriter().write(this.NO_LOGIN);
						} else {
							// 重定向到登录页(需要在static文件夹下建立此html文件)
							response.sendRedirect(request.getContextPath()
									+ "/index");
						}
						return;
					}
				}
	        }
		}catch(Exception e){
			logger.error(e.getMessage());
		}
		
	}
	
	public boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

	@Override
	public void init(FilterConfig cfg) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
