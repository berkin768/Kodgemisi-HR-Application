package kodgemisi.hr.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;


@Configuration
public class SessionConfig {

<<<<<<< HEAD
=======
	

>>>>>>> origin/master
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