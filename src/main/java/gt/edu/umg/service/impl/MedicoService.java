<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medico;

import java.util.List;

public interface MedicoService {

    // CRUD básico
    Medico guardar(Medico medico);

    List<Medico> obtenerTodos();

    Medico obtenerPorId(Long id);

    void eliminar(Long id);

    Medico actualizar(Long id, Medico medicoActualizado);

    // Consultas específicas
    List<Medico> buscarPorEspecialidad(String especialidad);

    List<Medico> buscarPorNombre(String nombre);

    List<Medico> buscarActivos();

    List<Medico> buscarPorNombreYApellido(String nombre, String apellido);

    // Verificaciones
    boolean existePorMatricula(String matricula);

    boolean existePorEmail(String email);

    Medico obtenerPorMatricula(String matricula);
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medico;

import java.util.List;

public interface MedicoService {

    // CRUD básico
    Medico guardar(Medico medico);

    List<Medico> obtenerTodos();

    Medico obtenerPorId(Long id);

    void eliminar(Long id);

    Medico actualizar(Long id, Medico medicoActualizado);

    // Consultas específicas
    List<Medico> buscarPorEspecialidad(String especialidad);

    List<Medico> buscarPorNombre(String nombre);

    List<Medico> buscarActivos();

    List<Medico> buscarPorNombreYApellido(String nombre, String apellido);

    // Verificaciones
    boolean existePorMatricula(String matricula);

    boolean existePorEmail(String email);

    Medico obtenerPorMatricula(String matricula);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}