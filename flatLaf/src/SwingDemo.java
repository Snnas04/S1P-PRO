import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SwingDemo extends JFrame {
    JButton button;
    JLabel label;

    int counter = 0;

    public SwingDemo() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    public void createAndShowGUI() {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            FlatMacDarkLaf.updateUI();
        }
        catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setPreferredSize(new Dimension(800, 600));
        setLayout(null);
        pack();

        button = new JButton("click to exit");
        button.setBounds(300, 280, 200, 40);
        button.addMouseListener(buttonListener());

        add(button);

        label = new JLabel();
        label.setBounds(300, 180, 200, 40);

        Font labelFont = label.getFont();
        label.setFont(new Font(labelFont.getName(), Font.PLAIN, 48));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        add(label);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    MouseListener buttonListener() {
        return new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label.setText(String.valueOf(++counter));
            }
        };
    }

    public static void main(String[] args) {
        new SwingDemo();
    }
}

