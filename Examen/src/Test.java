import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Test extends JFrame {
	BufferedImage image;
	BufferedImage original;

	public Test(String imageName) {
		try {
			image = ImageIO.read(new File(imageName));
			original = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
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

	class Interior extends JPanel {
		int width = image.getWidth();
		int height = image.getHeight();

		int vertical = width * 2;
		int horizontal = height * 2;


		public Interior() {
			if (width < height) {
				setPreferredSize(new Dimension(vertical, height));
			}
			else {
				setPreferredSize(new Dimension(width, horizontal));
			}
			
			Emboss();
			// EdgeDetection();
			// BlancINegre();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			if (width < height) {
				g.drawImage(original, 0, 0, width, height, null);
				g.drawImage(image, width, 0, width, height, null);
				}
			else {
				g.drawImage(original, 0, 0, width, height, null);
				g.drawImage(image, 0, height, width, height, null);
			}
		}	

		public void BlancINegre() {
			for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    Color color = new Color(image.getRGB(x, y));
                    
                    int luminosity = (int) (0.21 * color.getRed() + 0.72 * color.getGreen() + 0.07 * color.getBlue());
                    
                    Color newColor = new Color(luminosity, luminosity, luminosity);
                    
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
		}

		public void EdgeDetection() {
			int[][] sobelX = {
					{-1, 0, 1},
					{-2, 0, 2},
					{-1, 0, 1}
			};
			int[][] sobelY = {
					{-1, -2, -1},
					{0, 0, 0},
					{1, 2, 1}
			};
		
			BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = grayImage.getGraphics();
			g.drawImage(original, 0, 0, null);
		
			for (int y = 1; y < height - 1; y++) {
				for (int x = 1; x < width - 1; x++) {
					int pixelX = 0, pixelY = 0;
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							int rgb = grayImage.getRGB(x + j, y + i);
							int gray = (int) (0.21 * ((rgb >> 16) & 0xFF) + 0.72 * ((rgb >> 8) & 0xFF) + 0.07 * (rgb & 0xFF));
							pixelX += gray * sobelX[i + 1][j + 1];
							pixelY += gray * sobelY[i + 1][j + 1];
						}
					}
					int magnitude = (int) Math.sqrt(pixelX * pixelX + pixelY * pixelY);
					magnitude = Math.min(magnitude, 255);
					image.setRGB(x, y, new Color(magnitude, magnitude, magnitude).getRGB());
				}
			}
		}

		public void Emboss() {
			int[][] sobelX = {
				{-2, -1, 0},
				{-1, 1, 1},
				{0, 1, 2}
			};
			int[][] sobelY = {
				{0, -1, -2},
				{1, 1, -1},
				{2, 1, 0}
			};
		
			BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = grayImage.getGraphics();
			g.drawImage(original, 0, 0, null);
		
			for (int y = 1; y < height - 1; y++) {
				for (int x = 1; x < width - 1; x++) {
					int pixelX = 0, pixelY = 0;
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							int rgb = grayImage.getRGB(x + j, y + i);
							int gray = (int) (0.21 * ((rgb >> 16) & 0xFF) + 0.72 * ((rgb >> 8) & 0xFF) + 0.07 * (rgb & 0xFF));
							pixelX += gray * sobelX[i + 1][j + 1];
							pixelY += gray * sobelY[i + 1][j + 1];
						}
					}
					int magnitude = (int) Math.sqrt(pixelX * pixelX + pixelY * pixelY);
					magnitude = Math.min(magnitude, 255);
					image.setRGB(x, y, new Color(magnitude, magnitude, magnitude).getRGB());
				}
			}
		}
	}

	public static void main(String[] args) {
		new Test("img/car.jpg");
	}
}
