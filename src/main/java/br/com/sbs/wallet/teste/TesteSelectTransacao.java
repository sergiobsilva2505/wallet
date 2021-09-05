package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class TesteSelectTransacao {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/walletDb";
        String usuario = "root";
        String senha = "Alura@123";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);

            String sql = "SELECT * FROM transacoes";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                long id = resultSet.getLong("id");
                LocalDate data = resultSet.getDate("data").toLocalDate();
                BigDecimal preco = resultSet.getBigDecimal("preco");
                int quantidade = resultSet.getInt("quantidade");
                String ticker = resultSet.getString("ticker");
                TipoTransacao tipoTransacao = TipoTransacao.valueOf(resultSet.getString("tipoTransacao"));

                Transacao t = new Transacao(data, preco, quantidade, ticker, tipoTransacao);

                System.out.println(t);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
        }
    }
}
