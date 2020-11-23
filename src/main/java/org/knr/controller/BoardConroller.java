package org.knr.controller;

import java.util.List;

import org.knr.domain.Board;
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
@AllArgsConstructor
public class BoardConroller {
	@Autowired
	MongoTemplate mongoTemplate;

	// http://localhost:8000/board/saveForm
	@GetMapping("/saveForm")
	public String saveForm() {
		return "saveForm";
	}

	// 글쓰기
	@PostMapping("/save")
	@ResponseBody
	public String save(@RequestBody Board board) {
		
		board.setBno(1l);
		board.setWriter("dd");
		mongoTemplate.insert(board);

		// boardService.createBoard(dto);
		System.out.println("ccc");
		return "ok";
	}
}

// contoller의 method의 파라메터 부분은 자동 DI가 됨