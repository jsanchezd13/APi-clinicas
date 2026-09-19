
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.RecetaMedicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaMedicamentoRepository extends JpaRepository<RecetaMedicamento, Long> {

    List<RecetaMedicamento> findByRecetaId(Long recetaId);

    List<RecetaMedicamento> findByMedicamentoId(Long medicamentoId);

    boolean existsByRecetaIdAndMedicamentoId(Long recetaId, Long medicamentoId);

}