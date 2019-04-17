package org.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;

@Component  //스프링 컨테이너에게 이 클래스를 관리해달라고 하는 역할
@Data
public class Restaurant {
	
	/*
	 * @Setter(onMethod=@__({@Autowired}))//@Setter 는 serChef을 자동 생성 onMethod 는
	 * autowired 를 추가함
	 */	
	@Setter(onMethod_ = {@Autowired})//@Setter 는 serChef을 자동 생성 onMethod 는 autowired 를 추가함
	 private Chef chef;
	 
}
