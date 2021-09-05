package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.dao.TransacaoDao;
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

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            TransacaoDao transacaoDao = new TransacaoDao(connection);
            Transacao xpyo1 = new Transacao(LocalDate.now(), new BigDecimal(25.0), 15, "XPYO1", TipoTransacao.VENDA);
            transacaoDao.cadastrar(xpyo1);

        } catch (SQLException throwables) {
            throw new RuntimeException(throwables);
        }

    }
}
