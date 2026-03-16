/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.senac.estoque_esmalteria.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class JAPAUtil {
  
    private static EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("estoquePU");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }  
}
