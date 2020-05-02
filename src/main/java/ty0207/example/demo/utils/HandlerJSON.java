package ty0207.example.demo.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Component;
import ty0207.example.demo.entity.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class HandlerJSON {

    public Review handlerReviewJSON(JSONObject jsonObject){
        return (Review)JSONObject.toBean(jsonObject,Review.class);
    }
    public Record handlerRecordJSON(JSONObject jsonObject){
        return (Record)JSONObject.toBean(jsonObject,Record.class);
    }
    public Student hanlderStudentJSON(JSONObject jsonObject){
        Student student = new Student();

        List<Record> records = new ArrayList<Record>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("records");
        for(int i=0;i<jsonArray.size();i++){
            records.add((handlerRecordJSON(jsonArray.getJSONObject(i))));
        }
        student.setId((Long)jsonObject.get("id"));
        student.setName((String)jsonObject.get("name"));
        student.setPassword((String)jsonObject.get("password"));
        student.setRecords(records);
        student.setScorefive((jsonObject.getDouble("scorefive")));
        student.setScorefour(jsonObject.getDouble("scorefour"));
        student.setScorethree(jsonObject.getDouble("scorethree"));
        student.setScoretwo(jsonObject.getDouble("scoretwo"));
        student.setScoreone(jsonObject.getDouble("scoreone"));
        student.setScoresix(jsonObject.getDouble("scoresix"));
        student.setTotal(jsonObject.getDouble("total"));
        return student;
    }
    public Activity handlerActivityJSON(JSONObject jsonObject){
        Activity activity = new Activity();
        activity.setName((String)jsonObject.get("name"));
        activity.setActivitystatus((String)jsonObject.get("activitystatus"));
        activity.setActivitytime((String)jsonObject.get("activitytime"));
        activity.setActivitytype((String)jsonObject.get("activitytype"));
        activity.setBasicscore((Double)jsonObject.get("basicscore"));
        activity.setCode((String)jsonObject.get("code"));
        activity.setDescription((String)jsonObject.get("description"));
        activity.setGroupid((Long)jsonObject.get("groupid"));
        activity.setId((Long)jsonObject.get("id"));
        activity.setLocation((String)jsonObject.get("location"));

        List<Student> students = new ArrayList<Student>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("students");
        for(int i=0;i<jsonArray.size();i++){
            students.add(hanlderStudentJSON(jsonArray.getJSONObject(i)));
        }

        List<Review> reviews = new ArrayList<Review>();
        jsonArray = (JSONArray) jsonObject.get("students");
        for(int i=0;i<jsonArray.size();i++){
            reviews.add(handlerReviewJSON(jsonArray.getJSONObject(i)));
        }
        activity.setReviews(reviews);
        activity.setStudents(students);

        return activity;
    }
    public Group handlerGroupJSON(JSONObject jsonObject){
        Group group = new Group();

        List<Activity> activities = new ArrayList<Activity>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("activities");
        for(int i=0;i<jsonArray.size();i++){
            activities.add(handlerActivityJSON(jsonArray.getJSONObject(i)));
        }
        group.setActivities(activities);
        group.setId(jsonObject.getLong("id"));
        group.setPassword(jsonObject.getString("password"));

        return group;
    }

    public Org handlerOrgJSON(JSONObject jsonObject){
        Org org = new Org();

        List<Activity> going = new ArrayList<Activity>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("activitiesongoing");
        for(int i=0;i<jsonArray.size();i++){
            going.add(handlerActivityJSON(jsonArray.getJSONObject(i)));
        }

        List<Activity> review = new ArrayList<Activity>();
        jsonArray = (JSONArray) jsonObject.get("activitiestoreview");
        for(int i=0;i<jsonArray.size();i++){
            review.add(handlerActivityJSON(jsonArray.getJSONObject(i)));
        }

        List<Activity> records = new ArrayList<Activity>();
        jsonArray = (JSONArray) jsonObject.get("recordstoreview");
        for(int i=0;i<jsonArray.size();i++){
            records.add(handlerActivityJSON(jsonArray.getJSONObject(i)));
        }

        org.setActivitiesongoing(going);
        org.setActivitiestoreview(review);
        org.setRecordstoreview(records);
        org.setId(jsonObject.getLong("id"));
        org.setName(jsonObject.getString("name"));

        return  org;
    }
}
