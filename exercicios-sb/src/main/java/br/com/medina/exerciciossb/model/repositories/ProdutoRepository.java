package br.com.medina.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import br.com.medina.exerciciossb.model.entities.Produto;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer>{
	
	// o spring iria usá-la na função abaixo
	public Iterable<Produto> findByNomeContaining(String parteNome);
	
	//@Query por exemplo se preciso de uma query mais especifica crio um jpql e uso essa anotation
	@Query("SELECT p from Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNameLike(@Param("nome") String nome);
}
