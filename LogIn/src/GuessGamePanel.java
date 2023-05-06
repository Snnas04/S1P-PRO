import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class GuessGamePanel extends JPanel {
    private JLabel instructionLabel;
    private JTextField guessTextField;
    private JButton guessButton;
    private JButton newGameButton; // Botón para reiniciar el juego
    private JLabel resultLabel;

    private int answer;
    private int numGuesses;

    public GuessGamePanel() {
        setLayout(new GridLayout(5, 1)); // Agrega una fila para el botón adicional

        // Instrucciones del juego
        instructionLabel = new JLabel("Estoy pensando en un número entre 1 y 100. Adivina cuál es.");
        instructionLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        add(instructionLabel);

        // Campo de texto para ingresar el número a adivinar
        guessTextField = new JTextField();
        add(guessTextField);

        // Botón para adivinar
        guessButton = new JButton("Adivinar");
        guessTextField.addActionListener(textAction);
        guessButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                validateGuess();
            }
        });
        add(guessButton);

        // Botón para reiniciar el juego
        newGameButton = new JButton("Nuevo juego");
        newGameButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetGame();
            }
        });
        add(newGameButton);

        // Etiqueta para mostrar el resultado de cada adivinanza
        resultLabel = new JLabel("");
        add(resultLabel);

        // Genera un número aleatorio entre 1 y 100 para adivinar
        Random rand = new Random();
        answer = rand.nextInt(100) + 1;
    }

    private ActionListener guessAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            validateGuess();
        }
    };

    private ActionListener textAction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            guessAction.actionPerformed(e);
        }
    };

    public void validateGuess() {
        actionPerformed(new ActionEvent(guessButton, ActionEvent.ACTION_PERFORMED, null));
    }

    public void resetGame() {
        // Reinicia el juego
        Random rand = new Random();
        answer = rand.nextInt(100) + 1;
        numGuesses = 0;
        resultLabel.setText("");
        guessTextField.setText("");
        guessButton.setEnabled(true);
    }

    public void actionPerformed(ActionEvent e) {
        int guess = Integer.parseInt(guessTextField.getText());
        numGuesses++;

        if (guess < answer) {
            resultLabel.setText("El número que estoy pensando es mayor que " + guess + ".");
            resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
            resultLabel.setForeground(new Color(0, 102, 255));
        } else if (guess > answer) {
            resultLabel.setText("El número que estoy pensando es menor que " + guess + ".");
            resultLabel.setFont(new Font("Arial", Font.BOLD, 16));
            resultLabel.setForeground(new Color(255, 102, 0));
        } else {
            resultLabel.setText("¡Felicidades! Adivinaste el número en " + numGuesses + " intentos.");
            resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
            resultLabel.setForeground(new Color(57, 230, 0));
            guessButton.setEnabled(false);
        }
    }
}
