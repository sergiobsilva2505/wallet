package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;

public class TesteInsereTransacao {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/walletDb";
        String usuario = "root";
        String senha = "Alura@123";
        try {
            Connection connection = DriverManager.getConnection(url, usuario, senha);
            Transacao transacao1 = new Transacao(LocalDate.of(2021, 7, 1), new BigDecimal(99.99), 110, "XPTO1", TipoTransacao.COMPRA);

            String sql = "INSERT INTO transacoes (data, preco, quantidade, ticker, tipoTransacao) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(transacao1.getData()));
            preparedStatement.setBigDecimal(2, transacao1.getPreco());
            preparedStatement.setInt(3, transacao1.getQuantidade());
            preparedStatement.setString(4, transacao1.getTicker());
            preparedStatement.setString(5, transacao1.getTipoTransacao().toString());

            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar");
        }
    }
}
