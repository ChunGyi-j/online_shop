package com.jdc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
	registry.addViewController("/").setViewName("home");
	registry.addViewController("/sell").setViewName("sellpage");
	registry.addViewController("/shop").setViewName("shop");
	registry.addViewController("/cart").setViewName("cart");
	registry.addViewController("/iteminfo").setViewName("iteminfo");
	registry.addViewController("/buyitem").setViewName("buyitem");
	registry.addViewController("/shoppage").setViewName("shopPage");
	registry.addViewController("/itemdetail").setViewName("itemdetail");
	registry.addViewController("/sign").setViewName("sign");
	registry.addViewController("/h").setViewName("header");
	registry.addViewController("/createshop").setViewName("multi-step-form");
	registry.addViewController("/itemdetail2").setViewName("itemdetail2");
	registry.addViewController("/additem").setViewName("addItem");
	registry.addViewController("/checkout").setViewName("checkout");
	registry.addViewController("/shop").setViewName("shopKeeper");
	registry.addViewController("/orderhistory").setViewName("orderHistory");
	registry.addViewController("/muti-step-form2").setViewName("multi-step-form2");
	registry.addViewController("/profile").setViewName("profile");
	registry.addViewController("/admin").setViewName("adminProfile");
	registry.addViewController("/adminhome").setViewName("adminHome");


	registry.addViewController("/products").setViewName("products");

	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		        registry.addResourceHandler("/resources/**")
	                .addResourceLocations("classpath:/static/");
	    }

}
