package com.ctl.todoservice.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "todo_item")
public class TODOItem {
	
	@Id
	@Column(name =  "todo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)
	private long id;
	@Column(name =  "description")
	private String description;
	@Column(name =  "created_at")
	private Date createdDate;
	@Column(name =  "due_date")
	private Date dueDate;
	@Column(name =  "created_by")
	private String createdBy;
	@Column(name =  "is_completed",columnDefinition = "TINYINT")
	private boolean completed;

}
