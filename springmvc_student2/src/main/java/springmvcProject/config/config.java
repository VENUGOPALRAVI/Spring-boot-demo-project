package springmvcProject.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"springmvcProject"})
public class config 
{
	@Bean
	public EntityManager getManager()
	{
		
		return Persistence.createEntityManagerFactory("amit").createEntityManager();
		
	}

}
