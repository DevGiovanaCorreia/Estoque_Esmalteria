/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.estoque_esmalteria.DAO;

import br.com.senac.estoque_esmalteria.data.Movimentacao_estoque;
import br.com.senac.estoque_esmalteria.data.Produto;
import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author vitor
 */
public class MovimentacaoEstoqueDAO {
    
    public void registrar(Movimentacao_estoque mov){
       EntityManager em = JPAUtil.getEntityManager();
       
      em.getTransaction().begin();
      em.persist(mov);
      em.getTransaction().commit();
      
      em.close();
    }
    
    public List<Movimentacao_estoque> listar(){
        EntityManager em = JPAUtil.getEntityManager();
        
        List<Movimentacao_estoque> lista = em.createQuery(
        "From movimentacao_estoque", Movimentacao_estoque.class
        ).getResultList();
        
        em.close();
        return lista;
        
    }
    
    
    public List<Movimentacao_estoque> buscarPorProduto(int produtoId) {
        EntityManager em = JPAUtil.getEntityManager();

        List<Movimentacao_estoque> lista = em.createQuery(
                "FROM movimentacao_estoque m WHERE m.produto.id = :id",
                Movimentacao_estoque.class)
                .setParameter("id", produtoId)
                .getResultList();

        em.close();
        return lista;
    }
    
    public void darSaida(Produto produto,int quantidade){
        EntityManager em= JPAUtil.getEntityManager();
        
        em.getTransaction().begin();
        
        produto =em.merge(produto);
        produto.setQuantidade(produto.getQuantidade() - quantidade);
        
        Movimentacao_estoque mov = new Movimentacao_estoque();
        mov.setProduto(produto);
        mov.setTipo("SAIDA");
        mov.setQuantidade(quantidade);
        mov.setDataMovimento(LocalDateTime.now());
        
        em.persist(mov);
        
        em.getTransaction().commit();
        em.close();
        
        
        
    }
    
    
}
