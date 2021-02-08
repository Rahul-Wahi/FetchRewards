package fetchRewards.points;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final String currentUser = "FetchRewards"; // hardcoded for now; setup authentication and get current user

    @RequestMapping("")
    public List<Point> getAllPoints() {
        return pointService.getAllPoints(currentUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "add")
    public void addPoint(@RequestBody Point topic) {
        pointService.addPoint(topic);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "deduct")
    public List<Point> deductPoint(@RequestBody DeductPoint deductPoint) {
        return pointService.deductPoint(deductPoint, currentUser);
    }

}
