package compasso.bolsa.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import compasso.bolsa.model.Produto;

public class ProdutoDAO {

    private EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Produto atualizar(Produto produto) {
        produto.setDataAlteracao(LocalDate.now());
        return entityManager.merge(produto);
    }

    public void cadastrar(Produto produto) {
        entityManager.persist(produto);
    }

    public void deletar(Produto produto) {
        produto = entityManager.merge(produto);
        entityManager.remove(produto);
    }

    public List<Produto> listar() {
        return entityManager.createQuery("SELECT p FROM Produto", Produto.class).getResultList();
    }

    public void limparTabela() {
        entityManager.createQuery("DELETE FROM Produto").executeUpdate();
    }

}
