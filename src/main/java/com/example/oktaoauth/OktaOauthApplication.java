package com.example.oktaoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SpringBootApplication
public class OktaOauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(OktaOauthApplication.class, args);
	}

	@Configuration
	static class WebConfig extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests()
					// allow antonymous access to the root page
					.antMatchers("/nonauth").permitAll()
					// all other requests
					.anyRequest().authenticated()

					.and().oauth2ResourceServer().jwt();
					// set logout URL

			http.cors();




		}
	}
}
