package com.marcossilva.todolist.task;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "tb_tasks")
public class TaskModel {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;
    @Column(length = 50)
    private String title;
    private String description;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private String priority;   

    private UUID idUser;

    @CreationTimestamp
    private LocalDateTime createdAt;

    public void setTitle(String title) throws Exception  {
        if(title.length() > 50){
            throw new Exception("Your title has exceeded the 50 character limit!");
        }
        this.title = title;
    }
}
