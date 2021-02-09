package fetchRewards.points.validation;

import fetchRewards.points.entity.DeductPoint;
import fetchRewards.points.entity.Point;
import org.springframework.stereotype.Component;

@Component
public class Validator {

    public void validateAddPoint(Point point) {
        String payer = point.getPayer();
        Integer points = point.getPoints();

        if(payer == null || payer.trim().isEmpty()) {
            throw new IllegalArgumentException("Please provide payer name");
        }

        if (points == null) {
            throw new IllegalArgumentException("Please provide points to add");
        }

        if (points <= 0) {
            throw new IllegalArgumentException("Number of points should be positive");
        }
    }

    public void validateDeductPoint(DeductPoint deductPoint, int totalBalance) {
        Integer points = deductPoint.getPoints();

        if (points == null) {
            throw new IllegalArgumentException("Please provide points to deduct");
        }

        if (points <= 0) {
            throw new IllegalArgumentException("Number of points to be deducted should pe positive");
        }

        if (points > totalBalance) {
            throw new IllegalArgumentException("Number of points to be deducted should be less than the total balance : "
                    + totalBalance);
        }
    }
}
