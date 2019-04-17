package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Aspect // aspect 구현함을 명시
@Log4j
@Component  //aop와 관계 없지만  bean  인식시키기위함
public class LogAdvice {

	
	//execution은  aspectj 의 표현식 이다 
	// 접근제한자와 특정 클래스의 메서드를  지정할 수 있다 맨 앞의 * 는 접근 제한자 , 맨뒤의 * 는 클래스 이름과 메서드 이름 의미함 
//	@Before("execution(* org.zerock.service.SampleService*.*(..))")
//	public void logBefore() {
//		log.info("------------------------------------------------------------");
//		
//	}

	//'execution 으로 시작하는 Pointcut 설정에 doAdd()메서드를 명시하고 파라미터 타입을 지정 뒤쪽의 &&args 부분에서는 변수명을 지정하는데
	// 이 종류의 정보를 이용해서 logBeforeWithParam() 메서드의 파라미터를 설정하게 됨 
	@Before("execution(* org.zerock.service.SampleService*.doAdd(String, String)) && args(str1, str2)")
	public void logBeforeWithParam(String str1, String str2) {
		log.info("------------------------------------------------------------");
		log.info("str1: "+str1);
		log.info("str2: "+str2);
		
	}
	
	
	@AfterThrowing(pointcut="execution(* org.zerock.service.SampleService*.*(..))", throwing="exception")
	public void logException(Exception exception) {
		log.info("Exception............!!!");
		log.info("exception: "+exception);
		
	}
	
	
	@Around("execution(* org.zerock.service.SampleService*.*(..))")
	public Object logTime(ProceedingJoinPoint pjp) {
		long start =System.currentTimeMillis();
		
		log.info("Target: "+ pjp.getTarget());
		log.info("Param: "+ Arrays.toString(pjp.getArgs()));
		
		//invoke method
		Object result = null;
		try {
			result=pjp.proceed();
			
		}catch (Throwable e) {
			e.printStackTrace();
		}
		long end= System.currentTimeMillis();
		log.info("TIME: "+(end - start));
		return result;
	}
	
}
