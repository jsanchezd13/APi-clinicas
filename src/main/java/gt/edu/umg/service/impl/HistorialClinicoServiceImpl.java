<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.HistorialClinico;
import gt.edu.umg.dao.HistorialClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistorialClinicoServiceImpl implements HistorialClinicoService {

    @Autowired
    private HistorialClinicoRepository repository;

    @Override
    public HistorialClinico guardar(HistorialClinico entity) {
        return repository.save(entity);
    }

    @Override
    public List<HistorialClinico> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public HistorialClinico obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
    }

    @Override
    public HistorialClinico actualizar(Long id, HistorialClinico entity) {
        HistorialClinico existente = obtenerPorId(id);
        existente.setDiagnostico(entity.getDiagnostico());
        existente.setTratamiento(entity.getTratamiento());
        existente.setObservaciones(entity.getObservaciones());
        existente.setPeso(entity.getPeso());
        existente.setAltura(entity.getAltura());
        existente.setPresionArterial(entity.getPresionArterial());
        existente.setTemperatura(entity.getTemperatura());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Historial no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<HistorialClinico> buscarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    @Override
    public List<HistorialClinico> buscarPorMedico(Long medicoId) {
        return repository.findByMedicoId(medicoId);
    }
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.HistorialClinico;
import gt.edu.umg.dao.HistorialClinicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HistorialClinicoServiceImpl implements HistorialClinicoService {

    @Autowired
    private HistorialClinicoRepository repository;

    @Override
    public HistorialClinico guardar(HistorialClinico entity) {
        return repository.save(entity);
    }

    @Override
    public List<HistorialClinico> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public HistorialClinico obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Historial no encontrado con ID: " + id));
    }

    @Override
    public HistorialClinico actualizar(Long id, HistorialClinico entity) {
        HistorialClinico existente = obtenerPorId(id);
        existente.setDiagnostico(entity.getDiagnostico());
        existente.setTratamiento(entity.getTratamiento());
        existente.setObservaciones(entity.getObservaciones());
        existente.setPeso(entity.getPeso());
        existente.setAltura(entity.getAltura());
        existente.setPresionArterial(entity.getPresionArterial());
        existente.setTemperatura(entity.getTemperatura());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Historial no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<HistorialClinico> buscarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    @Override
    public List<HistorialClinico> buscarPorMedico(Long medicoId) {
        return repository.findByMedicoId(medicoId);
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}