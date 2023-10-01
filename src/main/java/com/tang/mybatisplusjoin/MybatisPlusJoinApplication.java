package com.tang.mybatisplusjoin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.tang.mybatisplusjoin.mapper")
public class MybatisPlusJoinApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusJoinApplication.class, args);
	}

}
