import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MengerCarpet implements Drawing {

    @Override
    public void draw(int width, int height, int level, Graphics2D graphics2D) {
        drawSierpinskiCarpet(graphics2D, 0, 0, width, height, level);
    }

    private void drawSierpinskiCarpet(Graphics2D graphics2D, double x, double y, double width, double height, int level) {
        if (level == 0) {
            Rectangle2D.Double rect = new Rectangle2D.Double(x, y, width, height);
            graphics2D.fill(rect);
            return;
        }

        double newWidth = width / 3;
        double newHeight = height / 3;

        drawSierpinskiCarpet(graphics2D, x, y, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x + newWidth, y, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x + 2 * newWidth, y, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x, y + newHeight, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x + 2 * newWidth, y + newHeight, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x, y + 2 * newHeight, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x + newWidth, y + 2 * newHeight, newWidth, newHeight, level - 1);
        drawSierpinskiCarpet(graphics2D, x + 2 * newWidth, y + 2 * newHeight, newWidth, newHeight, level - 1);
    }
}
