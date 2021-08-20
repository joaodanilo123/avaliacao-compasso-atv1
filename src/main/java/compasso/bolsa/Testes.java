package compasso.bolsa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import compasso.bolsa.dao.ProdutoDAO;
import compasso.bolsa.dao.Util;
import compasso.bolsa.model.Produto;

public class Testes {

    public static void main(String[] args) {
        Produto p = new Produto("Smart TV", "Smart TV LG 4K", new BigDecimal("2300"), 50);
        EntityManager emManager = Util.getEntityManager();
        ProdutoDAO pdao = new ProdutoDAO(emManager);

        emManager.getTransaction().begin();
        pdao.cadastrar(p);
        emManager.getTransaction().commit();
        emManager.close();
    }

}
