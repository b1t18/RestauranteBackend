package com.polleria.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configuracion 
{
	@Bean
	public WebMvcConfigurer corsConfigurar()
	{
		return new WebMvcConfigurer() 
		{ 
			@Override
			public void addCorsMappings(CorsRegistry registry)
			{
				registry.addMapping("/**").allowedOrigins("http://localhost:4200");
			}
		};
	}
}
