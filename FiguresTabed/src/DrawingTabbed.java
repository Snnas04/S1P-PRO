import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class DrawingTabbed extends JFrame {
    CardLayout actual, cardLayoutStatic, cardLayoutDinamic;
    JPanel cardsPanelStatic, cardsPanelDinamic;
    JPopupMenu popupMenuStatic, popupMenuDinamic;
    ArrayList<DrawingPanel> figurasStatices = new ArrayList<>();
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
        cardLayoutStatic = new CardLayout();
        cardLayoutDinamic = new CardLayout();
        cardsPanelStatic = new JPanel(cardLayoutStatic);
        cardsPanelDinamic = new JPanel(cardLayoutDinamic);

        actual = cardLayoutStatic;

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
        figurasStatices.add(hilbertPanel);
        figurasDinamic.add(hilbertDinamicPanel);
        figurasStatices.add(mengerPanel);
        figurasDinamic.add(mengerDinamicPanel);
        figurasStatices.add(polynskiPanel);
        figurasDinamic.add(polynskiDinamicPanel);
        figurasStatices.add(sierpinskiPanel);
        figurasDinamic.add(sierpinskiDinamicPanel);

        // Por cada figura en el array 'figurasStatices', la agregamos a 'cardsPanelStatic'
        for (int i = 0; i < figurasStatices.size(); i++) {
            DrawingPanel figura = figurasStatices.get(i);
            cardsPanelStatic.add(figura, String.valueOf(i));
        }

        // Por cada figura en el array 'figurasDinamic', la agregamos a 'cardsPanelDinamic'
        for (int i = 0; i < figurasDinamic.size(); i++) {
            DrawingPanel figura = figurasDinamic.get(i);
            cardsPanelDinamic.add(figura, String.valueOf(i));
        }

        // Creamos los dos menús popup
        popupMenuStatic = new JPopupMenu();
        popupMenuDinamic = new JPopupMenu();

        // Por cada figura en el array 'figurasStatices', la agregamos a 'popupMenuStatic'
        // y un ActionListener para cuando sea seleccionada
        for (int i = 0; i < figurasStatices.size(); i++) {
            DrawingPanel figura = figurasStatices.get(i);
            JMenuItem item = new JMenuItem(figura.getTitle());
            int finalI = i;
            item.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    actual.show(cardsPanelStatic, String.valueOf(finalI));
                    indiceFigura = finalI;
                }
            });
            popupMenuStatic.add(item);
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

        // MouseListener para mostrar el menú emergente popupMenuStatic al hacer clic derecho en 'cardsPanelStatic'
        cardsPanelStatic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                if (SwingUtilities.isRightMouseButton(evt)) {
                    popupMenuStatic.show(cardsPanelStatic, evt.getX(), evt.getY());
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
        getContentPane().add(cardsPanelStatic);
        getContentPane().setBackground(new Color(0x191919));

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // Agregamos un KeyListener para capturar los eventos de teclado
        // Siguiente i anterior figura, subir y bajar nivel, espacio para cambiar a figuras dinamicas o estaticas i 'esc' para salir del programa
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
        // El nivel de una figura es independiente a las demas
        if (actual == cardLayoutStatic) {
            figurasStatices.get(indiceFigura).subirNivel();
        } else {
            figurasDinamic.get(indiceFigura).subirNivel();
        }
        repaint();
    }

    private void bajarNivel() {
        // Comprobamos el cardLayout actual y llamamos al método bajarNivel correspondiente en la figura actual
        // El nivel de una figura es independiente a las demas
        if (actual == cardLayoutStatic) {
            figurasStatices.get(indiceFigura).bajarNivel();
        } else {
            figurasDinamic.get(indiceFigura).bajarNivel();
        }
        repaint();
    }

    // Método para cambiar a la figura anterior
    private void cambiarFiguraAnterior() {
        if (actual == cardLayoutStatic) {
            cardLayoutStatic.previous(cardsPanelStatic);
            indiceFigura = (indiceFigura - 1 + figurasStatices.size()) % figurasStatices.size();
        } else {
            cardLayoutDinamic.previous(cardsPanelDinamic);
            indiceFigura = (indiceFigura - 1 + figurasDinamic.size()) % figurasDinamic.size();
        }
    }

    // Método para cambiar a la figura siguiente
    private void cambiarFiguraSiguiente() {
        if (actual == cardLayoutStatic) {
            cardLayoutStatic.next(cardsPanelStatic);
            indiceFigura = (indiceFigura + 1) % figurasStatices.size();
        } else {
            cardLayoutDinamic.next(cardsPanelDinamic);
            indiceFigura = (indiceFigura + 1) % figurasDinamic.size();
        }
    }

    // Método para cambiar entre cardLayoutStatic y cardLayoutDinamic
    // y mantener el mismo índice en ambos arrays para cambiar a la misma figura
    private void cambiarModo() {
        if (actual == cardLayoutStatic) {
            actual = cardLayoutDinamic;
            getContentPane().remove(cardsPanelStatic);
            getContentPane().add(cardsPanelDinamic);
        } else {
            actual = cardLayoutStatic;
            getContentPane().remove(cardsPanelDinamic);
            getContentPane().add(cardsPanelStatic);
        }

        // Mostramos la figura actual en el nuevo cardLayout actual
        if (actual == cardLayoutStatic) {
            cardLayoutStatic.show(cardsPanelStatic, String.valueOf(indiceFigura));
        } else {
            cardLayoutDinamic.show(cardsPanelDinamic, String.valueOf(indiceFigura));
        }

        pack();
        setLocationRelativeTo(null);
    }
}
