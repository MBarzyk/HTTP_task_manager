package com.javagda25.tasks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class Task {
    private Long id;
    private String name;
    private LocalDateTime creationTime;
    private boolean done;
    private String creator;

    public Task(Long id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.creationTime = LocalDateTime.now();
        this.done = false;
    }
}
