package gt.edu.umg.service.impl;

import java.util.List;
import gt.edu.umg.core.entities.Enfermedad;

public interface EnfermedadService {
    
    // CRUD básico
    Enfermedad guardar(Enfermedad enfermedad);
    List<Enfermedad> obtenerTodos();
    Enfermedad obtenerPorId(Long id);
    void eliminar(Long id);
    
    // Actualizar
    Enfermedad actualizar(Long id, Enfermedad enfermedad);
    
    // Consultas específicas
    List<Enfermedad> buscarPorNombre(String nombre);
    List<Enfermedad> buscarPorCategoria(String categoria);
    List<Enfermedad> buscarActivos();
    
    // Verificaciones
    boolean existePorNombre(String nombre);
    boolean existePorNombreYIdDiferente(String nombre, Long id);

}