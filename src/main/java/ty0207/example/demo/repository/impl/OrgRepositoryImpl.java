package ty0207.example.demo.repository.impl;

import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import ty0207.example.demo.entity.Activity;
import ty0207.example.demo.entity.Org;
import ty0207.example.demo.repository.OrgRepository;
import ty0207.example.demo.utils.HandlerJSON;

@Repository
public class OrgRepositoryImpl implements OrgRepository {
    @Value("${RMP}")
    private String RMP_URL;
    @Autowired
    private HandlerJSON handlerJSON;
    @Override
    public Long save(Org org){
        if(org.getId()<100){
            String URL = RMP_URL+"Org/";
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<JSONObject> result = restTemplate.postForEntity(URL,org,JSONObject.class);
            Long id = (Long) result.getBody().get("id");
            return id;
        }else{
            String URL = RMP_URL+"Org/"+org.getId();
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(URL,org);
            return org.getId();
        }
    }
    @Override
    public Org findById(Long id){
        String URL = RMP_URL+"Org/"+id;
        RestTemplate restTemplate = new RestTemplate();
        JSONObject result = restTemplate.getForObject(URL, JSONObject.class);

        return handlerJSON.handlerOrgJSON(result);
    }
}
