package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteTransacao {

    public static void main(String[] args) {
        Transacao transacao = new Transacao("ITAV$", new BigDecimal(10.0), 100, LocalDate.now(), TipoTransacao.COMPRA);
        System.out.println(transacao);
    }
}
