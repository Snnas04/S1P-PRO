import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class View extends JFrame
{
	BufferedImage image;

	public View(String imageName)
	{
		try
		{
			image = ImageIO.read(new File(imageName));
		}
		catch (IOException e)
		{
			System.err.println("Something went wrong trying to load " + imageName);
		}
		setTitle(imageName + " - " + image.getWidth() + "x" + image.getHeight());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		add(new Interior());
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class Interior extends JPanel
	{
		int width = image.getWidth();
		int height = image.getHeight();

		public Interior()
		{
			setPreferredSize(new Dimension(width >> 2, height >> 2));
		}

		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.drawImage(image, 0, 0, width >> 2, height >> 2, 0, 0, width, height, this);
		}
	}

	public static void main(String[] args)
	{
		new View("architecture.jpg");
		new View("clover.jpg");
		new View("coding.jpg");
		new View("jelly_candies.jpg");
		new View("moon_orbiting_earth.jpg");
		new View("pink_umbrellas.jpg");
		new View("rainbow_sugar_cookies.jpg");
		new View("success.jpg");
		new View("sunny_day.jpg");
	}
}
