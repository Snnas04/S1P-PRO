import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingTabbed extends JFrame {
    CardLayout actual, cardLayoutNormal, cardLayoutDinamic;
    JPanel cardsPanel1, cardsPanel2;
    JPopupMenu popupMenu1, popupMenu2;
    ArrayList<DrawingPanel> figurasNormales = new ArrayList<>();
    ArrayList<DrawingPanel> figurasDinamic = new ArrayList<>();
    int indiceFigura = 0;

    public DrawingTabbed() {
        super("Figures: Hilbert curve (normal)");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //CREAM ELS DOS PANELLS PRINCIPALS I ELS DOS CARDLAYOUT
        cardLayoutNormal = new CardLayout();
        cardLayoutDinamic = new CardLayout();
        cardsPanel1 = new JPanel(cardLayoutNormal);
        cardsPanel2 = new JPanel(cardLayoutDinamic);

        //INDICAM EL CARDLAYOUT ACTUAL
        actual = cardLayoutNormal;

        //INICIALITZAM LES FIGURES
        DrawingPanel hilbertPanel = new HilbertCurve(4);
        DrawingPanel hilbertDinamicPanel = new HilbertCurveDinamic(4);
        DrawingPanel mengerPanel = new MengerCarpet(3);
        DrawingPanel mengerDinamicPanel = new MengerCarpetDinamic(3);
        DrawingPanel polynskiPanel = new Polynski(4, 7);
        DrawingPanel polynskiDinamicPanel = new PolynskiDinamic(4, 7);
        DrawingPanel sierpinskiPanel = new SierpinskiTriangle(4);
        DrawingPanel sierpinskiDinamicPanel = new SierpinskiTriangleDinamic(4);

        //AFEGIM LES FIGURES A L'ARRAY CORRESPONENT
        figurasNormales.add(hilbertPanel);
        figurasDinamic.add(hilbertDinamicPanel);
        figurasNormales.add(mengerPanel);
        figurasDinamic.add(mengerDinamicPanel);
        figurasNormales.add(polynskiPanel);
        figurasDinamic.add(polynskiDinamicPanel);
        figurasNormales.add(sierpinskiPanel);
        figurasDinamic.add(sierpinskiDinamicPanel);

        //PER CADA FIGURA DINS L'ARRAY 'figuresNormals' l'afegim a 'cardsPanel1'
        for (int i = 0; i < figurasNormales.size(); i++) {
            DrawingPanel figura = figurasNormales.get(i);
            cardsPanel1.add(figura, String.valueOf(i));
        }

        //PER CADA FIGURA DINS L'ARRAY 'figurasDinamic' l'afegim a 'cardsPanel2'
        for (int i = 0; i < figurasDinamic.size(); i++) {
            DrawingPanel figura = figurasDinamic.get(i);
            cardsPanel2.add(figura, String.valueOf(i));
        }

        //CREAM ELS DOS POPUPMENU
        popupMenu1 = new JPopupMenu();
        popupMenu2 = new JPopupMenu();

        //PER CADA FIGURA DINS L'ARRAY 'figuresNormals' l'afegim a 'popupMenu1' I UN ACTION_LISTENER PER QUAN SIGUI SELECCIONAT
        for (int i = 0; i < figurasNormales.size(); i++) {
            DrawingPanel figura = figurasNormales.get(i);
            JMenuItem item = new JMenuItem(figura.getTitle());
            int finalI = i;
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actual.show(cardsPanel1, String.valueOf(finalI));
                    indiceFigura = finalI;
                    setTitle("Figures: " + figurasNormales.get(indiceFigura).getTitle() + " (normal)");
                }
            });
            popupMenu1.add(item);
        }

        //PER CADA FIGURA DINS L'ARRAY 'figurasDinamic' l'afegim a 'popupMenu2' I UN ACTION_LISTENER PER QUAN SIGUI SELECCIONAT
        for (int i = 0; i < figurasDinamic.size(); i++) {
            DrawingPanel figura = figurasDinamic.get(i);
            JMenuItem item = new JMenuItem(figura.getTitle());
            int finalI = i;
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actual.show(cardsPanel2, String.valueOf(finalI));
                    indiceFigura = finalI;
                    setTitle("Figures: " + figurasDinamic.get(indiceFigura).getTitle() + " (responsive)");
                }
            });
            popupMenu2.add(item);
        }

        //MOUSE_LISTENER PER SI FEIM CLIC DRET A 'cardsPanel1'
        cardsPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    popupMenu1.show(cardsPanel1, evt.getX(), evt.getY());
                }
            }
        });

        //MOUSE_LISTENER PER SI FEIM CLIC DRET A 'cardsPanel2'
        cardsPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    popupMenu2.show(cardsPanel2, evt.getX(), evt.getY());
                }
            }
        });

        setFocusable(true);
        requestFocus();

        //PER DEFECTE
        getContentPane().add(cardsPanel1);
        getContentPane().setBackground(new Color(0x191919));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                String keyName = KeyEvent.getKeyText(keyCode);
                System.out.println(keyName);
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        cambiarFiguraAnterior();
                        break;
                    case KeyEvent.VK_RIGHT:
                        cambiarFiguraSiguiente();
                        break;
                    case KeyEvent.VK_ESCAPE:
                        System.exit(-1);
                        break;
                    case KeyEvent.VK_SPACE:
                        cambiarModo();
                        break;
                    case KeyEvent.VK_UP:
                        subirNivel();
                        break;
                    case KeyEvent.VK_DOWN:
                        bajarNivel();
                        break;
                }
            }
        });
    }

    private void subirNivel() {
        if (actual == cardLayoutNormal) {
            figurasNormales.get(indiceFigura).subirNivel();
            repaint();
        } else {
            figurasDinamic.get(indiceFigura).subirNivel();
            repaint();
        }
    }

    private void bajarNivel() {
        if (actual == cardLayoutNormal) {
            figurasNormales.get(indiceFigura).bajarNivel();
            repaint();
        } else {
            figurasDinamic.get(indiceFigura).bajarNivel();
            repaint();
        }
    }



    // PER cambiarFiguraAnterior SEGONS ESTEIM DINS LES FIGURES NORMALS O RESPONSIVE
    private void cambiarFiguraAnterior() {
        if (actual == cardLayoutNormal) {
            cardLayoutNormal.previous(cardsPanel1);
            indiceFigura = (indiceFigura - 1 + figurasNormales.size()) % figurasNormales.size();
            setTitle("Figures: " + figurasNormales.get(indiceFigura).getTitle() + " (normal)");
        } else {
            cardLayoutDinamic.previous(cardsPanel2);
            indiceFigura = (indiceFigura - 1 + figurasDinamic.size()) % figurasDinamic.size();
            setTitle("Figures: " + figurasDinamic.get(indiceFigura).getTitle() + " (responsive)");
        }
    }

    // PER cambiarFiguraSiguiente SEGONS ESTEIM DINS LES FIGURES NORMALS O RESPONSIVE
    private void cambiarFiguraSiguiente() {
        if (actual == cardLayoutNormal) {
            cardLayoutNormal.next(cardsPanel1);
            indiceFigura = (indiceFigura + 1) % figurasNormales.size();
            setTitle("Figures: " + figurasNormales.get(indiceFigura).getTitle() + " (normal)");
        } else {
            cardLayoutDinamic.next(cardsPanel2);
            indiceFigura = (indiceFigura + 1) % figurasDinamic.size();
            setTitle("Figures: " + figurasDinamic.get(indiceFigura).getTitle() + " (responsive)");
        }
    }

    // PER CANVIAR EL MODE (de cardLayoutNormal a cardLayoutDinamic o viceversa)
    // I SEGUIR DINS EL MATEIX INDEX DINS DELS DOS ARRAYS PER CAMBIAR AMB LA MATEIXA FIGURA
    private void cambiarModo() {
        if (actual == cardLayoutNormal) {
            actual = cardLayoutDinamic;
            getContentPane().remove(cardsPanel1);
            getContentPane().add(cardsPanel2);
            setTitle("Figures: " + figurasDinamic.get(indiceFigura).getTitle() + " (responsive)");
        } else {
            actual = cardLayoutNormal;
            getContentPane().remove(cardsPanel2);
            getContentPane().add(cardsPanel1);
            setTitle("Figures: " + figurasNormales.get(indiceFigura).getTitle() + " (normal)");
        }

        if (actual == cardLayoutNormal) {
            cardLayoutNormal.show(cardsPanel1, String.valueOf(indiceFigura));
        } else {
            cardLayoutDinamic.show(cardsPanel2, String.valueOf(indiceFigura));
        }

        pack();
        setLocationRelativeTo(null);
    }
}
