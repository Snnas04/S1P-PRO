import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

public class DrawingTabbed extends JFrame
{
    public DrawingTabbed()
    {
        super("Figures");

        try
        {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JTabbedPane drawings = new JTabbedPane();

        drawings.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 17));

        drawings.addTab("Hilbert", new HilbertCurve(6));
        drawings.addTab("Menger", new MengerCarpet(4));
        drawings.addTab("Menger Dinamic", new MengerCarpetDinamic(4));
        drawings.addTab("Polynski", new Polynski(6, 7));
        drawings.addTab("Sierpinski", new SierpinskiTriangle(7));
        drawings.addTab("Sierpinski Dinamic", new SierpinskiTriangleDinamic(7));

        drawings.setBorder(BorderFactory.createEmptyBorder (0, 0, 0, 0));

        getContentPane().add(drawings);

        pack();

        getContentPane().setBackground(new Color(0x191919));

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
