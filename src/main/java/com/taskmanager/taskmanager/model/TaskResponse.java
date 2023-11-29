package com.taskmanager.taskmanager.model;


public interface TaskResponse {

    Integer getId();
    String getTitre();
    String getContenu();

    public static TaskResponse fromTask(Task task) {
        return new TaskResponse() {

            @Override
            public Integer getId() {
                return task.getId();
            }

            @Override
            public String getTitre() {
                return task.getTitre();
            }

            @Override
            public String getContenu() {
                return task.getContenu();
            }
            
        };
        
    }
    
}