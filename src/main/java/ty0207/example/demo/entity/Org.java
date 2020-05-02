package ty0207.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class Org {
    private Long id;
    private String name = "";
    private List<Activity> activitiestoreview=new ArrayList<>();
    private List<Activity> activitiesongoing=new ArrayList<>();
    private List<Activity> recordstoreview=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivitiestoreview() {
        return activitiestoreview;
    }

    public void setActivitiestoreview(List<Activity> activitiestoreview) {
        this.activitiestoreview = activitiestoreview;
    }

    public List<Activity> getActivitiesongoing() {
        return activitiesongoing;
    }

    public void setActivitiesongoing(List<Activity> activitiesongoing) {
        this.activitiesongoing = activitiesongoing;
    }

    public List<Activity> getRecordstoreview() {
        return recordstoreview;
    }

    public void setRecordstoreview(List<Activity> recordstoreview) {
        this.recordstoreview = recordstoreview;
    }
}
