/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.eoh.webapp.dao;

import java.util.List;

/**
 *
 * @author thakgatso
 */
public interface DaoInterface<E,ID>{
    public E edit(E entity);
     public E save(E entity);
     public void delete(E entity);
     public List<E> findAll();
}
