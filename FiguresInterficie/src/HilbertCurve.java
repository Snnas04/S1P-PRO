import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;

public class HilbertCurve {

    private static final int FORWARD_DISTANCE = 10;
    private static final int TURN_ANGLE = 90;

    public static List<Line2D> drawHilbertCurve(int order) {
        List<Line2D> lines = new ArrayList<>();
        Turtle turtle = new Turtle();
        turtle.moveTo(0, 0);
        drawHilbertCurve(order, turtle, lines);
        return lines;
    }

    private static void drawHilbertCurve(int order, Turtle turtle, List<Line2D> lines) {
        if (order == 0) {
            return;
        }

        turtle.turn(TURN_ANGLE);
        drawHilbertCurve(order - 1, turtle, lines);
        turtle.forward(FORWARD_DISTANCE);
        turtle.turn(-TURN_ANGLE);
        drawHilbertCurve(order - 1, turtle, lines);
        turtle.forward(FORWARD_DISTANCE);
        turtle.turn(TURN_ANGLE);
        drawHilbertCurve(order - 1, turtle, lines);
        turtle.forward(FORWARD_DISTANCE);
        turtle.turn(-TURN_ANGLE);
        drawHilbertCurve(order - 1, turtle, lines);
    }

    private static class Turtle {

        private Point position;
        private double angle;

        public Turtle() {
            position = new Point(0, 0);
            angle = 0;
        }

        public void moveTo(int x, int y) {
            position.x = x;
            position.y = y;
        }

        public void turn(double angle) {
            this.angle += angle;
        }

        public void forward(int distance) {
            position.x += distance * Math.cos(angle);
            position.y += distance * Math.sin(angle);
        }
    }
}
