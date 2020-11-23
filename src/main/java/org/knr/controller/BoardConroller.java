package org.knr.controller;

import java.util.List;

import org.knr.domain.Board;
import org.knr.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/board")
public class BoardConroller {
	
	@Autowired
	BoardService boardService;

	// register Form
	@GetMapping({"/registerForm", "saveForm"})
	public String registerForm() {
		return "registerForm";
	}

	// 글쓰기
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody Board board) {
		
		board.setBno(11l);
		board.setWriter("dd");
		boardService.regisert(board);

		// boardService.createBoard(dto);
		System.out.println("ccc");
		return "redirect:/board/list";
	}
	
	
	@GetMapping({"","/","/list"})
	public String list(Model model) {
		model.addAttribute("boards", boardService.findAll());
		return "list";
	}
	
	@DeleteMapping("/{id}")
	@ResponseBody
	public String delete(@PathVariable Long id) {
		boardService.remove(id);
		return "ok";
	}	
	
	// 글 수정
	@PutMapping("/update")
	@ResponseBody
	public String update(@RequestBody Board board) {
		System.out.println("aaa");
		System.out.println(board);
		boardService.modify(board);
		return "ok";
	}
	
	
	@GetMapping("/{id}")
	public String detail(@PathVariable Long id, Model model){
		model.addAttribute("board", boardService.find(id));
		return "detail";
	}
}

// contoller의 method의 파라메터 부분은 자동 DI가 됨