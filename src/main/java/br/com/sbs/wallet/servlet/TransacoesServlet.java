package br.com.sbs.wallet.servlet;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/transacoes")
public class TransacoesServlet extends HttpServlet {

    private List<Transacao> transacoes = new ArrayList<>();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Transacao transacao1 = new Transacao("ITSA4", new BigDecimal(10.0), 100, LocalDate.now(), TipoTransacao.COMPRA);
        Transacao transacao2 = new Transacao("BBSE3", new BigDecimal(23.50), 20, LocalDate.of(2021, 2,1), TipoTransacao.COMPRA);
        transacoes.add(transacao1);
        transacoes.add(transacao2);

        request.setAttribute("transacoes", transacoes);

        request.getRequestDispatcher("WEB-INF/views/transacoes.jsp")
                .forward(request, response);


    }
}
