-- User Table
CREATE TABLE app_user
(
 user_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
 email_id varchar(512) NOT NULL,
 password varchar(512) NOT NULL,
 created_at timestamp DEFAULT CURRENT_TIMESTAMP,
 modified_at timestamp,
 modified_by varchar(1024),
 UNIQUE KEY unique_email(email_id)
);

-- TODO Table 
CREATE TABLE todo_item
(
   todo_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
   user_id bigint,
   name varchar(255) NOT NULL,
   created_at timestamp DEFAULT CURRENT_TIMESTAMP,
   due_date date,
   created_by varchar(255) NOT NULL,
   is_completed tinyint NOT NULL,
   INDEX todo_user_id (user_id),
   FOREIGN KEY (user_id) 
   REFERENCES app_user(user_id) 
   ON DELETE CASCADE
);

-- TODO Notes Table
CREATE TABLE todo_notes
(
	note_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
	todo_id bigint,
	content varchar(2048) NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	created_by varchar(255) NOT NULL,
	modified_at timestamp,
	modified_by varchar(255),
	INDEX todo_id_todo_notes (todo_id),
	FOREIGN KEY (todo_id)
	REFERENCES todo_item(todo_id)
	ON DELETE CASCADE
);
