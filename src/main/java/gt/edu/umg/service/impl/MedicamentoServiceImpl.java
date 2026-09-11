<<<<<<< HEAD
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.dao.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    @Override
    public Medicamento guardar(Medicamento entity) {
        if (repository.existsByNombreIgnoreCase(entity.getNombre())) {
            throw new RuntimeException("Ya existe un medicamento con el nombre: " + entity.getNombre());
        }
        if (entity.getStock() == null) entity.setStock(0);
        if (entity.getRequiereReceta() == null) entity.setRequiereReceta(true);
        if (entity.getActivo() == null) entity.setActivo(true);
        return repository.save(entity);
    }

    @Override
    public List<Medicamento> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Medicamento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con ID: " + id));
    }

    @Override
    public Medicamento actualizar(Long id, Medicamento entity) {
        Medicamento existente = obtenerPorId(id);

        if (!existente.getNombre().equalsIgnoreCase(entity.getNombre()) &&
            repository.existsByNombreIgnoreCase(entity.getNombre())) {
            throw new RuntimeException("Ya existe otro medicamento con el nombre: " + entity.getNombre());
        }

        existente.setNombre(entity.getNombre());
        existente.setDescripcion(entity.getDescripcion());
        existente.setCategoria(entity.getCategoria());
        existente.setLaboratorio(entity.getLaboratorio());
        existente.setPresentacion(entity.getPresentacion());
        existente.setDosisRecomendada(entity.getDosisRecomendada());
        existente.setRequiereReceta(entity.getRequiereReceta());
        existente.setPrecio(entity.getPrecio());
        existente.setStock(entity.getStock());
        existente.setActivo(entity.getActivo());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Medicamento no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Medicamento> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Medicamento> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public List<Medicamento> buscarPorLaboratorio(String laboratorio) {
        return repository.findByLaboratorioIgnoreCase(laboratorio);
    }

    @Override
    public List<Medicamento> buscarActivos() {
        return repository.findByActivoTrue();
    }

    @Override
    public List<Medicamento> buscarConReceta() {
        return repository.findByRequiereRecetaTrue();
    }
=======
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.dao.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    private MedicamentoRepository repository;

    @Override
    public Medicamento guardar(Medicamento entity) {
        if (repository.existsByNombreIgnoreCase(entity.getNombre())) {
            throw new RuntimeException("Ya existe un medicamento con el nombre: " + entity.getNombre());
        }
        if (entity.getStock() == null) entity.setStock(0);
        if (entity.getRequiereReceta() == null) entity.setRequiereReceta(true);
        if (entity.getActivo() == null) entity.setActivo(true);
        return repository.save(entity);
    }

    @Override
    public List<Medicamento> obtenerTodos() {
        return repository.findAll();
    }

    @Override
    public Medicamento obtenerPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado con ID: " + id));
    }

    @Override
    public Medicamento actualizar(Long id, Medicamento entity) {
        Medicamento existente = obtenerPorId(id);

        if (!existente.getNombre().equalsIgnoreCase(entity.getNombre()) &&
            repository.existsByNombreIgnoreCase(entity.getNombre())) {
            throw new RuntimeException("Ya existe otro medicamento con el nombre: " + entity.getNombre());
        }

        existente.setNombre(entity.getNombre());
        existente.setDescripcion(entity.getDescripcion());
        existente.setCategoria(entity.getCategoria());
        existente.setLaboratorio(entity.getLaboratorio());
        existente.setPresentacion(entity.getPresentacion());
        existente.setDosisRecomendada(entity.getDosisRecomendada());
        existente.setRequiereReceta(entity.getRequiereReceta());
        existente.setPrecio(entity.getPrecio());
        existente.setStock(entity.getStock());
        existente.setActivo(entity.getActivo());

        return repository.save(existente);
    }

    @Override
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Medicamento no encontrado con ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<Medicamento> buscarPorNombre(String nombre) {
        return repository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Medicamento> buscarPorCategoria(String categoria) {
        return repository.findByCategoriaIgnoreCase(categoria);
    }

    @Override
    public List<Medicamento> buscarPorLaboratorio(String laboratorio) {
        return repository.findByLaboratorioIgnoreCase(laboratorio);
    }

    @Override
    public List<Medicamento> buscarActivos() {
        return repository.findByActivoTrue();
    }

    @Override
    public List<Medicamento> buscarConReceta() {
        return repository.findByRequiereRecetaTrue();
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}