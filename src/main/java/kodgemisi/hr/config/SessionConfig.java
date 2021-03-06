package kodgemisi.hr.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;


@Configuration
public class SessionConfig {

	@Bean
	public SessionFactory sessionFactory(DataSource dataSource) {
		Properties properties = new Properties();
		properties.put("hibernate.show_sql", "true");

		return new LocalSessionFactoryBuilder(dataSource)
				.scanPackages("dto")
				.addProperties(properties)
				.buildSessionFactory();
	}
}