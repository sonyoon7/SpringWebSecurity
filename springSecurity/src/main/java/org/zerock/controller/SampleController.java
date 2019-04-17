package org.zerock.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;
import org.zerock.domain.Ticket;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample")
@Log4j
public class SampleController {
	
	@GetMapping(value="/getText", produces="text/plain; charset=utf-8")
	public String getText() {
		log.info("MIME TYPE : "+MediaType.TEXT_PLAIN_VALUE);
		
		return "안녕하세요";
	}
	
	@GetMapping(value ="/getSample", 
			produces= {MediaType.APPLICATION_JSON_UTF8_VALUE,
					MediaType.APPLICATION_XML_VALUE})
	public SampleVO getSample() {
		return new SampleVO(112, "스타", "로드");
	}
	
	
	@GetMapping(value ="/getSample2")  // produces 생략 가능 
	public SampleVO getSample2() {
		return new SampleVO(113, "로켓", "라쿤");
	}
	
	
	@GetMapping(value ="/getList")
	public List<SampleVO> getList() {
							//1~9까지 범위 출력  obj 타입으로 변환 (SampleVO 로 변환함) 
		return IntStream.range(1, 10).mapToObj(i-> new SampleVO(i, i+"First", i+"Last")).collect(Collectors.toList());
	}
	
	//map 메서드는 입력 컬렉션을 출력 컬렉션으로 매핑하거나 변경할때 유용
	
	
	@GetMapping(value="getMap")
	public Map<String, SampleVO>getMap(){
		Map<String, SampleVO> map = new HashMap<>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		return map;
		
	}
	
	@GetMapping(value="check", params = {"height", "weight"})
	public ResponseEntity<SampleVO> check (Double height, Double weight){
			// ResponseEntity 는  데이터와 함께 Http 헤더늬 상태 메시지 등을 같이 전달하는 용도로 사용
			// HTTP 상태코드와 에러 메시지 등을 함께 데이터를 전달할 수 있기 때문에 받는 입장에서는 확실하게 결과를 알 수 있다 
		
		
			//check()는 height과 weight 를 파라미터로 전달 받습니다 
			// 이 때 만일 height 값이 150 보다 작다면 502상태 코드와 데이터를 전송하고 그렇지 않다면 200 코드와 데이터를 전송합니다
		
		SampleVO vo = new SampleVO(0, ""+height, ""+weight);
		ResponseEntity<SampleVO> result = null;
		
		if(height <150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
			
		}else {
			result= ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(
			@PathVariable("cat") String cat,
			@PathVariable("pid") Integer pid) {
		return new String[] {"category : " + cat, "productid :"+pid};
	}
	
	@PostMapping("/ticket")  //request한 내용을 처리하기 때문에 일반적은 파라미터 전달방식을 사용 할 수 없음 33
	public Ticket convert(@RequestBody Ticket ticket) {
		log.info("convert.............ticket"+ticket);
		return ticket;
	}
	
	
}
