package fetchRewards.points.entity;

import java.io.Serializable;
import java.util.Objects;

public class BalanceId implements Serializable {

    private String payer;
    private String customer;

    public BalanceId() {
    }

    public BalanceId(String payer, String customer) {
        this.payer = payer;
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BalanceId balanceId = (BalanceId) o;
        return Objects.equals(payer, balanceId.payer) &&
                Objects.equals(customer, balanceId.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payer, customer);
    }
}
