import java.awt.Graphics2D;

public abstract class Drawing {
    private int width;
    private int height;
    private int level;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public abstract void draw(Graphics2D graphics2D);
}
