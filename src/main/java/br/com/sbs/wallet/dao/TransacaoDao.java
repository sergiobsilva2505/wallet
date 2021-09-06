package br.com.sbs.wallet.dao;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TransacaoDao {


    private Connection connection;

    public TransacaoDao(Connection connection) {
        this.connection = connection;
    }

    public void cadastrar(Transacao transacao){
        try {

            String sql = "INSERT INTO transacoes (data, preco, quantidade, ticker, tipoTransacao) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, Date.valueOf(transacao.getData()));
            preparedStatement.setBigDecimal(2, transacao.getPreco());
            preparedStatement.setInt(3, transacao.getQuantidade());
            preparedStatement.setString(4, transacao.getTicker());
            preparedStatement.setString(5, transacao.getTipoTransacao().toString());

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public List<Transacao> listar(){

        List<Transacao> transacoes = new ArrayList<>();
        try {

            String sql = "SELECT * FROM transacoes";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                LocalDate data = resultSet.getDate("data").toLocalDate();
                BigDecimal preco = resultSet.getBigDecimal("preco");
                int quantidade = resultSet.getInt("quantidade");
                String ticker = resultSet.getString("ticker");
                TipoTransacao tipoTransacao = TipoTransacao.valueOf(resultSet.getString("tipoTransacao"));

                Transacao transacao = new Transacao(data, preco, quantidade, ticker, tipoTransacao);

                transacoes.add(transacao);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return transacoes;
    }
}
