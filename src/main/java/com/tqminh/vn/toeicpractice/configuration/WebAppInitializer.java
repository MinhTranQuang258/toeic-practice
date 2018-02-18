package com.tqminh.vn.toeicpractice.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx= new AnnotationConfigWebApplicationContext();
      ctx.register(WebMvcConfigurerAdapter.class);
      ctx.setServletContext(container);

      ServletRegistration.Dynamic servlet = container.addServlet("dispatcherExample", new DispatcherServlet(ctx));
      servlet.setLoadOnStartup(1);
      servlet.addMapping("/");
	}

}
