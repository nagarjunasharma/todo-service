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
@Table(name = "category")
public class Category {
	
	@Id
	@Column(name =  "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter(value = AccessLevel.PROTECTED)
	private long categoryId;
	@Column(name = "user_id")
	private long userId;
	@Column(name =  "name")
	private String name;
	@Column(name =  "created_at")
	private Date createdDate;

}
