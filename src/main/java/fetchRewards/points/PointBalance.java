package fetchRewards.points;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.validation.constraints.NotNull;

@Entity
@IdClass(BalanceId.class)
public class PointBalance {

    @Id
    String payer;

    @Id
    @JsonIgnore
    String customer;

    @NotNull
    Integer balance;

    public PointBalance() {
    }

    public PointBalance(String payer, String customer, @NotNull Integer balance) {
        this.payer = payer;
        this.customer = customer;
        this.balance = balance;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

}
