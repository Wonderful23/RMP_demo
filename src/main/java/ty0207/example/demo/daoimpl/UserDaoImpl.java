package ty0207.example.demo.daoimpl;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.dao.UserDao;
import ty0207.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @Value("${RMP}")
    private String RMP_URL;


    @Override
    public User createUser(User user){
        String URL = RMP_URL+"User1/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,user,JSONObject.class);
        User user1 = (User) JSONObject.toBean(result.getBody(),User.class);
        return user1;
    }
    @Override
    public boolean modifyUser(User user){
        String URL = RMP_URL+"User1/"+user.getId();
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.put(URL,user);
        return true;
    }
    @Override
    public List<User> findByName(String name){
        String URL = RMP_URL+"User1/?User1.username="+name;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        List<User> userList = new ArrayList<User>();
        JSONArray jsonArray = (JSONArray) result.get("User1");
        for(int i=0;i<jsonArray.size();i++){
            userList.add((User) JSONObject.toBean(jsonArray.getJSONObject(i),User.class));
        }
        return userList;
    }
    @Override
    public List<User> findAll(){
        String URL = RMP_URL+"User1/";
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        List<User> userList = new ArrayList<User>();
        JSONArray jsonArray = (JSONArray) result.get("User1");
        for(int i=0;i<jsonArray.size();i++){
            userList.add((User) JSONObject.toBean(jsonArray.getJSONObject(i),User.class));
        }
        return userList;
    }
}
