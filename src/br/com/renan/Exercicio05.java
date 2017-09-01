package br.com.renan;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Exercicio05 {

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
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(200, 200));
        frame.setResizable(false);
        frame.setTitle("Calculadora");

        JPanel panelPrincipal = new JPanel();
        frame.getContentPane().add(panelPrincipal);
        panelPrincipal.setLayout(new GridLayout(5, 0));

        JPanel panel1 = new JPanel();
        panelPrincipal.add(panel1);
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel2 = new JPanel();
        panelPrincipal.add(panel2);
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel3 = new JPanel();
        panelPrincipal.add(panel3);
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel4 = new JPanel();
        panelPrincipal.add(panel4);
        panel4.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel panel5 = new JPanel();
        panelPrincipal.add(panel5);
        panel5.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel descricao = new JLabel("Digite os números desejados e selecione a operação desejada!");
        panel1.add(descricao);

        JLabel numero1 = new JLabel("Numero 1: ");
        panel2.add(numero1);
        final JTextField fieldNumero1 = new JTextField(5);
        panel2.add(fieldNumero1);

        JLabel numero2 = new JLabel("Numero 2: ");
        panel4.add(numero2);
        final JTextField fieldNumero2 = new JTextField(5);
        panel4.add(fieldNumero2);

        JLabel operacao = new JLabel("Operação: ");
        panel3.add(operacao);

        JRadioButton soma = new JRadioButton("Soma");
        panel3.add(soma);

        JRadioButton subtracao = new JRadioButton("Subtração");
        panel3.add(subtracao);

        JRadioButton divisao = new JRadioButton("Divisão");
        panel3.add(divisao);

        JRadioButton multiplicacao = new JRadioButton("Multiplicação");
        panel3.add(multiplicacao);

        ButtonGroup group = new ButtonGroup();
        group.add(soma);
        group.add(subtracao);
        group.add(divisao);
        group.add(multiplicacao);

        JButton buttonCalcular = new JButton("Calcular");
        panel5.add(buttonCalcular);

        buttonCalcular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                int numeroDigitado1 = Integer.parseInt(fieldNumero1.getText());
                int numeroDigitado2 = Integer.parseInt(fieldNumero2.getText());
                if (soma.isSelected()) {
                    int somaNumeros = numeroDigitado1 + numeroDigitado2;
                    JOptionPane.showMessageDialog(frame, "Resultado da soma: " + somaNumeros);
                } else if (subtracao.isSelected()) {
                    int subtraiNumeros = numeroDigitado1 - numeroDigitado2;
                    JOptionPane.showMessageDialog(frame, "Resultado da subtração: " + subtraiNumeros);
                } else if (divisao.isSelected()) {
                    int divideNumeros = numeroDigitado1 / numeroDigitado2;
                    JOptionPane.showMessageDialog(frame, "Resultado da divisão: " + divideNumeros);
                } else {
                    int multiplicaNumeros = numeroDigitado1 * numeroDigitado2;
                    JOptionPane.showMessageDialog(frame, "Resultado da multiplicação: " + multiplicaNumeros);
                }
            }

        });

        frame.pack();
        frame.setVisible(true);

    }

}
