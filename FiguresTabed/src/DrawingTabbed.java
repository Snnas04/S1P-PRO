import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingTabbed extends JFrame {
    CardLayout actual, cardLayoutNormal, cardLayoutDinamic;
    JPanel cardsPanelNormal, cardsPanelDinamic;
    JPopupMenu popupMenuNormal, popupMenuDinamic;
    ArrayList<DrawingPanel> figurasNormales = new ArrayList<>();
    ArrayList<DrawingPanel> figurasDinamic = new ArrayList<>();
    int indiceFigura = 0;

    public DrawingTabbed() {
        super("Figures");

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Creamos los dos paneles principales y los dos cardLayout
        cardLayoutNormal = new CardLayout();
        cardLayoutDinamic = new CardLayout();
        cardsPanelNormal = new JPanel(cardLayoutNormal);
        cardsPanelDinamic = new JPanel(cardLayoutDinamic);

        // Indicamos el cardLayout actual
        actual = cardLayoutNormal;

        // Inicializamos las figuras
        DrawingPanel hilbertPanel = new HilbertCurve(4);
        DrawingPanel hilbertDinamicPanel = new HilbertCurveDinamic(4);
        DrawingPanel mengerPanel = new MengerCarpet(3);
        DrawingPanel mengerDinamicPanel = new MengerCarpetDinamic(3);
        DrawingPanel polynskiPanel = new Polynski(4, 7);
        DrawingPanel polynskiDinamicPanel = new PolynskiDinamic(4, 7);
        DrawingPanel sierpinskiPanel = new SierpinskiTriangle(4);
        DrawingPanel sierpinskiDinamicPanel = new SierpinskiTriangleDinamic(4);

        // Añadimos las figuras a los arrays correspondientes
        figurasNormales.add(hilbertPanel);
        figurasDinamic.add(hilbertDinamicPanel);
        figurasNormales.add(mengerPanel);
        figurasDinamic.add(mengerDinamicPanel);
        figurasNormales.add(polynskiPanel);
        figurasDinamic.add(polynskiDinamicPanel);
        figurasNormales.add(sierpinskiPanel);
        figurasDinamic.add(sierpinskiDinamicPanel);

        // Por cada figura en el array 'figurasNormales', la agregamos a 'cardsPanelNormal'
        for (int i = 0; i < figurasNormales.size(); i++) {
            DrawingPanel figura = figurasNormales.get(i);
            cardsPanelNormal.add(figura, String.valueOf(i));
        }

        // Por cada figura en el array 'figurasDinamic', la agregamos a 'cardsPanelDinamic'
        for (int i = 0; i < figurasDinamic.size(); i++) {
            DrawingPanel figura = figurasDinamic.get(i);
            cardsPanelDinamic.add(figura, String.valueOf(i));
        }

        // Creamos los dos menús emergentes
        popupMenuNormal = new JPopupMenu();
        popupMenuDinamic = new JPopupMenu();

        // Por cada figura en el array 'figurasNormales', la agregamos a 'popupMenuNormal'
        // y un ActionListener para cuando sea seleccionada
        for (int i = 0; i < figurasNormales.size(); i++) {
            DrawingPanel figura = figurasNormales.get(i);
            JMenuItem item = new JMenuItem(figura.getTitle());
            int finalI = i;
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actual.show(cardsPanelNormal, String.valueOf(finalI));
                    indiceFigura = finalI;
                    setTitle("Figures: " + figurasNormales.get(indiceFigura).getTitle() + " (normal)");
                }
            });
            popupMenuNormal.add(item);
        }

        // Por cada figura en el array 'figurasDinamic', la agregamos a 'popupMenuDinamic'
        // y un ActionListener para cuando sea seleccionada
        for (int i = 0; i < figurasDinamic.size(); i++) {
            DrawingPanel figura = figurasDinamic.get(i);
            JMenuItem item = new JMenuItem(figura.getTitle());
            int finalI = i;
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actual.show(cardsPanelDinamic, String.valueOf(finalI));
                    indiceFigura = finalI;
                    setTitle("Figures: " + figurasDinamic.get(indiceFigura).getTitle() + " (responsive)");
                }
            });
            popupMenuDinamic.add(item);
        }

        // MouseListener para mostrar el menú emergente popupMenuNormal al hacer clic derecho en 'cardsPanelNormal'
        cardsPanelNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    popupMenuNormal.show(cardsPanelNormal, evt.getX(), evt.getY());
                }
            }
        });

        // MouseListener para mostrar el menú emergente popupMenuDinamic al hacer clic derecho en 'cardsPanelDinamic'
        cardsPanelDinamic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    popupMenuDinamic.show(cardsPanelDinamic, evt.getX(), evt.getY());
                }
            }
        });

        setFocusable(true);
        requestFocus();

        // Por defecto, se muestra el panel de las figuras normales en el contentPane
        getContentPane().add(cardsPanelNormal);
        getContentPane().setBackground(new Color(0x191919));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Agregamos un KeyListener para capturar los eventos de teclado
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
        // Comprobamos el cardLayout actual y llamamos al método subirNivel correspondiente en la figura actual
        if (actual == cardLayoutNormal) {
            figurasNormales.get(indiceFigura).subirNivel();
        } else {
            figurasDinamic.get(indiceFigura).subirNivel();
        }
        repaint();
    }

    private void bajarNivel() {
        // Comprobamos el cardLayout actual y llamamos al método bajarNivel correspondiente en la figura actual
        if (actual == cardLayoutNormal) {
            figurasNormales.get(indiceFigura).bajarNivel();
        } else {
            figurasDinamic.get(indiceFigura).bajarNivel();
        }
        repaint();
    }

    // Método para cambiar a la figura anterior según estemos en el cardLayoutNormal o cardLayoutDinamic
    private void cambiarFiguraAnterior() {
        if (actual == cardLayoutNormal) {
            cardLayoutNormal.previous(cardsPanelNormal);
            indiceFigura = (indiceFigura - 1 + figurasNormales.size()) % figurasNormales.size();
        } else {
            cardLayoutDinamic.previous(cardsPanelDinamic);
            indiceFigura = (indiceFigura - 1 + figurasDinamic.size()) % figurasDinamic.size();
        }
    }

    // Método para cambiar a la figura siguiente según estemos en el cardLayoutNormal o cardLayoutDinamic
    private void cambiarFiguraSiguiente() {
        if (actual == cardLayoutNormal) {
            cardLayoutNormal.next(cardsPanelNormal);
            indiceFigura = (indiceFigura + 1) % figurasNormales.size();
        } else {
            cardLayoutDinamic.next(cardsPanelDinamic);
            indiceFigura = (indiceFigura + 1) % figurasDinamic.size();
        }
    }

    // Método para cambiar entre cardLayoutNormal y cardLayoutDinamic
    // y mantener el mismo índice en ambos arrays para cambiar a la misma figura
    private void cambiarModo() {
        if (actual == cardLayoutNormal) {
            actual = cardLayoutDinamic;
            getContentPane().remove(cardsPanelNormal);
            getContentPane().add(cardsPanelDinamic);
        } else {
            actual = cardLayoutNormal;
            getContentPane().remove(cardsPanelDinamic);
            getContentPane().add(cardsPanelNormal);
        }

        // Mostramos la figura actual en el nuevo cardLayout actual
        if (actual == cardLayoutNormal) {
            cardLayoutNormal.show(cardsPanelNormal, String.valueOf(indiceFigura));
        } else {
            cardLayoutDinamic.show(cardsPanelDinamic, String.valueOf(indiceFigura));
        }

        pack();
        setLocationRelativeTo(null);
    }
}
