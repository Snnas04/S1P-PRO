import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;

class TitleBar extends JPanel {

    Color bgColor = new Color(128, 212, 255);
    Color borderColor = new Color(0, 92, 230);

    TitleBar() {
        this.setPreferredSize(new Dimension(400, 80)); // Size of the title bar
        this.setBackground(bgColor); // Color of the title bar
        JLabel titleText = new JLabel("TODO List - Marc"); // Text of the title bar
        titleText.setPreferredSize(new Dimension(400, 60)); // Size of the text
        titleText.setFont(new Font("Arial", Font.BOLD, 40)); // Font of the text
        titleText.setHorizontalAlignment(JLabel.CENTER); // Align the text to the center
        this.add(titleText); // Add the text to the title bar
    }
}
