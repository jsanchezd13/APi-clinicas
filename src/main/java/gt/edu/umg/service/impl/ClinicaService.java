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

}