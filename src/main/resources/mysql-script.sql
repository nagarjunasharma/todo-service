-- Category Table 
CREATE TABLE category
(
   category_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
   user_id bigint,
   name varchar(255) NOT NULL,
   created_at timestamp DEFAULT CURRENT_TIMESTAMP
);

-- item Table
CREATE TABLE item
(
	item_id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
	category_id bigint,
	content varchar(2048) NOT NULL,
	created_at timestamp DEFAULT CURRENT_TIMESTAMP,
	modified_at timestamp,
	due_date date,
	is_completed TINYINT NOT NULL DEFAULT 0,
	INDEX category_id_item (category_id),
	FOREIGN KEY (category_id)
	REFERENCES category(category_id)
	ON DELETE CASCADE
);
