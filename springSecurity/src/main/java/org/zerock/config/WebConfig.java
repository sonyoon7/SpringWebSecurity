package org.zerock.config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
public class WebConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {//root-context 대신 
		
		
		return new Class[] {RootConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {ServletConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}
	
	

//	@Override
//	protected void customizeRegistration(Dynamic registration) {
//		
//		
//		System.out.println("------------------------------");
//		System.out.println("------------------------------");
//		System.out.println("------------------------------");
//		System.out.println("------------------------------");
//		System.out.println("------------------------------");
//		
//		registration.setInitParameter("thorwExceptionIfNoHandlerFound", "true");
//		
//	}

	@Override
	protected void customizeRegistration(ServletRegistration.Dynamic registration) {

		registration.setInitParameter("throwExceptionIfNoHandlerFound", "true");

	}
	
	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter= new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return new Filter[] {characterEncodingFilter};
	}

	
		
}
