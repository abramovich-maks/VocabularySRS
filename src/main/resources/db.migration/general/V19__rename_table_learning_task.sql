ALTER TABLE learning_task RENAME TO learning_test;

ALTER TABLE question
    RENAME COLUMN learning_task_id TO learning_test_id;
