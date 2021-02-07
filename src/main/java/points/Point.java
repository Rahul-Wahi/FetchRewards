package points;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String payer;
    private Integer points;
    private String user;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    public Point() {

    }

    public Point(String payer, Integer points, Date transactionDate) {
        this.payer = payer;
        this.points = points;
        this.transactionDate = transactionDate;

    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String id) {
        this.payer = id;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getUser() { return user; }

    public void setUser(String user) { this.user = user; }
}
