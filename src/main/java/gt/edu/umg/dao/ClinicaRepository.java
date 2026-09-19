package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Clinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClinicaRepository extends JpaRepository<Clinica, Long> {

    Optional<Clinica> findByEmail(String email);

    List<Clinica> findByNombreContainingIgnoreCase(String nombre);

    List<Clinica> findByTipoIgnoreCase(String tipo);

    List<Clinica> findByNivelIgnoreCase(String nivel);

    List<Clinica> findByActivoTrue();

    boolean existsByEmail(String email);
}