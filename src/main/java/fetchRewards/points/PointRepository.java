package fetchRewards.points;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, String> {
    List<Point> findAllByCustomer(String customer);
}
