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
        getContentPane().add(currentFigure); // Agregar la figura al panel principal

        setResizable(true);
        setLocationRelativeTo(null);
        setVisible(true);

        // Crear menú popup
        popupMenu = new JPopupMenu();
        JMenuItem hilbertItem = new JMenuItem("Hilbert");
        JMenuItem hilbertDynamicItem = new JMenuItem("Hilbert Dynamic");
        JMenuItem mengerItem = new JMenuItem("Menger");
        JMenuItem mengerDynamicItem = new JMenuItem("Menger Dynamic");
        JMenuItem sierpinskiItem = new JMenuItem("Sierpinski");
        JMenuItem sierpinskiDynamicItem = new JMenuItem("Sierpinski Dynamic");
        JMenuItem polinskiDynamicItem = new JMenuItem("Polinski Dynamic");
        JMenuItem polynskiItem = new JMenuItem("Polynski");

        // Agregar listeners de acción a los elementos del menú popup
        hilbertItem.addActionListener(e -> changeFigure(new HilbertCurve(level)));
        hilbertDynamicItem.addActionListener(e -> changeFigure(new HilbertCurveDinamic(level)));
        mengerItem.addActionListener(e -> changeFigure(new MengerCarpet(level)));
        mengerDynamicItem.addActionListener(e -> changeFigure(new MengerCarpetDinamic(level)));
        sierpinskiItem.addActionListener(e -> changeFigure(new SierpinskiTriangle(level)));
        sierpinskiDynamicItem.addActionListener(e -> changeFigure(new SierpinskiTriangleDinamic(level)));
        polynskiItem.addActionListener(e -> changeFigure(new Polynski(level, 7)));
        polinskiDynamicItem.addActionListener(e -> changeFigure(new PolynskiDinamic(level, 7)));

        // Agregar elementos al menú popup en el orden deseado
        popupMenu.add(hilbertItem);
        popupMenu.add(hilbertDynamicItem);
        popupMenu.add(mengerItem);
        popupMenu.add(mengerDynamicItem);
        popupMenu.add(sierpinskiItem);
        popupMenu.add(sierpinskiDynamicItem);
        popupMenu.add(polynskiItem);
        popupMenu.add(polinskiDynamicItem);

        // Listener del ratón para mostrar el menú emergente
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(DrawingTabbed.this, e.getX(), e.getY());
                }
            }
        });

        // Listener del teclado para cambiar de figuras con las flechas right y left
        // y para cambiar el nivel con las flechas up y down
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

    // Cambio de figura
    private void changeFigure(JComponent newFigure) {
        getContentPane().remove(currentFigure); // Eliminar la figura actual
        currentFigure = newFigure; // Establecer la nueva figura
        getContentPane().add(currentFigure, BorderLayout.CENTER); // Agregar la nueva figura
        revalidate();
        repaint();
    }

    // Cambiar a la siguiente figura
    private void changeToNextFigure() {
        if (currentFigure instanceof HilbertCurve) {
            changeFigure(new HilbertCurveDinamic(level));
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            changeFigure(new MengerCarpet(level));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new MengerCarpetDinamic(level));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new SierpinskiTriangle(level));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new SierpinskiTriangleDinamic(level));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new Polynski(level, 7));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new PolynskiDinamic(level, 7));
        } else if (currentFigure instanceof PolynskiDinamic) {
            changeFigure(new HilbertCurve(level));
        }
    }

    // Cambiar a la figura anterior
    private void changeToPreviousFigure() {
        if (currentFigure instanceof HilbertCurve) {
            changeFigure(new PolynskiDinamic(level, 7));
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            changeFigure(new HilbertCurve(level));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new HilbertCurveDinamic(level));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new MengerCarpet(level));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new MengerCarpetDinamic(level));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new SierpinskiTriangle(level));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new SierpinskiTriangleDinamic(level));
        } else if (currentFigure instanceof PolynskiDinamic) {
            changeFigure(new Polynski(level, 7));
        }
    }

    // Aumentar el nivel de la figura
    private void increaseLevel() {
        if (level > 6) {
            level = 1;
        } else {
            level++;
        }
        changeFigure(createCurrentFigure());
    }

    // Disminuir el nivel de la figura
    private void decreaseLevel() {
        if (level > 1) {
            level--;
        } else {
            level = 7;
        }
        changeFigure(createCurrentFigure());
    }

    // Crear la figura actual
    private JComponent createCurrentFigure() {
        if (currentFigure instanceof HilbertCurve) {
            return new HilbertCurve(level);
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            return new HilbertCurveDinamic(level);
        } else if (currentFigure instanceof MengerCarpet) {
            return new MengerCarpet(level);
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            return new MengerCarpetDinamic(level);
        } else if (currentFigure instanceof SierpinskiTriangle) {
            return new SierpinskiTriangle(level);
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            return new SierpinskiTriangleDinamic(level);
        } else if (currentFigure instanceof Polynski) {
            return new Polynski(level, 7);
        } else if (currentFigure instanceof PolynskiDinamic) {
            return new PolynskiDinamic(level, 7);
        }
        return null;
    }
}
