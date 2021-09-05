package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.dao.TransacaoDao;
import br.com.sbs.wallet.modelo.Transacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class TesteSelectTransacao {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/walletDb";
        String usuario = "root";
        String senha = "Alura@123";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            TransacaoDao transacaoDao = new TransacaoDao(connection);
            List<Transacao> lista = transacaoDao.listar();
            lista.forEach(System.out::println);
        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }
    }
}
