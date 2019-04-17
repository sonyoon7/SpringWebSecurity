package org.zerock.controller;

import java.util.HashMap;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.Getter;
import lombok.extern.log4j.Log4j;
import oracle.jdbc.proxy.annotation.Post;


@Controller
@RequestMapping("/board/*")
@Log4j
public class BoardController {
	@Inject
	private BoardService service;   // 한개 일 경우 묵시적 생성자 자동 주입 
	
	@GetMapping("/list")  //리턴값없어도 알아서 view 페이지 이동...
	public void list (Model model) {
		model.addAttribute("list", service.getList());
		log.info("list------------------------------");
		
		
		
		//return "/board/list";
	}
	
	

	@GetMapping("/register")
	public String Getregister () {
		
		return "/board/register";
	}
	@PostMapping("/register")
	public String register (BoardVO board, RedirectAttributes rttr) {
//		RedirectAttributes rttr
//		rttr.addFlashAttribute() 은 일회성으로만 데이터를 전달 함 , 단 한 번 만 사용 
		service.register(board);
		rttr.addFlashAttribute("result", board);
		log.info("register done");
		return "redirect:/board/list";
		
	}
	
	
	@GetMapping("/get")
	public void get(@RequestParam(value="bno", required=false)Integer bno , Model model ) {
		log.info("/get");
		
		model.addAttribute("board", service.get(bno));
		
	}
	
	@GetMapping("/modify")
	public void Getmodify (@RequestParam(value="bno", required=false)Integer bno ,Model model) {
		model.addAttribute("board", service.get(bno));
		log.info("modify... get");
	}
	
	@PostMapping("/modify")
	public String modify (BoardVO board, RedirectAttributes rttr) {
		log.info("modify... post");
		log.info(board.getWriter());
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
			
		}
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno")Integer bno, RedirectAttributes rttr) {
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		return "redirect:/board/list";
	}


}
