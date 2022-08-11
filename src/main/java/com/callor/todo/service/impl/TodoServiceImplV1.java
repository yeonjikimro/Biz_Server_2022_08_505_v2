package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service("todoServiceV1")
public class TodoServiceImplV1 implements TodoService{

	@Autowired
	private TodoDao todoDao;
	
	
	@Bean
	public void create_todo_table() {
		// TODO Auto-generated method stub
		todoDao.create_todo_table();
		
	}

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return todoDao.selectAll();
	}

	@Override
	public TodoVO findById(Long seq) {
		
		return todoDao.findById(seq);
	}

	@Override
	public int insert(TodoVO vo) {
		// TODO Auto-generated method stub
		

		
		return todoDao.insert(vo);
	}

	@Override
	public int update(TodoVO vo) {
		
		return todoDao.update(vo);
	}

	@Override
	public int delete(Long seq) {
		// TODO Auto-generated method stub
		return todoDao.delete(seq);
	}

	@Override
	public List<TodoVO> selectTodoAll(String username) {
		// TODO Auto-generated method stub
		return todoDao.selectTodoAll(username);
	}

}
