package Principal;

import View.TelaPrincipal;
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

        TelaPrincipal objetotela = new TelaPrincipal();
        objetotela.setVisible(true);
    }
}