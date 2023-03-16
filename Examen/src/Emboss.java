import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Emboss extends JFrame {
	BufferedImage image;
	BufferedImage original;

	/* 
	 * Cream una contructors i li passam per parametre una imatge 
	 * Cream dues imatges (image i original) d'aquesta manera només aplicam el filtre a nomes una de les imatges
	 */
	public Emboss(String imageName) {
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
		int width = original.getWidth();
		int height = original.getHeight();

		int vertical = width * 2;
		int horizontal = height * 2;

		/* 
		 * Indicam el tamany de la finestra
		 * Tenim un if per fer la finestra més gran de forma vertocal o horitzontal
		 * depenent de les dimencios de l'imatge
		 * Despres cridam al filtre
		 */
		public Interior() {
			if (width < height) {
				setPreferredSize(new Dimension(vertical, height));
			}
			else {
				setPreferredSize(new Dimension(width, horizontal));
			}
			
			EmbossFilter();
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			/* 
			 * Colocam l'imatge damunt la finestra
			 * Ampram l'if per comprovar si l'hem de colocar una devora l'altre o una devall l'altre
			 */
			if (width < height) {
				g.drawImage(original, 0, 0, width, height, null, this);
				g.drawImage(image, width, 0, width, height, null, this);
			}
			else {
				g.drawImage(original, 0, 0, width, height, null, this);
				g.drawImage(image, 0, height, width, height, null, this);
			}
		}	

		public void EmbossFilter() {
			/* 
			 * Indicam els pesos per poder generar correctament el flitre
			 */
			int[][] nucli = {
				{-2, -1, 0},
				{-1, 1, 1},
				{0, 1, 2}
			};
		
			/* 
			 * Cream una imatge a escala de grisos
			 */
			BufferedImage grayImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
			Graphics g = grayImage.getGraphics();
			g.drawImage(original, 0, 0, null);
		
			/* 
			 * Aplicam la matriu del nucli a cada pixel
			 */
			for (int y = 1; y < height - 1; y++) {
				for (int x = 1; x < width - 1; x++) {
					int pixelX = 0, pixelY = 0;
					for (int i = -1; i <= 1; i++) {
						for (int j = -1; j <= 1; j++) {
							int rgb = grayImage.getRGB(x + j, y + i);
							int gray = (int) (0.21 * ((rgb >> 16) & 0xFF) + 0.72 * ((rgb >> 8) & 0xFF) + 0.07 * (rgb & 0xFF));
							pixelX += gray * nucli[i + 1][j + 1];
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
		new Emboss("img/sol.jpg");
	}
}
