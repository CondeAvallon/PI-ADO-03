package br.com.renan;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Exercicio01 {

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
        frame.setMinimumSize(new Dimension(100, 50));
        frame.setResizable(false);
        frame.setTitle("Cadastro de Clientes");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);
        panel.setLayout(new GridLayout(4, 0));

        JPanel panel2 = new JPanel();
        panel.add(panel2);
        panel2.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JPanel panel3 = new JPanel();
        panel.add(panel3);
        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JPanel panel4 = new JPanel();
        panel.add(panel4);
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JLabel labelNome = new JLabel("  Nome:");
        panel2.add(labelNome);

        final JTextField fieldNome = new JTextField(10);
        panel2.add(fieldNome);

        JLabel labelTelefone = new JLabel("  Telefone:");
        panel2.add(labelTelefone);

        final JTextField fieldTelefone = new JTextField(10);
        panel2.add(fieldTelefone);

        JLabel labelEndereco = new JLabel("  Endereço:");
        panel3.add(labelEndereco);

        final JTextField fieldEndereco = new JTextField(24);
        panel3.add(fieldEndereco);

        JButton salvar = new JButton("Salvar");
        panel4.add(salvar);

        JButton exibirDados = new JButton("Exibir Dados");
        panel4.add(exibirDados);

        final JLabel nomeSalvo = new JLabel();
        final JLabel enderecoSalvo = new JLabel();
        final JLabel telefoneSalvo = new JLabel();

        salvar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nomeSalvo.setText(fieldNome.getText());
                telefoneSalvo.setText(fieldTelefone.getText());
                enderecoSalvo.setText(fieldEndereco.getText());
                fieldNome.setText("");
                fieldTelefone.setText("");
                fieldEndereco.setText("");
            }

        });

        exibirDados.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = nomeSalvo.getText();
                String telefone = telefoneSalvo.getText();
                String endereco = enderecoSalvo.getText();
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
