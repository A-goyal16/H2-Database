package h2.helper;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("h2")
public class MyConfiguration 
{
	@Bean
	public EntityManager getEM() {
		return Persistence.createEntityManagerFactory("test").createEntityManager();
	}

	@Bean
	public ViewResolver getVR() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//		resolver.setPrefix("/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
//<property name="hibernate.hbm2ddl.auto" value="create-drop" />
