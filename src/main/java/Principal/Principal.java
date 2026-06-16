package Principal;

import view.MainFrame;
import java.sql.Connection;
import util.ConexaoBanco;

public class Principal {

    public static void main(String[] args) {

        try {

            Connection conn = ConexaoBanco.conectar();

            System.out.println("Banco conectado com sucesso!");

            conn.close();

        } catch (Exception e) {

            System.out.println("Erro ao conectar ao banco");

            e.printStackTrace();
        }

        MainFrame objetotela = new MainFrame();
        objetotela.setVisible(true);
    }
}