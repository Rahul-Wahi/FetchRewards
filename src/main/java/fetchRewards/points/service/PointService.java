package fetchRewards.points.service;

import fetchRewards.points.entity.DeductPoint;
import fetchRewards.points.repository.PointRepository;
import fetchRewards.points.entity.Point;
import fetchRewards.points.entity.PointBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PointService {

    @Autowired
    private PointRepository pointRepository;

    @Autowired
    private PointBalanceService pointBalanceService;

    int totalPoints;

    public List<Point> getAllPoints (String customer) {
        return new ArrayList<>(pointRepository.findAllByCustomer(customer));
    }

    public void addPoint(@NotNull Point point) {
        totalPoints = totalPoints + point.getPoints();
        point.setTransactionDate(new Date());

        PointBalance pointBalance = pointBalanceService.find(point.getCustomer(), point.getPayer());

        if (pointBalance == null) {
            pointBalance = new PointBalance(point.getPayer(), point.getCustomer(), 0);
        }

        pointRepository.save(point);

        pointBalance.setBalance(pointBalance.getBalance() + point.getPoints());

        pointBalanceService.updatePointBalance(pointBalance);

    }

    public List<Point> deductPoint (@NotNull DeductPoint deductPoint, String customer) {
        int points = deductPoint.getPoints();
        if (totalPoints < points) {
            return null;
        }

        return deductPoint(points, customer);
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    private List<Point> deductPoint(int points, String customer) {
        Map<String, Integer> result = new HashMap<>();
        ArrayList<Point> newTransactions = new ArrayList<>();

        List<Point> transactions = getAllPoints(customer);
        for (Point transaction : transactions) {
            int remaining = transaction.getPoints() - transaction.getUsed();
            String payer = transaction.getPayer();
            int index = result.getOrDefault(payer, newTransactions.size());
            if (index == newTransactions.size()) {
                result.put(payer, index);
                newTransactions.add(new Point(payer, 0, new Date(), customer));
            }

            Point newPoint = newTransactions.get(index);

            if (remaining > 0) {
                if (remaining >= points) {
                    newPoint.setPoints(newPoint.getPoints() - points);
                    transaction.setUsed(transaction.getUsed() + points);
                    pointRepository.save(transaction);
                    break;
                } else {
                    newPoint.setPoints(newPoint.getPoints() - remaining);
                    transaction.setUsed(transaction.getPoints());
                    pointRepository.save(transaction);
                    points = points - remaining;
                }
            }
        }

        for (Point newTransaction : newTransactions) {
            addPoint(newTransaction);
        }

        return newTransactions;
    }

}
