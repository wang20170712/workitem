package com.lin.workitem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lin.workitem.mapper")
public class WorkitemApplication {

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WorkitemApplication.class);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(WorkitemApplication.class, args);
	}
}
