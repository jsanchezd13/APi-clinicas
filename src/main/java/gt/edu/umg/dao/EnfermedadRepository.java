<<<<<<< HEAD
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {

    // Métodos básicos
    Optional<Enfermedad> findByNombre(String nombre);
    List<Enfermedad> findByNombreContainingIgnoreCase(String nombre);
    List<Enfermedad> findByCategoria(String categoria);
    List<Enfermedad> findByActivoTrue();
    List<Enfermedad> findAllByOrderByNombreAsc();
    
    // Métodos de verificación
    boolean existsByNombre(String nombre);
    Optional<Enfermedad> findByCodigoCie(String codigoCie);
    boolean existsByCodigoCie(String codigoCie);
    
    // Método con @Query para verificar nombre excluyendo un ID
    @Query("SELECT COUNT(e) > 0 FROM Enfermedad e WHERE e.nombre = :nombre AND e.id != :id")
    boolean existsByNombreAndIdNot(@Param("nombre") String nombre, @Param("id") Long id);
=======
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Enfermedad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnfermedadRepository extends JpaRepository<Enfermedad, Long> {

    // Métodos básicos
    Optional<Enfermedad> findByNombre(String nombre);
    List<Enfermedad> findByNombreContainingIgnoreCase(String nombre);
    List<Enfermedad> findByCategoria(String categoria);
    List<Enfermedad> findByActivoTrue();
    List<Enfermedad> findAllByOrderByNombreAsc();
    
    // Métodos de verificación
    boolean existsByNombre(String nombre);
    Optional<Enfermedad> findByCodigoCie(String codigoCie);
    boolean existsByCodigoCie(String codigoCie);
    
    // Método con @Query para verificar nombre excluyendo un ID
    @Query("SELECT COUNT(e) > 0 FROM Enfermedad e WHERE e.nombre = :nombre AND e.id != :id")
    boolean existsByNombreAndIdNot(@Param("nombre") String nombre, @Param("id") Long id);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}