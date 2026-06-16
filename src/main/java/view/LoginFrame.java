package view;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {

        setTitle("Mercado do Jorge");
        setSize(550, 450);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout());

        // Cabeçalho
        JPanel painelTopo = new JPanel();
        painelTopo.setBackground(new Color(0, 51, 102));
        painelTopo.setPreferredSize(new Dimension(550, 80));
        painelTopo.setLayout(new GridLayout(2, 1));

        JLabel titulo = new JLabel("🛒 MERCADO DO JORGE");
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtituloTopo = new JLabel("Sistema de Controle de Estoque");
        subtituloTopo.setForeground(Color.WHITE);
        subtituloTopo.setFont(new Font("Arial", Font.PLAIN, 12));
        subtituloTopo.setHorizontalAlignment(SwingConstants.CENTER);

        painelTopo.add(titulo);
        painelTopo.add(subtituloTopo);

        // Centro
        JPanel painelCentro = new JPanel();
        painelCentro.setBackground(Color.WHITE);
        painelCentro.setLayout(null);

        JLabel subtitulo = new JLabel("Bem-vindo ao sistema");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitulo.setBounds(180, 30, 220, 20);

        JLabel lblUsuario = new JLabel("Usuário");
        lblUsuario.setFont(new Font("Arial", Font.BOLD, 14));
        lblUsuario.setBounds(100, 90, 100, 25);

        JTextField txtUsuario = new JTextField("admin");
        txtUsuario.setBounds(100, 115, 330, 35);

        JLabel lblSenha = new JLabel("Senha");
        lblSenha.setFont(new Font("Arial", Font.BOLD, 14));
        lblSenha.setBounds(100, 170, 100, 25);

        JPasswordField txtSenha = new JPasswordField("123");
        txtSenha.setBounds(100, 195, 330, 35);

        JButton btnEntrar = new JButton("ENTRAR");
        btnEntrar.setBounds(185, 270, 180, 45);

        btnEntrar.setBackground(new Color(255, 122, 0));
        btnEntrar.setForeground(Color.WHITE);
        btnEntrar.setFocusPainted(false);
        btnEntrar.setFont(new Font("Arial", Font.BOLD, 16));
        btnEntrar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Login
        btnEntrar.addActionListener(e -> {

            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            if (usuario.equals("admin") && senha.equals("123")) {

                dispose();

                MainFrame menu = new MainFrame();
                menu.setVisible(true);

            } else {

                JOptionPane.showMessageDialog(
                        null,
                        "Usuário ou senha inválidos!"
                );
            }
        });

        painelCentro.add(subtitulo);
        painelCentro.add(lblUsuario);
        painelCentro.add(txtUsuario);
        painelCentro.add(lblSenha);
        painelCentro.add(txtSenha);
        painelCentro.add(btnEntrar);

        painelPrincipal.add(painelTopo, BorderLayout.NORTH);
        painelPrincipal.add(painelCentro, BorderLayout.CENTER);

        add(painelPrincipal);
    }
}