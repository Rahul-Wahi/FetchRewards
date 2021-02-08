package fetchRewards.points;

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
    int totalPoints;

    public List<Point> getAllPoints (String customer) {
        return new ArrayList<>(pointRepository.findAllByCustomer(customer));
    }

    public void addPoint(@NotNull Point point) {
        totalPoints = totalPoints + point.getPoints();
        point.setTransactionDate(new Date());
        pointRepository.save(point);
    }


    public List<Point> deductPoint (DeductPoint deductPoint, String user) {
        int points = deductPoint.getPoints();
        if (totalPoints < points) {
            return null;
        }

        Map<String, Integer> result = new HashMap<>();
        ArrayList<Point> newTransactions = new ArrayList<>();
        totalPoints =  totalPoints - points;

        List<Point> transactions = getAllPoints(user);
        for (Point transaction : transactions) {
            int remaining = transaction.getPoints() - transaction.getUsed();
            String payer = transaction.getPayer();
            int index = result.getOrDefault(payer, newTransactions.size());
            if (index == newTransactions.size()) {
                result.put(payer, index);
                newTransactions.add(new Point(payer, 0, new Date(), user));
            }

            Point newPoint = newTransactions.get(index);

            if (remaining > 0) {
               if (remaining >= points) {
                   newPoint.setPoints(newPoint.getPoints() - points);
                   transaction.setUsed(transaction.getPoints() - remaining - points);
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
