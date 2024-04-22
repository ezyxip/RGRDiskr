package com.ezyxip.graph.menu;

import java.util.Objects;

public class MenuItem{
    public String description;
    public Runnable job;

    public MenuItem(String description, Runnable job){
        this.description = description;
        this.job = job;
    }

    protected MenuItem(String description){
        this.description = description;
        job = ()->{};
    }

    protected void addJob(Runnable job){
        this.job = job;
    }

    public void run(){
        job.run();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(description, menuItem.description) && Objects.equals(job, menuItem.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, job);
    }
}