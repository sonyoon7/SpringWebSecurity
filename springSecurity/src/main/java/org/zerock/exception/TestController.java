package org.zerock.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test/*")
public class TestController {

	@GetMapping("/doA")
	public void doA(String name) {
	
		System.out.println("test......doA..................");
		System.out.println("test......doA..................");
		System.out.println("test......doA..................");
		System.out.println("test......doA..................");
		System.out.println("test......doA..................");
		
		name.substring(3);
		
		
	}
}
