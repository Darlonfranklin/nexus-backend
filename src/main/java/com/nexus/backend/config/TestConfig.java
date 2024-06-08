package com.nexus.backend.config;
import com.nexus.backend.services.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

    void instanceDB() {
		this.dbService.instanceDB();
    }
}
