package fetchRewards.points.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String payer;

    @NotNull
    private Integer points;

    @JsonIgnore
    private Integer used = 0;

    @JsonIgnore
    private String customer;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date transactionDate;

    public Point() {

    }

    public Point(String payer, Integer points, Date transactionDate, String customer) {
        this.payer = payer;
        this.points = points;
        this.transactionDate = transactionDate;
        this.customer = customer;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

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

    public String getCustomer() { return customer; }

    public void setCustomer(String currentUser) { this.customer = currentUser; }

    public Integer getUsed() { return used; }

    public void setUsed(Integer used) { this.used = used; }
}
