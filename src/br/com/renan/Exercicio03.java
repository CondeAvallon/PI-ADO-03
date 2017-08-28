package br.com.renan;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Exercicio03 {

    public static void main(String[] args) {
        MinhaThread mt = new MinhaThread();
        SwingUtilities.invokeLater(mt);
    }

    public static void criarGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 100));
        frame.setResizable(false);
        frame.setTitle("Cálculo de média");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JLabel descricao = new JLabel("Programa de cálculo de média!");
        panel.add(descricao);

        JButton buttonMedia = new JButton("Iniciar");
        panel.add(buttonMedia);

        JButton buttonFechar = new JButton("Fechar");
        panel.add(buttonFechar);

        buttonMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                float numero;
                float soma = 0;
                for (int i = 0; i < 3; i++) {
                    numero = Float.parseFloat(JOptionPane.showInputDialog(frame, "Digite o número [" + (i + 1) + "]"));
                    soma += numero;
                }
                float media = soma / 3;
                JOptionPane.showMessageDialog(frame, "A média é: " + media);
            }

        });

        buttonFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

}
