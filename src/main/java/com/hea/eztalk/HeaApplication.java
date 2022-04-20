package com.hea.eztalk;

import java.util.Date;

import com.hea.eztalk.domain.Hea;
import com.hea.eztalk.domain.Level;
import com.hea.eztalk.domain.Repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HeaApplication {

	static ApplicationContext applicationContext;
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(HeaApplication.class, args);

		Repository repository = applicationContext.getBean(Repository.class);

		Hea hea = new Hea();
		hea.setRecentActivityDate(new Date());
		hea.setLevel(Level.고수);

		repository.save(hea);

		System.out.println(hea.check잠수() == false);


	}

}
