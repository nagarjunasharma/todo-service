CREATE TABLE todo_item
(
   todo_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
   description varchar(255) NOT NULL,
   created_at timestamp DEFAULT CURRENT_TIMESTAMP,
   due_date date,
   created_by varchar(255) NOT NULL,
   is_completed tinyint NOT NULL
)
;
CREATE UNIQUE INDEX PRIMARY ON todo_item(todo_id)
;
