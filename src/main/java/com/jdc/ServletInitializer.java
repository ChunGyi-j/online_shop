package com.jdc;

import org.codehaus.groovy.ast.stmt.IfStatement;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.fasterxml.jackson.core.sym.Name;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OnlineShopPlatformApplication.class);
	}
	
}
