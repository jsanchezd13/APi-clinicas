package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Clinica;
import gt.edu.umg.dao.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClinicaServiceImpl implements ClinicaService {

    @Autowired
    private ClinicaRepository repository;

    @Override
    public Clinica guardar(Clinica entity) {
        if (repository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Ya existe una clínica con el email: " + entity.getEmail());
        }
        if (entity.getActivo() == null) entity.setActivo(true);
        return repository.save(entity);
    }

    @Override
    public List<Clinica> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Clinica obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada con ID: " + id));
    }

    @Override
    public Clinica actualizar(Long id, Clinica entity) {
        Clinica existente = obtenerPorId(id);

        if (!existente.getEmail().equals(entity.getEmail()) &&
            repository.existsByEmail(entity.getEmail())) {
            throw new RuntimeException("Ya existe otra clínica con el email: " + entity.getEmail());
        }

        existente.setNombre(entity.getNombre());
        existente.setDireccion(entity.getDireccion());
        existente.setTelefono(entity.getTelefono());
        existente.setEmail(entity.getEmail());
        existente.setTipo(entity.getTipo());
        existente.setCapacidad(entity.getCapacidad());
        existente.setNivel(entity.getNivel());
        existente.setActivo(entity.getActivo());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Clínica no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Clinica> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Clinica> buscarPorTipo(String tipo) {
        return repository.findByTipoIgnoreCase(tipo);
    }

    @Override
    public List<Clinica> buscarPorNivel(String nivel) {
        return repository.findByNivelIgnoreCase(nivel);
    }

    @Override
    public List<Clinica> buscarActivos() {
        return repository.findByActivoTrue();
    }

    @Override
    public Clinica obtenerPorEmail(String email) {
        return repository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Clínica no encontrada con email: " + email));
    }
}