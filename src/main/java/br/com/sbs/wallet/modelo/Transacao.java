package br.com.sbs.wallet.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacao {

    private String ticker;
    private BigDecimal preco;
    private Integer quantidade;
    private LocalDate data;
    private TipoTransacao tipoTransacao;

    public Transacao(String ticker, BigDecimal preco, Integer quantidade, LocalDate data, TipoTransacao tipoTransacao) {
        this.ticker = ticker;
        this.preco = preco;
        this.quantidade = quantidade;
        this.data = data;
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
