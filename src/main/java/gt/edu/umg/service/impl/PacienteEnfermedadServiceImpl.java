package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.PacienteEnfermedad;
import gt.edu.umg.dao.PacienteEnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PacienteEnfermedadServiceImpl implements PacienteEnfermedadService {

    @Autowired
    private PacienteEnfermedadRepository repository;

    @Override
    public PacienteEnfermedad guardar(PacienteEnfermedad entity) {
        // Validar que no exista duplicado
        if (repository.existsByPacienteIdAndEnfermedadId(
                entity.getPaciente().getId(), 
                entity.getEnfermedad().getId())) {
            throw new RuntimeException("Este paciente ya tiene registrada esta enfermedad");
        }
        return repository.save(entity);
    }

    @Override
    public List<PacienteEnfermedad> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public PacienteEnfermedad obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada con ID: " + id));
    }

    @Override
    public PacienteEnfermedad actualizar(Long id, PacienteEnfermedad entity) {
        PacienteEnfermedad existente = obtenerPorId(id);
        existente.setFechaDiagnostico(entity.getFechaDiagnostico());
        existente.setEstado(entity.getEstado());
        existente.setObservaciones(entity.getObservaciones());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Relación no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<PacienteEnfermedad> buscarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    @Override
    public List<PacienteEnfermedad> buscarPorEnfermedad(Long enfermedadId) {
        return repository.findByEnfermedadId(enfermedadId);
    }

    @Override
    public boolean existeRelacion(Long pacienteId, Long enfermedadId) {
        return repository.existsByPacienteIdAndEnfermedadId(pacienteId, enfermedadId);
    }
}