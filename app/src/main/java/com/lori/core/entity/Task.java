package com.lori.core.entity;

/**
 * @author artemik
 */
public class Task extends BaseEntity {
    private static final long serialVersionUID = -6946408499157428585L;

    private String name;
    private Project project;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
