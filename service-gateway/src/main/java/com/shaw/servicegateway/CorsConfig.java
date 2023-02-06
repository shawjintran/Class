package com.shaw.servicegateway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {
	@Bean
	public CorsWebFilter corsWebFilter(){
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.addAllowedHeader("*");
		configuration.addAllowedMethod("*");
		configuration.addAllowedOrigin("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
		source.registerCorsConfiguration("/**",configuration);
		return new CorsWebFilter(source);
	}
}
