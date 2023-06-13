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
    private int levelHilbert;
    private int levelHilbertDinamic;
    private int levelMenger;
    private int levelMengerDinamic;
    private int levelSierpinski;
    private int levelSierpinskiDinamic;
    private int levelPolynski;
    private int levelPolynskiDinamic;
    private int maxLevel;

    public DrawingTabbed() {
        super("Figures");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setLayout(new GridLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        levelHilbert = 4;
        levelHilbertDinamic = 4;
        levelMenger = 4;
        levelMengerDinamic = 4;
        levelSierpinski = 4;
        levelSierpinskiDinamic = 4;
        levelPolynski = 4;
        levelPolynskiDinamic = 4;
        currentFigure = new HilbertCurve(levelHilbert); // Crear una figura de Hilbert
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
        hilbertItem.addActionListener(e -> changeFigure(new HilbertCurve(levelHilbert)));
        hilbertDynamicItem.addActionListener(e -> changeFigure(new HilbertCurveDinamic(levelHilbertDinamic)));
        mengerItem.addActionListener(e -> changeFigure(new MengerCarpet(levelMenger)));
        mengerDynamicItem.addActionListener(e -> changeFigure(new MengerCarpetDinamic(levelMengerDinamic)));
        sierpinskiItem.addActionListener(e -> changeFigure(new SierpinskiTriangle(levelSierpinski)));
        sierpinskiDynamicItem.addActionListener(e -> changeFigure(new SierpinskiTriangleDinamic(levelSierpinskiDinamic)));
        polynskiItem.addActionListener(e -> changeFigure(new Polynski(levelPolynski, 7)));
        polinskiDynamicItem.addActionListener(e -> changeFigure(new PolynskiDinamic(levelPolynskiDinamic, 7)));

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
                } else if (keyCode == KeyEvent.VK_ESCAPE) {
                    dispose();
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
            changeFigure(new HilbertCurveDinamic(levelHilbertDinamic));
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            changeFigure(new MengerCarpet(levelMenger));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new MengerCarpetDinamic(levelMengerDinamic));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new SierpinskiTriangle(levelSierpinski));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new SierpinskiTriangleDinamic(levelSierpinskiDinamic));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new Polynski(levelPolynski, 7));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new PolynskiDinamic(levelPolynskiDinamic, 7));
        } else if (currentFigure instanceof PolynskiDinamic) {
            changeFigure(new HilbertCurve(levelHilbert));
        }
    }

    // Cambiar a la figura anterior
    private void changeToPreviousFigure() {
        if (currentFigure instanceof HilbertCurve) {
            changeFigure(new PolynskiDinamic(levelPolynskiDinamic, 7));
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            changeFigure(new HilbertCurve(levelHilbert));
        } else if (currentFigure instanceof MengerCarpet) {
            changeFigure(new HilbertCurveDinamic(levelHilbertDinamic));
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            changeFigure(new MengerCarpet(levelMenger));
        } else if (currentFigure instanceof SierpinskiTriangle) {
            changeFigure(new MengerCarpetDinamic(levelMengerDinamic));
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            changeFigure(new SierpinskiTriangle(levelSierpinski));
        } else if (currentFigure instanceof Polynski) {
            changeFigure(new SierpinskiTriangleDinamic(levelSierpinskiDinamic));
        } else if (currentFigure instanceof PolynskiDinamic) {
            changeFigure(new Polynski(levelPolynski, 7));
        }
    }

    // Aumentar el nivel de la figura
    private void increaseLevel() {
        maxLevel = 7;

        if (currentFigure instanceof HilbertCurve) {
            if (levelHilbert > maxLevel - 1) {
                levelHilbert = 1;
            } else {
                levelHilbert++;
            }
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            if (levelHilbertDinamic > maxLevel - 1) {
                levelHilbertDinamic = 1;
            } else {
                levelHilbertDinamic++;
            }
        } else if (currentFigure instanceof MengerCarpet) {
            if (levelMenger > maxLevel - 4) {
                levelMenger = 1;
            } else {
                levelMenger++;
            }
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            if (levelMengerDinamic > maxLevel - 4) {
                levelMengerDinamic = 1;
            } else {
                levelMengerDinamic++;
            }
        } else if (currentFigure instanceof SierpinskiTriangle) {
            if (levelSierpinski > maxLevel) {
                levelSierpinski = 1;
            } else {
                levelSierpinski++;
            }
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            if (levelSierpinskiDinamic > maxLevel) {
                levelSierpinskiDinamic = 1;
            } else {
                levelSierpinskiDinamic++;
            }
        } else if (currentFigure instanceof SierpinskiTriangle) {
            if (levelSierpinski > maxLevel) {
                levelSierpinski = 1;
            } else {
                levelSierpinski++;
            }
        } else if (currentFigure instanceof Polynski) {
            if (levelPolynski > maxLevel - 1) {
                levelPolynski = 1;
            } else {
                levelPolynski++;
            }
        } else if (currentFigure instanceof PolynskiDinamic) {
            if (levelPolynskiDinamic > maxLevel - 1) {
                levelPolynskiDinamic = 1;
            } else {
                levelPolynskiDinamic++;
            }
        }

        changeFigure(createCurrentFigure());
    }

    private void decreaseLevel() {
        maxLevel = 8;

        if (currentFigure instanceof HilbertCurve) {
            if (levelHilbert > 1) {
                levelHilbert--;
            } else {
                levelHilbert = maxLevel - 1;
            }
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            if (levelHilbertDinamic > 1) {
                levelHilbertDinamic--;
            } else {
                levelHilbertDinamic = maxLevel - 1;
            }
        } else if (currentFigure instanceof MengerCarpet) {
            if (levelMenger > 1) {
                levelMenger--;
            } else {
                levelMenger = maxLevel - 4;
            }
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            if (levelMengerDinamic > 1) {
                levelMengerDinamic--;
            } else {
                levelMengerDinamic = maxLevel - 4;
            }
        } else if (currentFigure instanceof SierpinskiTriangle) {
            if (levelSierpinski > 1) {
                levelSierpinski--;
            } else {
                levelSierpinski = maxLevel;
            }
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            if (levelSierpinskiDinamic > 1) {
                levelSierpinskiDinamic--;
            } else {
                levelSierpinskiDinamic = maxLevel;
            }
        } else if (currentFigure instanceof Polynski) {
            if (levelPolynski > 1) {
                levelPolynski--;
            } else {
                levelPolynski = maxLevel - 1;
            }
        } else if (currentFigure instanceof PolynskiDinamic) {
            if (levelPolynskiDinamic > 1) {
                levelPolynskiDinamic--;
            } else {
                levelPolynskiDinamic = maxLevel - 1;
            }
        }

        changeFigure(createCurrentFigure());
    }


    // Crear la figura actual
    private JComponent createCurrentFigure() {
        if (currentFigure instanceof HilbertCurve) {
            return new HilbertCurve(levelHilbert);
        } else if (currentFigure instanceof HilbertCurveDinamic) {
            return new HilbertCurveDinamic(levelHilbertDinamic);
        } else if (currentFigure instanceof MengerCarpet) {
            return new MengerCarpet(levelMenger);
        } else if (currentFigure instanceof MengerCarpetDinamic) {
            return new MengerCarpetDinamic(levelMengerDinamic);
        } else if (currentFigure instanceof SierpinskiTriangle) {
            return new SierpinskiTriangle(levelSierpinski);
        } else if (currentFigure instanceof SierpinskiTriangleDinamic) {
            return new SierpinskiTriangleDinamic(levelSierpinskiDinamic);
        } else if (currentFigure instanceof Polynski) {
            return new Polynski(levelPolynski, 7);
        } else if (currentFigure instanceof PolynskiDinamic) {
            return new PolynskiDinamic(levelPolynskiDinamic, 7);
        }
        return null;
    }
}
