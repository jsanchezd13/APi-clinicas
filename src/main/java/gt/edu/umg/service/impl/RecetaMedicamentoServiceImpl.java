<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.RecetaMedicamento;
import gt.edu.umg.dao.RecetaMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecetaMedicamentoServiceImpl implements RecetaMedicamentoService {

    @Autowired
    private RecetaMedicamentoRepository repository;

    @Override
    public RecetaMedicamento guardar(RecetaMedicamento entity) {
        if (repository.existsByRecetaIdAndMedicamentoId(
                entity.getReceta().getId(),
                entity.getMedicamento().getId())) {
            throw new RuntimeException("Este medicamento ya está registrado en esta receta");
        }
        return repository.save(entity);
    }

    @Override
    public List<RecetaMedicamento> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public RecetaMedicamento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada con ID: " + id));
    }

    @Override
    public RecetaMedicamento actualizar(Long id, RecetaMedicamento entity) {
        RecetaMedicamento existente = obtenerPorId(id);
        existente.setCantidad(entity.getCantidad());
        existente.setFrecuencia(entity.getFrecuencia());
        existente.setDuracionDias(entity.getDuracionDias());
        existente.setNotas(entity.getNotas());
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
    public List<RecetaMedicamento> buscarPorReceta(Long recetaId) {
        return repository.findByRecetaId(recetaId);
    }

    @Override
    public List<RecetaMedicamento> buscarPorMedicamento(Long medicamentoId) {
        return repository.findByMedicamentoId(medicamentoId);
    }

    @Override
    public boolean existeRelacion(Long recetaId, Long medicamentoId) {
        return repository.existsByRecetaIdAndMedicamentoId(recetaId, medicamentoId);
    }
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.RecetaMedicamento;
import gt.edu.umg.dao.RecetaMedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecetaMedicamentoServiceImpl implements RecetaMedicamentoService {

    @Autowired
    private RecetaMedicamentoRepository repository;

    @Override
    public RecetaMedicamento guardar(RecetaMedicamento entity) {
        if (repository.existsByRecetaIdAndMedicamentoId(
                entity.getReceta().getId(),
                entity.getMedicamento().getId())) {
            throw new RuntimeException("Este medicamento ya está registrado en esta receta");
        }
        return repository.save(entity);
    }

    @Override
    public List<RecetaMedicamento> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public RecetaMedicamento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Relación no encontrada con ID: " + id));
    }

    @Override
    public RecetaMedicamento actualizar(Long id, RecetaMedicamento entity) {
        RecetaMedicamento existente = obtenerPorId(id);
        existente.setCantidad(entity.getCantidad());
        existente.setFrecuencia(entity.getFrecuencia());
        existente.setDuracionDias(entity.getDuracionDias());
        existente.setNotas(entity.getNotas());
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
    public List<RecetaMedicamento> buscarPorReceta(Long recetaId) {
        return repository.findByRecetaId(recetaId);
    }

    @Override
    public List<RecetaMedicamento> buscarPorMedicamento(Long medicamentoId) {
        return repository.findByMedicamentoId(medicamentoId);
    }

    @Override
    public boolean existeRelacion(Long recetaId, Long medicamentoId) {
        return repository.existsByRecetaIdAndMedicamentoId(recetaId, medicamentoId);
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}