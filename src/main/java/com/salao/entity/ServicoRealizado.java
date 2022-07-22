package com.salao.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class ServicoRealizado implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore
    @EmbeddedId
    private ServicoRealizadoPK id = new ServicoRealizadoPK();

    private Double desconto;
    private Integer quantidade;
    private Double preco;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissional;

    public ServicoRealizado(Comanda comanda, Servico servico, Double desconto, Integer quantidade, Double preco) {
        super();
        id.setServico(servico);
        id.setComanda(comanda);
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }


    @JsonIgnore
    public Comanda getComanda() {
        return id.getComanda();
    }

    public void setServico(Servico servico) {
        id.setServico(servico);
    }

    public Servico getServico() {
        return id.getServico();
    }

    public void setProduto(Servico servico) {
        id.setServico(servico);
    }
}
