import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

public class MengerCarpet extends Drawing {
    public MengerCarpet() {
        super();
    }

    @Override
    public void drawShape(Graphics2D graphics2D) {
        int width = getWidth();
        int height = getHeight();
        int level = getLevel();

        drawMengerCarpet(graphics2D, 0, 0, width, height, level);
    }

    private void drawMengerCarpet(Graphics2D graphics2D, double x, double y, double width, double height, int level) {
        if (level == 0) {
            Shape shape = createRectangle(x, y, width, height);
            graphics2D.fill(shape);
            return;
        }

        double newWidth = width / 3;
        double newHeight = height / 3;

        drawMengerCarpet(graphics2D, x, y, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x + newWidth, y, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x + 2 * newWidth, y, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x, y + newHeight, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x + 2 * newWidth, y + newHeight, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x, y + 2 * newHeight, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x + newWidth, y + 2 * newHeight, newWidth, newHeight, level - 1);
        drawMengerCarpet(graphics2D, x + 2 * newWidth, y + 2 * newHeight, newWidth, newHeight, level - 1);
    }

    private Shape createRectangle(double x, double y, double width, double height) {
        return new Rectangle2D.Double(x, y, width, height);
    }
}
