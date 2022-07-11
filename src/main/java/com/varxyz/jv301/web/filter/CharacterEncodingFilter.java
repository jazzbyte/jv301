package com.varxyz.jv301.web.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;


/**
 *  <filter>
 *  	<filter-name>YOSFilter</filter-name>
 *  	<filter-class>com.varxyz.jv301.web.filter.CharacterEncodingFilter</filter-class>
 *  		<init-param>
 *  			<param-name>Character Encoding</param-name>
 *  			<param-value>UTF-8</param-value>
 *  		</init-param>
 * 	</filter>
 */
@WebFilter(urlPatterns = "/*", 
		initParams = @WebInitParam(name = "Character Encoding", value = "UTF-8"))
public class CharacterEncodingFilter implements Filter {
	private FilterConfig config;
	private String encoding;
	private String DEFAULT_ENCODING="UTF-8";

	public void init(FilterConfig config)  throws ServletException {
		this.config = config;
		encoding = config.getInitParameter("Character Encoding");
		System.out.println("encoding=" + encoding);
 	}

	public void doFilter(ServletRequest request, ServletResponse response, 
					FilterChain chain)throws ServletException, IOException {
		try{
			request.setCharacterEncoding(encoding);
		}catch(UnsupportedEncodingException ux){
			encoding=DEFAULT_ENCODING;
		}
		chain.doFilter(request, response);
 	}

	public void destroy() {
		config = null;
		encoding = null;
	}
}
