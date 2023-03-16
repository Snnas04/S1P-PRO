import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlackAndWhite extends JFrame {
	BufferedImage imageMod;
	BufferedImage original;

	/* 
	 * Cream una contructors i li passam per parametre una imatge 
	 * Cream dues imatges (image i original) d'aquesta manera només aplicam el filtre a nomes una de les imatges
	 */
	public BlackAndWhite(String imageName) {
		try {
			imageMod = ImageIO.read(new File(imageName));
			original = ImageIO.read(new File(imageName));
		}
		catch (IOException e) {
			System.err.println("Something went wrong trying to load " + imageName);
		}

		setTitle(imageName + " - " + imageMod.getWidth() + "x" + imageMod.getHeight());
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
		 * Despers cridam al filtre
		 */
		public Interior() {
			if (width < height) {
				setPreferredSize(new Dimension(vertical, height));
			}
			else {
				setPreferredSize(new Dimension(width, horizontal));
			}
			
			BlancINegreFilter();
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
				g.drawImage(imageMod, width, 0, width, height, null, this);
			}
			else {
				g.drawImage(original, 0, 0, width, height, null, this);
				g.drawImage(imageMod, 0, height, width, height, null, this);
			}
		}	

		/* 
		 * Cream un nou metodo el qual aplica un filtre d'escales de grisos
		 */
		public void BlancINegreFilter() {
			for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
					// agafam els colors de l'imatge original
                    Color color = new Color(original.getRGB(x, y));
                    
                    int luminosity = (int) (0.21 * color.getRed() + 0.72 * color.getGreen() + 0.07 * color.getBlue());
                    
                    Color newColor = new Color(luminosity, luminosity, luminosity);
                    
					// aplicam els nous colors a l'imatge modificada
                    imageMod.setRGB(x, y, newColor.getRGB());
                }
            }
		}
	}

	public static void main(String[] args) {
		new BlackAndWhite("img/ellie.jpg");
	}
}
