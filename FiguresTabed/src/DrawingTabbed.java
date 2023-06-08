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
        currentFigure = new HilbertCurve(level); // Crear una figura de Hilbert
        getContentPane().add(currentFigure); // Afegir la figura al panell principal

        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crear menú popup
        popupMenu = new JPopupMenu();
        JMenuItem hilbertItem = new JMenuItem("Hilbert");
        JMenuItem mengerItem = new JMenuItem("Menger");
        JMenuItem mengerDynamicItem = new JMenuItem("Menger Dynamic");
        JMenuItem polynskiItem = new JMenuItem("Polynski");
        JMenuItem sierpinskiItem = new JMenuItem("Sierpinski");
        JMenuItem sierpinskiDynamicItem = new JMenuItem("Sierpinski Dynamic");

        // Afegir listeners d'acció als elements del menu popup
        hilbertItem.addActionListener(e -> changeFigure(new HilbertCurve(level)));
        mengerItem.addActionListener(e -> changeFigure(new MengerCarpet(level)));
        mengerDynamicItem.addActionListener(e -> changeFigure(new MengerCarpetDinamic(level)));
        polynskiItem.addActionListener(e -> changeFigure(new Polynski(level, 7)));
        sierpinskiItem.addActionListener(e -> changeFigure(new SierpinskiTriangle(level)));
        sierpinskiDynamicItem.addActionListener(e -> changeFigure(new SierpinskiTriangleDinamic(level)));

        // Afegir elements al menu popup
        popupMenu.add(hilbertItem);
        popupMenu.add(mengerItem);
        popupMenu.add(mengerDynamicItem);
        popupMenu.add(polynskiItem);
        popupMenu.add(sierpinskiItem);
        popupMenu.add(sierpinskiDynamicItem);

        // Listerner del ratoli per mostar el Popup menu
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(DrawingTabbed.this, e.getX(), e.getY());
                }
            }
        });

        // Listener del teclat per canviar de figures amb les flitxes right i left
        // i per canviar el nivell amb les fletex up i down
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

    // Canvi de figura
    private void changeFigure(JComponent newFigure) {
        getContentPane().remove(currentFigure); // Eliminar la figura actual
        currentFigure = newFigure; // Establir la nueva figura
        getContentPane().add(currentFigure, BorderLayout.CENTER); // Agregar la nova figura
        revalidate();
        repaint();
    }

    // Canviar a la seguent figura
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

    // Canviar a la figura anterior
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

    // Augmentar el nivell de la figura
    private void increaseLevel() {
        if (level > 6) {
            level = 1;
            changeFigure(createCurrentFigure());
        } else {
            level++;
            changeFigure(createCurrentFigure());
        }
    }

    // Disminuir el nivell de la figura
    private void decreaseLevel() {
        if (level > 1) {
            level--;
            changeFigure(createCurrentFigure());
        } else {
            level = 7;
            changeFigure(createCurrentFigure());
        }
    }

    // Crear la figura actual
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
