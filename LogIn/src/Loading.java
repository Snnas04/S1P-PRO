import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Loading extends JFrame {

    private JLabel loadingLabel;
    private JProgressBar progressBar;
    private Icon loadingIcon;
    private Random random;

    public Loading() {
        // Configuración de la ventana
        setTitle("Loading");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setLocationRelativeTo(null);

        // Configuración del JLabel
        loadingLabel = new JLabel("Loading");
        loadingLabel.setBounds(125, 135, 250, 150);
        loadingLabel.setFont(new Font("Arial", Font.BOLD, 45));
        loadingLabel.setHorizontalAlignment(JLabel.CENTER); // Centrar el texto

        // Configuración del ImageIcon
        ImageIcon loginIcon = new ImageIcon("./img/loadingIcon.png");
        JLabel iconLabel = new JLabel(loginIcon);
        iconLabel.setBounds(180, 40, 130, 130);

        add(loadingLabel);
        add(iconLabel);

        // Configuración de la barra de progreso
        progressBar = new JProgressBar(0, 100);
        progressBar.setBounds(25, 250, 450, 30);
        progressBar.setStringPainted(true); // Mostrar el porcentaje en la barra

        add(progressBar);

        // Mostrar la ventana
        setVisible(true);

        // Iniciar el hilo de carga
        random = new Random();
        Thread loadingThread = new Thread(new LoadingTask());
        loadingThread.start();
    }

    private class LoadingTask implements Runnable {
        public void run() {
            try {
                for (int i = 0; i <= 100; i++) {
                    progressBar.setValue(i);
                    Thread.sleep(random.nextInt(100)); // Simular una carga aleatoria
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Cerrar la ventana de carga
            dispose();
            new LogIn();
        }
    }

    public static void main(String[] args) {
        // Crear y mostrar la ventana
        Loading loadingWindow = new Loading();
    }
}
