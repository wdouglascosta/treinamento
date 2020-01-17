package william.dia8;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ContaContabilRepository extends JpaRepository<ContaContabil, UUID> {

	@Query(nativeQuery = true, value = "select count (*) from conta_contabil")
	Long contarContas();
	
	@Query(nativeQuery = true, value = "select * from conta_contabil c where c.conta_superior_id is null")
	List<ContaContabil> selecionarContasRaiz(); 
	
	@Query(nativeQuery = true,
			value = "select * from conta_contabil",
			countQuery = "select count (*) from conta_contabil")
	Page<ContaContabil> recuperarTodas(Pageable pageable);
	
	@Query(nativeQuery = true,
			value = "select * from conta_contabil")
	Slice<ContaContabil> recuperarTodasFatiada(Pageable pageable);
	
	@Query(nativeQuery = true,
			value = "select * from conta_contabil  limit :size offset (:page * :size)")
	List<ContaContabil> recuperarTodasManual(@Param("page") int page,@Param("size") int size);
//	List<ContaContabil> recuperarTodasManual( int page, int size);
	
	@Query(nativeQuery = true, value = 
			"WITH RECURSIVE hierarquia(id, nome, conta_superior_id, nivel) AS (\r\n" + 
			"SELECT id, nome, conta_superior_id, 1 FROM conta_contabil where conta_superior_id is NULL\r\n" + 
			"UNION ALL\r\n" + 
			"SELECT f.id, f.nome, f.conta_superior_id, hierarquia.nivel + 1\r\n" + 
			"FROM conta_contabil f, hierarquia where f.conta_superior_id = hierarquia.id\r\n" + 
			")\r\n" + 
			"SELECT * FROM hierarquia"
			)
	List<Map<String, Object>> recuperarHierarquia();




}