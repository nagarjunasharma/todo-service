package com.nslearning.todoservice.model;

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
@Table(name = "item")
public class Item {

	@Id
	@Column(name = "item_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)
	private long id;
	@Column(name = "category_id")
	private long categoryId;
	@Column(name = "content")
	private String content;
	@Column(name = "created_at")
	private Date createdDate;
	@Column(name = "modified_at")
	private Date modifiedDate;
	@Column(name =  "due_date")
	private Date dueDate;
	@Column(name =  "is_completed",columnDefinition = "TINYINT")
	private boolean completed;

}
