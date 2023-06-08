import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingTabbed extends JFrame {
    private JComponent currentFigure;
    private JPopupMenu popupMenu;
    private int level;

    public DrawingTabbed() {
        super("Figures");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        level = 4;
        currentFigure = new HilbertCurve(level);
        getContentPane().add(currentFigure);

        getContentPane().setBackground(new Color(0x191919));

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crear el menú contextual
        popupMenu = new JPopupMenu();
        JMenuItem hilbertItem = new JMenuItem("Hilbert");
        JMenuItem mengerItem = new JMenuItem("Menger");
        JMenuItem mengerDynamicItem = new JMenuItem("Menger Dynamic");
        JMenuItem polynskiItem = new JMenuItem("Polynski");
        JMenuItem sierpinskiItem = new JMenuItem("Sierpinski");
        JMenuItem sierpinskiDynamicItem = new JMenuItem("Sierpinski Dynamic");

        // Agregar los listeners de acción a los elementos del menú contextual
        hilbertItem.addActionListener(e -> changeFigure(new HilbertCurve(level)));
        mengerItem.addActionListener(e -> changeFigure(new MengerCarpet(level)));
        mengerDynamicItem.addActionListener(e -> changeFigure(new MengerCarpetDinamic(level)));
        polynskiItem.addActionListener(e -> changeFigure(new Polynski(level, 7)));
        sierpinskiItem.addActionListener(e -> changeFigure(new SierpinskiTriangle(level)));
        sierpinskiDynamicItem.addActionListener(e -> changeFigure(new SierpinskiTriangleDinamic(level)));

        // Agregar los elementos al menú contextual
        popupMenu.add(hilbertItem);
        popupMenu.add(mengerItem);
        popupMenu.add(mengerDynamicItem);
        popupMenu.add(polynskiItem);
        popupMenu.add(sierpinskiItem);
        popupMenu.add(sierpinskiDynamicItem);

        // Agregar el listener de clic derecho para mostrar el menú contextual
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(DrawingTabbed.this, e.getX(), e.getY());
                }
            }
        });

        // Agregar el listener de teclado para cambiar de figura con las flechas derecha e izquierda
        // y aumentar o disminuir el nivel con las flechas arriba y abajo
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_RIGHT) {
                    changeToNextFigure();
                } else if (keyCode == KeyEvent.VK_LEFT) {
                    changeToPreviousFigure();
                } else if (keyCode == KeyEvent.VK_UP) {
                    increaseLevel();
                } else if (keyCode == KeyEvent.VK_DOWN) {
                    decreaseLevel();
                }
            }
        });

        setFocusable(true);
        requestFocus();
    }

    private void changeFigure(JComponent newFigure) {
        getContentPane().remove(currentFigure);
        currentFigure = newFigure;
        getContentPane().add(currentFigure, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void changeToNextFigure() {
        if (currentFigure instanceof HilbertCurve) {
            changeFigure(new MengerCarpet(level));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new MengerCarpetDinamic(level));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new Polynski(level, 7));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new SierpinskiTriangle(level));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new SierpinskiTriangleDinamic(level));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new HilbertCurve(level));
        }
    }

    private void changeToPreviousFigure() {
        if (currentFigure instanceof HilbertCurve) {
            changeFigure(new SierpinskiTriangleDinamic(level));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new HilbertCurve(level));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new MengerCarpet(level));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new MengerCarpetDinamic(level));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new Polynski(level, 7));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new SierpinskiTriangle(level));
        }
    }

    private void increaseLevel() {
        if (level > 6) {
            level = 1;
            changeFigure(createCurrentFigure());
        }
        else {
            level++;
            changeFigure(createCurrentFigure());
        }
    }

    private void decreaseLevel() {
        if (level > 1) {
            level--;
            changeFigure(createCurrentFigure());
        }
        else {
            level = 7;
            changeFigure(createCurrentFigure());
        }
    }

    private JComponent createCurrentFigure() {
        if (currentFigure instanceof HilbertCurve) {
            return new HilbertCurve(level);
        } else if (currentFigure instanceof MengerCarpet) {
            return new MengerCarpet(level);
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            return new MengerCarpetDinamic(level);
        } else if (currentFigure instanceof Polynski) {
            return new Polynski(level, 7);
        } else if (currentFigure instanceof SierpinskiTriangle) {
            return new SierpinskiTriangle(level);
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            return new SierpinskiTriangleDinamic(level);
        }
        return null;
    }
}
