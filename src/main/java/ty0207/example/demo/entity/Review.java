package ty0207.example.demo.entity;

public class Review {
    private Long id;
    private Long studentid;

    private String description="";

    private String reviewtype="";

    private Double score=0.00;

    public String getReviewtype() {
        return reviewtype;
    }

    public void setReviewtype(String reviewtype) {
        this.reviewtype = reviewtype;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentid() {
        return studentid;
    }

    public void setStudentid(Long studentid) {
        this.studentid = studentid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
