package points;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Point {

    @Id
    private String payer;
    private Integer points;
    private Date transactionDate;

    public Point() {

    }

    public Point(String payer, Integer points, Date transactionDate) {
        this.payer = payer;
        this.points = points;
        this.transactionDate = transactionDate;

    }

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
}
