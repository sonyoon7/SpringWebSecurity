package org.zerock.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages= {"org.zerock.service","org.zerock.sample"})
@ComponentScan(basePackages="org.zerock.aop")
@MapperScan(basePackages= {"org.zerock.mapper"})
@EnableAspectJAutoProxy
public class RootConfig {
	
	//RootConfig 에서 @ComponentScan 어노테이션을 이용해서 처리 할 수 있다 
	
	@Bean
	public DataSource dataSource(){
		HikariConfig hikariConfig= new HikariConfig();
//		hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
//		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
//		hikariConfig.setUsername("book_ex");
//		hikariConfig.setPassword("book_ex");
		hikariConfig.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		hikariConfig.setJdbcUrl("jdbc:log4jdbc:mysql://127.0.0.1:3306/book_ex?useSSL=false&characterEncoding=UTF-8&useUnicode=true");
		hikariConfig.setUsername("yuni");
		hikariConfig.setPassword("1234");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return  dataSource;
		
	}
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sqlSessionFactory= new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		
		return sqlSessionFactory.getObject();
	}
	
	

		
}
