package fetchRewards.points.controller;

import fetchRewards.points.entity.DeductPoint;
import fetchRewards.points.response.PointResponse;
import fetchRewards.points.service.PointBalanceService;
import fetchRewards.points.service.PointService;
import fetchRewards.points.validation.Validator;
import fetchRewards.points.entity.Point;
import fetchRewards.points.entity.PointBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/points")
public class PointController {

    @Autowired
    private PointService pointService;

    @Autowired
    private PointBalanceService pointBalanceService;

    @Autowired
    Validator validator;

    private final String currentUser = "FetchRewards"; // hardcoded for now; setup authentication and get current user

    @RequestMapping("transactions")
    public List<Point> getAllPoints() {
        return pointService.getAllPoints(currentUser);
    }

    @RequestMapping("balance")
    public List<PointBalance> getAllPointBalance() {
        return pointBalanceService.getAllPointBalance(currentUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public ResponseEntity<PointResponse> addPoint(@RequestBody Point point) {
        point.setCustomer(currentUser);
        validator.validateAddPoint(point);
        pointService.addPoint(point);
        return new ResponseEntity<>(new PointResponse("Successfully added Points", point), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "deduct")
    public List<Point> deductPoint(@RequestBody DeductPoint deductPoint) {
        validator.validateDeductPoint(deductPoint, pointService.getTotalPoints());
        return pointService.deductPoint(deductPoint, currentUser);
    }

}
