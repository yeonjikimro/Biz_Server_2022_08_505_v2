package com.callor.todo.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {
	


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "home";
	}

	@RequestMapping(value="/403",method=RequestMethod.GET)
	public String error403() {
		return "error/403";
	}
	
	
}
