package br.com.renan;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Exercicio01 {

    public static void main(String[] args) {
        MinhaThread mt = new MinhaThread();
        SwingUtilities.invokeLater(mt);
    }

    public static void criarGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(300, 100));
        frame.setResizable(false);
        frame.setTitle("Cadastro de Clientes");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JLabel label = new JLabel("Preencha com os dados do cliente!");
        panel.add(label);

        JLabel labelNome = new JLabel("  Nome:");
        panel.add(labelNome);

        final JTextField fieldNome = new JTextField(10);
        panel.add(fieldNome);

        JLabel labelEndereco = new JLabel("  Endereço:");
        panel.add(labelEndereco);

        final JTextField fieldEndereco = new JTextField(10);
        panel.add(fieldEndereco);

        JLabel labelTelefone = new JLabel("  Telefone:");
        panel.add(labelTelefone);

        final JTextField fieldTelefone = new JTextField(10);
        panel.add(fieldTelefone);

        JButton salvar = new JButton("Salvar");
        panel.add(salvar);

        JButton exibirDados = new JButton("Exibir Dados");
        panel.add(exibirDados);

        final JLabel nomeSalvo = new JLabel();
        final JLabel enderecoSalvo = new JLabel();
        final JLabel telefoneSalvo = new JLabel();

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeSalvo.setText(fieldNome.getText());
                enderecoSalvo.setText(fieldEndereco.getText());
                telefoneSalvo.setText(fieldTelefone.getText());
            }

        });

        exibirDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeSalvo.getText();
                String endereco = enderecoSalvo.getText();
                String telefone = telefoneSalvo.getText();
                JOptionPane.showMessageDialog(frame, "Nome: " + nome + "\n"
                        + "Endereço: " + endereco + "\n" + "Telefone: "
                        + telefone, "Informações do cliente",
                        JOptionPane.INFORMATION_MESSAGE);
            }

        });

        frame.pack();
        frame.setVisible(true);

    }

}
