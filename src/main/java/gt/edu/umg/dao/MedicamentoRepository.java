<<<<<<< HEAD
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByNombreContainingIgnoreCase(String nombre);

    List<Medicamento> findByCategoriaIgnoreCase(String categoria);

    List<Medicamento> findByLaboratorioIgnoreCase(String laboratorio);

    List<Medicamento> findByActivoTrue();

    List<Medicamento> findByRequiereRecetaTrue();

    List<Medicamento> findByCategoriaAndActivoTrue(String categoria);

    boolean existsByNombreIgnoreCase(String nombre);
=======
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {

    List<Medicamento> findByNombreContainingIgnoreCase(String nombre);

    List<Medicamento> findByCategoriaIgnoreCase(String categoria);

    List<Medicamento> findByLaboratorioIgnoreCase(String laboratorio);

    List<Medicamento> findByActivoTrue();

    List<Medicamento> findByRequiereRecetaTrue();

    List<Medicamento> findByCategoriaAndActivoTrue(String categoria);

    boolean existsByNombreIgnoreCase(String nombre);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}