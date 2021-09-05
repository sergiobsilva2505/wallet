package br.com.sbs.wallet.teste;

import br.com.sbs.wallet.modelo.TipoTransacao;
import br.com.sbs.wallet.modelo.Transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TesteTransacao {

    public static void main(String[] args) {
        Transacao transacao1 = new Transacao("ITSA4", new BigDecimal(10.0), 100, LocalDate.now(), TipoTransacao.COMPRA);
        Transacao transacao2 = new Transacao("BBSE3", new BigDecimal(23.50), 20, LocalDate.of(2021, 2,1), TipoTransacao.COMPRA);
        System.out.println(transacao1);
    }
}
