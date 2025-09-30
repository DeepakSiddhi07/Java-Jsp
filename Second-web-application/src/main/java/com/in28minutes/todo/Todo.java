package com.in28minutes.todo;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

public class Todo {
    private  int id;
    private  String user;

    @Size(min=6,message = "Enter atleast 6 characters ")
    private String desc;
    private Date targetDate;
    private boolean isDone;

    public Todo() {
        super();
    }

    public Todo(int id, boolean isDone, Date targetDate, String user, String desc) {
        super();
        this.id = id;
        this.isDone = isDone;
        this.targetDate = targetDate;
        this.user = user;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public String getDesc() {
        return desc;
    }

    public Date getTargetDate() {
        return targetDate;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setTargetDate(Date targetDate) {
        this.targetDate = targetDate;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return String.format(
                "ToString - Todo [id=%s, user=%s, desc=%s, targetDate=%s ,isDone=%s]",
                id, user, desc, targetDate, isDone
        );
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if (getClass()!= obj.getClass())
            return false;
        Todo other = (Todo) obj;
        if(id != other.id)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
