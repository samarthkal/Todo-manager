package com.todo.dao;

import com.todo.models.Todo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class TodoDao {

   private JdbcTemplate template;

   Logger logger= LoggerFactory.getLogger(TodoDao.class);

    public TodoDao( @Autowired JdbcTemplate template) {
        this.template = template;

        // create table if not exits

        String createTable=" create table IF NOT EXISTS todo_manager(id int primary key,title varchar(100) not null,content varchar(500)," +
                "status varchar(50) not null,addedDate datetime,todoDate datetime)";

        int update = template.update(createTable);
        logger.info("TODO_Manger Table Created.. {}",update);
    }

    public JdbcTemplate getTemplate() {
        return template;
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;


    }
    // save the todo  to database
    public Todo savaTodo(Todo todo){

        String insertQuery=" insert into todo_manager(id,title,content,status,addedDate,todoDate) values(?,?,?,?,?,?) ";

        int update = template.update(insertQuery, todo.getId(), todo.getContent(), todo.getStatus(), todo.getTodoDate(), todo.getAddedDate());

        logger.info("JDBC Operation: inserted {}",update);
return todo;

    }


    // get single todo from db

    // get all todos

    // delete todo

}
