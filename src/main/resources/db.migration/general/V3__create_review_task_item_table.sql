CREATE SEQUENCE IF NOT EXISTS review_task_item_id_seq START WITH 1 INCREMENT BY 1;

CREATE TABLE review_task_item
(
    id             BIGINT  NOT NULL,
    review_task_id BIGINT,
    word_entry_id  BIGINT,
    attempts       INTEGER NOT NULL,
    CONSTRAINT pk_reviewtaskitem PRIMARY KEY (id)
);

ALTER TABLE review_task_item
    ADD CONSTRAINT FK_REVIEWTASKITEM_ON_REVIEWTASK FOREIGN KEY (review_task_id) REFERENCES review_task (id);