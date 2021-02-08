package fetchRewards.points.response;

import fetchRewards.points.entity.Point;

public class PointResponse {
    private String message;
    private Point point;

    public PointResponse(String message, Point point) {
        this.message = message;
        this.point = point;
    }

    public PointResponse() {

    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
