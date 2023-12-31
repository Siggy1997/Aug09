package com.siggy.web.controller;

import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.siggy.web.dto.BoardDTO;
import com.siggy.web.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public String board(Model model) {
		
		List<BoardDTO> list =  boardService.boardList();
		//System.out.println(list);
		model.addAttribute("list",list);
		
		return "/board";
	}
	@ResponseBody
	@PostMapping("/detail")
	public String detail(@RequestParam("bno") int bno) {
		//System.out.println(bno);
		JSONObject json = new JSONObject();
		String content = boardService.detail(bno);
		json.put("content", content);
		return json.toString();
		
	}
	@GetMapping("/write")
	public String write() {
		return "/write";
	}
}
