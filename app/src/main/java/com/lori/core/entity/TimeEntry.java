package com.lori.core.entity;

import java.util.Date;

/**
 * @author artemik
 */
public class TimeEntry extends BaseEntity {
    private static final long serialVersionUID = 4644137665916421857L;

    private User user;
    private Date date;
    private Task task;
    private ActivityType activityType;
    private Integer timeInMinutes;

    public TimeEntry() {
    }

    public TimeEntry(TimeEntry fromTimeEntry) {
        setId(fromTimeEntry.getId());
        this.user = fromTimeEntry.getUser();
        this.date = fromTimeEntry.getDate();
        this.task = fromTimeEntry.getTask();
        this.activityType = fromTimeEntry.getActivityType();
        this.timeInMinutes = fromTimeEntry.getTimeInMinutes();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Integer getTimeInMinutes() {
        return timeInMinutes;
    }

    public void setTimeInMinutes(Integer timeInMinutes) {
        this.timeInMinutes = timeInMinutes;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }
}
