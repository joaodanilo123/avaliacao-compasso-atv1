package compasso.bolsa.controller;

import java.util.List;

import javax.persistence.EntityManager;

import compasso.bolsa.dao.ProdutoDAO;
import compasso.bolsa.dao.Util;
import compasso.bolsa.model.Produto;

public class ProdutoController implements AutoCloseable {
    
    private ProdutoDAO dao;
    private EntityManager entityManager;

    public ProdutoController(){
        this.entityManager = Util.getEntityManager();
        this.dao = new ProdutoDAO(entityManager);
    }

    public void cadastrar(Produto p){
        entityManager.getTransaction().begin();
        dao.cadastrar(p);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void atualizar(Produto p){
        entityManager.getTransaction().begin();
        p = dao.atualizar(p);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public List<Produto> listar(){
        return dao.listar();
    }

    public void deletar(Produto p){
        entityManager.getTransaction().begin();
        dao.deletar(p);
        entityManager.getTransaction().commit();
        entityManager.clear();
    }

    public void close() {
        this.entityManager.close();
    }

}
