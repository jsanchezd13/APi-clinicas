<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.dao.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RecetaServiceImpl implements RecetaService {

    @Autowired
    private RecetaRepository repository;

    @Override
    public Receta guardar(Receta entity) {
        if (entity.getFechaEmision() == null) {
            entity.setFechaEmision(LocalDateTime.now());
        }
        if (entity.getActivo() == null) {
            entity.setActivo(true);
        }
        return repository.save(entity);
    }

    @Override
    public List<Receta> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Receta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada con ID: " + id));
    }

    @Override
    public Receta actualizar(Long id, Receta entity) {
        Receta existente = obtenerPorId(id);
        existente.setMedicamentos(entity.getMedicamentos());
        existente.setIndicaciones(entity.getIndicaciones());
        existente.setDuracionDias(entity.getDuracionDias());
        existente.setFechaVencimiento(entity.getFechaVencimiento());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Receta no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Receta> buscarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    @Override
    public List<Receta> buscarPorMedico(Long medicoId) {
        return repository.findByMedicoId(medicoId);
    }

    @Override
    public List<Receta> buscarPorCita(Long citaId) {
        return repository.findByCitaId(citaId);
    }

    @Override
    public List<Receta> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return repository.findByFechaEmisionBetween(inicio, fin);
    }

    @Override
    public List<Receta> buscarUltimasPorPaciente(Long pacienteId) {
        return repository.findUltimasRecetasByPaciente(pacienteId);
    }

    @Override
    public List<Receta> buscarRecetasVencidas() {
        return repository.findRecetasVencidas();
    }
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.dao.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class RecetaServiceImpl implements RecetaService {

    @Autowired
    private RecetaRepository repository;

    @Override
    public Receta guardar(Receta entity) {
        if (entity.getFechaEmision() == null) {
            entity.setFechaEmision(LocalDateTime.now());
        }
        if (entity.getActivo() == null) {
            entity.setActivo(true);
        }
        return repository.save(entity);
    }

    @Override
    public List<Receta> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Receta obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada con ID: " + id));
    }

    @Override
    public Receta actualizar(Long id, Receta entity) {
        Receta existente = obtenerPorId(id);
        existente.setMedicamentos(entity.getMedicamentos());
        existente.setIndicaciones(entity.getIndicaciones());
        existente.setDuracionDias(entity.getDuracionDias());
        existente.setFechaVencimiento(entity.getFechaVencimiento());
        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Receta no encontrada con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Receta> buscarPorPaciente(Long pacienteId) {
        return repository.findByPacienteId(pacienteId);
    }

    @Override
    public List<Receta> buscarPorMedico(Long medicoId) {
        return repository.findByMedicoId(medicoId);
    }

    @Override
    public List<Receta> buscarPorCita(Long citaId) {
        return repository.findByCitaId(citaId);
    }

    @Override
    public List<Receta> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return repository.findByFechaEmisionBetween(inicio, fin);
    }

    @Override
    public List<Receta> buscarUltimasPorPaciente(Long pacienteId) {
        return repository.findUltimasRecetasByPaciente(pacienteId);
    }

    @Override
    public List<Receta> buscarRecetasVencidas() {
        return repository.findRecetasVencidas();
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}