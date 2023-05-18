import java.awt.Graphics2D;

public abstract class Drawing {
    private int width;
    private int height;
    private int level;

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public abstract void drawShape(Graphics2D graphics2D);
}
