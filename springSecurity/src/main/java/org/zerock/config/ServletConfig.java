package org.zerock.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@EnableWebMvc
@ComponentScan(basePackages= {"org.zerock.controller","org.zerock.exception"})
public class ServletConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {

		System.out.println("ServletConfig........................2");
		System.out.println("ServletConfig........................2");
		System.out.println("ServletConfig........................2");
		System.out.println("ServletConfig........................2");
		
		InternalResourceViewResolver bean= new InternalResourceViewResolver();
		
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		
		
		registry.viewResolver(bean);
	}

	
	

}
