package com.github.steroidteam.todolist.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * A class that represents a to-do list.
 * <p>
 * You need to specify a title for the to-do list
 * and later you will be able to add Task into it.
 * Upon the creation of a to-do list, the Date is saved and
 * reuse to define the ID of the to-do list.
 */
public class TodoList {

    private final UUID id;
    private List<Task> list;
    private String title;
    private Date date;

    /**
     * Constructs a new to-do list.
     *
     * @param title The title of the to-do list.
     * @throws IllegalArgumentException Thrown if the title is empty.
     */
    public TodoList(String title) {
        if(title == null) {
            throw new IllegalArgumentException();
        }
        this.id = UUID.randomUUID();
        this.list = new ArrayList<>();
        this.title = title;
        this.date = new Date(System.currentTimeMillis());
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void removeTask(Integer index) {
        if(index >= 0 && index < list.size()) {
            //Need to cast the index to int.
            //Otherwise we use .remove(Object o) and not .remove(int index) as wanted.
            list.remove((int)index);
        }
    }

    public Task getTask(Integer index) {
        if(index >= 0 && index < list.size()) {
            return list.get(index);
        }
        else {
            return null;
        }
    }

    public int getSize() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public Date getDate() {
        return this.date;
    }

    public UUID getId() {
        return this.id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Todo-List{");
        for (Task task: this.list) {
            str.append(task.toString()).append(",").append("\n");
        }
        str.append("}");

        return str.toString();
    }
}
