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
import javax.swing.UIManager;

public class Exercicio04 {

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
        frame.setMinimumSize(new Dimension(200, 100));
        frame.setResizable(false);
        frame.setTitle("Lista de Jogos");

        JPanel panel = new JPanel();
        frame.getContentPane().add(panel);

        JLabel jogo = new JLabel("Digite aqui o nome do jogo a ser adicionado!");
        panel.add(jogo);

        JTextField fieldJogo = new JTextField(10);
        panel.add(fieldJogo);

        JButton adicionaJogo = new JButton("Adiciona Jogo");
        panel.add(adicionaJogo);

        JButton exibeJogo = new JButton("Exibir Lista");
        panel.add(exibeJogo);

        String[] listaJogos = new String[10];
        JLabel jogoSalvo = new JLabel();

        adicionaJogo.addActionListener(new ActionListener() {
            int i = 0;

            public void actionPerformed(ActionEvent ae) {
                jogoSalvo.setText(fieldJogo.getText());
                String jogo = jogoSalvo.getText();
                jogo = jogo.toUpperCase();
                jogo = jogo.trim();
                if (!jogo.equals(" ") && !jogo.equals("")) {
                    listaJogos[i] = jogo;
                    i++;

                    JOptionPane.showMessageDialog(frame, "Jogo salvo!");
                    fieldJogo.setText("");
                } else {
                    JOptionPane.showMessageDialog(frame, "Digite o nome do jogo!");
                }
            }
        });

        exibeJogo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String jogos = "== JOGOS ==\n";
                for (int i = 0; i < listaJogos.length; i++) {
                    if (listaJogos[i] != null) {
                        jogos = jogos + ((i + 1) + ". " + listaJogos[i] + "\n");
                    }
                }
                JOptionPane.showMessageDialog(frame, jogos);
            }
        });

        frame.pack();
        frame.setVisible(true);

    }

}
