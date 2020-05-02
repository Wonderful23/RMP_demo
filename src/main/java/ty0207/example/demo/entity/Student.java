package ty0207.example.demo.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private Long id;
    private String name;
    private String password="";
    private List<Record> records= new ArrayList<>();

    private Double  scoreone = 0.00;
    private Double scoretwo = 0.00;
    private Double scorethree = 0.00;
    private Double scorefour = 0.00;
    private Double scorefive = 0.00;
    private Double scoresix = 0.00;

    private Double total = 0.00;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Record> getRecords() {
        return records;
    }

    public void setRecords(List<Record> records) {
        this.records = records;
    }

    public Double getScoreone() {
        return scoreone;
    }

    public void setScoreone(Double scoreone) {
        this.scoreone = scoreone;
    }

    public Double getScoretwo() {
        return scoretwo;
    }

    public void setScoretwo(Double scoretwo) {
        this.scoretwo = scoretwo;
    }

    public Double getScorethree() {
        return scorethree;
    }

    public void setScorethree(Double scorethree) {
        this.scorethree = scorethree;
    }

    public Double getScorefour() {
        return scorefour;
    }

    public void setScorefour(Double scorefour) {
        this.scorefour = scorefour;
    }

    public Double getScorefive() {
        return scorefive;
    }

    public void setScorefive(Double scorefive) {
        this.scorefive = scorefive;
    }

    public Double getScoresix() {
        return scoresix;
    }

    public void setScoresix(Double scoresix) {
        this.scoresix = scoresix;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
