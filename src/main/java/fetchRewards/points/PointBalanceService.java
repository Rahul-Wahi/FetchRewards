package fetchRewards.points;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointBalanceService {

    @Autowired
    PointBalanceRepository pointBalanceRepository;

    List<PointBalance> getAllPointBalance(String customer) {
        return new ArrayList<>(pointBalanceRepository.findAllByCustomer(customer));
    }

    PointBalance find(String customer, String payer) {
        return pointBalanceRepository.findByCustomerAndPayer(customer, payer);
    }

    public void updatePointBalance(PointBalance pointBalance) {
        pointBalanceRepository.save(pointBalance);
    }
}
