package com.nexus.backend.config;

import com.nexus.backend.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String value;

	boolean instanceDB() {
		if (value.equals("create")) {
			this.dbService.instanceDB();
		}
		return false;
	}
}
