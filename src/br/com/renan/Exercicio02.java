package br.com.renan;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Exercicio02 {

    public static void main(String[] args) {
        MinhaThread mt = new MinhaThread();
        SwingUtilities.invokeLater(mt);
    }

    public static void criarGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 100));
        frame.setResizable(false);
        frame.setTitle("Jogo do acerto");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JLabel descricao = new JLabel("Tente adivinhar o número (1 a 9) gerado pelo programa!");
        panel.add(descricao);

        JButton button = new JButton("Iniciar!");
        panel.add(button);

        Random rnd = new Random();

        button.addActionListener(new ActionListener() {
            int numeroAleatorio = rnd.nextInt(9 + 1);
            int tentativas = 5;

            public void actionPerformed(ActionEvent ae) {
                while (tentativas != 0) {
                    int numeroDigitado = Integer.parseInt(JOptionPane.showInputDialog(frame, "Tente acertar o número!"));
                    if (numeroDigitado == numeroAleatorio) {
                        JOptionPane.showMessageDialog(frame, "Acertou!");
                        System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Não acertou! Tenta novamente. "
                                + "Tentativas restantes: " + (tentativas - 1));
                        tentativas--;
                        if (tentativas == 0) {
                            JOptionPane.showMessageDialog(frame, "Game Over! O número era: " + numeroAleatorio);
                            System.exit(0);
                        }
                    }
                }
            }

        });

        frame.pack();
        frame.setVisible(true);
    }

}
