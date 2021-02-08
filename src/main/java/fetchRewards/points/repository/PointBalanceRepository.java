package fetchRewards.points.repository;

import fetchRewards.points.entity.PointBalance;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointBalanceRepository extends CrudRepository<PointBalance, String> {
    List<PointBalance> findAllByCustomer(String customer);
    PointBalance findByCustomerAndPayer(String customer, String payer);
}
