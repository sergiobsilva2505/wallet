package br.com.sbs.wallet.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private LocalDate data;
    private BigDecimal preco;
    private Integer quantidade;
    private String ticker;
    private TipoTransacao tipoTransacao;

    public Transacao(LocalDate data, BigDecimal preco, Integer quantidade, String ticker, TipoTransacao tipoTransacao) {
        this.data = data;
        this.preco = preco;
        this.quantidade = quantidade;
        this.ticker = ticker;
        this.tipoTransacao = tipoTransacao;
    }

    public String getTicker() {
        return ticker;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public LocalDate getData() {
        return data;
    }

    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    @Override
    public String toString() {
        return "Transacao -> [" +
                "ticker='" + ticker + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", data=" + data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                ", tipoTransacao=" + tipoTransacao +
                ']';
    }
}
