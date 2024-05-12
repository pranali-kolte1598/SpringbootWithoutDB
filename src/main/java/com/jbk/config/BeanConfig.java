package com.jbk.config;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfig {

	
		@Bean 
		public ArrayList<String> getList(){
			return new ArrayList<>();
		}

	}

