package fetchRewards.points.service;

import fetchRewards.points.repository.PointBalanceRepository;
import fetchRewards.points.entity.PointBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PointBalanceService {

    @Autowired
    PointBalanceRepository pointBalanceRepository;

    public List<PointBalance> getAllPointBalance(String customer) {
        return new ArrayList<>(pointBalanceRepository.findAllByCustomer(customer));
    }

    public PointBalance find(String customer, String payer) {
        return pointBalanceRepository.findByCustomerAndPayer(customer, payer);
    }

    public void updatePointBalance(PointBalance pointBalance) {
        pointBalanceRepository.save(pointBalance);
    }
}
