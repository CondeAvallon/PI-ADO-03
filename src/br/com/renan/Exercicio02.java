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
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Exercicio02 {

    public static void main(String[] args) {
        Runnable thread = new Runnable() {
            public void run() {
                criarGUI();
            }
        };
        SwingUtilities.invokeLater(thread);
    }

    public static void criarGUI() {

        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

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

            public void actionPerformed(ActionEvent ae) {
                int numeroAleatorio = rnd.nextInt(9) + 1;
                int tentativas = 5;
                while (tentativas != 0) {
                    try {
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
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    }
                }
            }

        });

        frame.pack();
        frame.setVisible(true);
    }

}
