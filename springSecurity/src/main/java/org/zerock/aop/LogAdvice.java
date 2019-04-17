package org.zerock.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect // aspect 구현함을 명시
@Log4j
@Component  //bean  인식시키기위함
public class LogAdvice {

	
	//execution은  aspectj 의 표현식 이다 
	// 접근제한자와 특정 클래스의 메서드를  지정할 수 있다 맨 앞의 * 는 접근 제한자 , 맨뒤의 * 는 클래스 이름과 메서드 이름 의미함 
	@Before("execution(* org.zerock.service.SampleService*.*(..))")
	public void logBefore() {
		log.info("------------------------------------------------------------");
	}
	
	
}
