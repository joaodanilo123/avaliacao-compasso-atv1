package compasso.bolsa.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
    private int quantidade;
	private BigDecimal preco;
	private LocalDate dataCadastro = LocalDate.now();
    private LocalDate dataAlteracao;
	
	public Produto() {}
	
	public Produto(
			String nome, 
			String descricao, 
			BigDecimal preco,
			int quantidade
		) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDate getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDate dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	@Override
	public String toString() {
		return String.format("{ ID: %d\nNome: %s\nDescrição: %s\nPreço: %.2f\nQuantidade: %d\nCriado em: %t\nAlterado em: %t }", 
			this.getId(),
			this.getNome(),
			this.getDescricao(),
			this.getPreco(),
			this.getQuantidade(),
			this.getDataCadastro(),
			this.getDataAlteracao()
		);
	}


}
