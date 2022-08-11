package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value="/todo")
public class TodoController {
	
	@Autowired
	TodoService todoService;

	@RequestMapping(value="/todoList", method=RequestMethod.GET)
	public String todo(Model model, Principal principal) {
		
		List<TodoVO> todoList = todoService.selectTodoAll(principal.getName());
		model.addAttribute("todoList", todoList);
		
		return null;
	}
	
	@RequestMapping(value="/todoList", method=RequestMethod.POST)
	public String todo(Principal principal, TodoVO todoVO) {
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		todoVO.setInsert_date(dateFormat.format(date));
		todoVO.setInsert_time(timeFormat.format(date));
		todoVO.setId(principal.getName());
		
		todoVO.setComplete(false);

		
//		if(todoVO.getComplete() == true) {
//			
//		}
		
		
		
		todoService.insert(todoVO);
		
		return "redirect:/todo/todoList";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.GET)
	public String update(@PathVariable("seq") String seq, Model model) {
		
		long m_seq = Long.valueOf(seq);
		
		TodoVO todoVO = todoService.findById(m_seq);
		log.debug("여기입니다" + todoVO.toString());
		model.addAttribute("todo", todoVO);
		
		return "todo/update";
	}
	
	@RequestMapping(value="/{seq}/update", method=RequestMethod.POST)
	public String update(@PathVariable("seq") String seq, @ModelAttribute("todo") TodoVO todoVO, Model model) {
		
		todoService.update(todoVO);
		
		return "redirect:/todo/todoList";
	}
	
	@RequestMapping(value="/{seq}/complete", method=RequestMethod.GET)
	public String complete(@PathVariable("seq") String seq, Principal principal) {
		
		long m_seq = Long.valueOf(seq);
		TodoVO todoVO = todoService.findById(m_seq);
		
		Date date = new Date(System.currentTimeMillis());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");		
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		todoVO.setComp_date(dateFormat.format(date));
		todoVO.setComp_time(timeFormat.format(date));
		todoVO.setId(principal.getName());
		
		
		
		todoVO.setComplete(!todoVO.getComplete());
		if(!todoVO.getComplete()) {
			todoVO.setComp_date("");
			todoVO.setComp_time("");
			
		}
		
		todoService.update(todoVO);
		
		
		return "redirect:/todo/todoList";
	}

//	리스트를 보고 클릭하면 리스트에 대한 시퀀스 값을 컨틀로러에 보내고
//	컨트는 시퀀스값을 서비스에 보내고 게는 findById(seq) 함리턴된 todovo에
//	완료 날짜 세팅, VO에 보내고 업데이트
}
