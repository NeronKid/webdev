package com.serving.accounting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AccountingApplication {
	  public static void main(String[] args) {
		    SpringApplication.run(AccountingApplication.class, args);
		  }
}
