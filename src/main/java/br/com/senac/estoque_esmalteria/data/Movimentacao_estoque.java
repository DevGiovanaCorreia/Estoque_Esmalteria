/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.estoque_esmalteria.data;

import br.com.senac.estoque_esmalteria.data.Produto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 *
 * @author vitor
 */

@Entity
public class Movimentacao_estoque {
    
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Produto produto_id;

    private String tipo;
    private int quantidade;

    private LocalDateTime data_movimento;

    public int getId() {
        return id;
    }

    public Produto getProduto() {
        return produto_id;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public LocalDateTime getDataMovimento() {
        return data_movimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProduto(Produto produto) {
        this.produto_id = produto;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setDataMovimento(LocalDateTime dataMovimento) {
        this.data_movimento = dataMovimento;
    }
}
    
    

