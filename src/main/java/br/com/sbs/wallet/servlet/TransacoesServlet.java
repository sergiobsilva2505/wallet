package br.com.sbs.wallet.servlet;

import br.com.sbs.wallet.dao.ConnectionFactory;
import br.com.sbs.wallet.dao.TransacaoDao;
import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

    private TransacaoDao dao;

    public TransacoesServlet() {
        this.dao = new TransacaoDao(new ConnectionFactory().getConnectiona());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("transacoes", dao.listar());

        request.getRequestDispatcher("WEB-INF/views/transacoes.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String ticker = request.getParameter("ticker");
            LocalDate data = LocalDate.parse(
                    request.getParameter("data"),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            BigDecimal preco = new BigDecimal(
                    request.getParameter("preco").replace(",",".")) ;
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));

            TipoTransacao tipo = TipoTransacao.valueOf(request.getParameter("tipo"));

            Transacao transacao = new Transacao(data, preco, quantidade, ticker, tipo);
            dao.cadastrar(transacao);

            response.sendRedirect("transacoes");

        } catch (NumberFormatException e) {
            response.sendRedirect("transacoes?erro=campo invalido!");
        }

    }

}
