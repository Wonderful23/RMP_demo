package ty0207.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private Long id = -1L;

    private String password="";

    private List<Activity> activities=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }
}
