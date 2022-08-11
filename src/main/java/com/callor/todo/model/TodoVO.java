package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TodoVO {
	
	private long seq;
	private String id;
	private String insert_date;
	private String insert_time;
	private String context;
	
	private String comp_date;
	private String comp_time;
	
	private Boolean complete;
	
	
	
}
