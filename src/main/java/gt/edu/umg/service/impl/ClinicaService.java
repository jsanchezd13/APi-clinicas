<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Clinica;
import java.util.List;

public interface ClinicaService {

    Clinica guardar(Clinica entity);

    List<Clinica> obtenerTodos();

    Clinica obtenerPorId(Long id);

    Clinica actualizar(Long id, Clinica entity);

    void eliminar(Long id);

    List<Clinica> buscarPorNombre(String nombre);

    List<Clinica> buscarPorTipo(String tipo);

    List<Clinica> buscarPorNivel(String nivel);

    List<Clinica> buscarActivos();

    Clinica obtenerPorEmail(String email);
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Clinica;
import java.util.List;

public interface ClinicaService {

    Clinica guardar(Clinica entity);

    List<Clinica> obtenerTodos();

    Clinica obtenerPorId(Long id);

    Clinica actualizar(Long id, Clinica entity);

    void eliminar(Long id);

    List<Clinica> buscarPorNombre(String nombre);

    List<Clinica> buscarPorTipo(String tipo);

    List<Clinica> buscarPorNivel(String nivel);

    List<Clinica> buscarActivos();

    Clinica obtenerPorEmail(String email);
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}