package fetchRewards.points.entity;

import javax.validation.constraints.NotNull;

public class DeductPoint {

    @NotNull
    private Integer points;

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

}
