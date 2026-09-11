<<<<<<< HEAD
package gt.edu.umg.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.dao.EnfermedadRepository;
import gt.edu.umg.core.entities.Enfermedad;

@Service
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    @Override
    public Enfermedad guardar(Enfermedad enfermedad) {
        // Validar que no exista otra enfermedad con el mismo nombre
        if (enfermedadRepository.existsByNombre(enfermedad.getNombre())) {
            throw new RuntimeException("Ya existe una enfermedad con el nombre: " + enfermedad.getNombre());
        }
        
        // Validar que no exista otra enfermedad con el mismo código CIE
        if (enfermedad.getCodigoCie() != null && 
            enfermedadRepository.existsByCodigoCie(enfermedad.getCodigoCie())) {
            throw new RuntimeException("Ya existe una enfermedad con el código CIE: " + enfermedad.getCodigoCie());
        }
        
        // Validar nivel de gravedad
        if (enfermedad.getNivelGravedad() != null) {
            if (enfermedad.getNivelGravedad() < 1 || enfermedad.getNivelGravedad() > 5) {
                throw new IllegalArgumentException("El nivel de gravedad debe estar entre 1 y 5");
            }
        }
        
        // Establecer valores por defecto
        if (enfermedad.getActivo() == null) {
            enfermedad.setActivo(true);
        }
        if (enfermedad.getEsCronica() == null) {
            enfermedad.setEsCronica(false);
        }
        if (enfermedad.getEsContagiosa() == null) {
            enfermedad.setEsContagiosa(false);
        }
        
        return enfermedadRepository.save(enfermedad);
    }

    @Override
    public List<Enfermedad> obtenerTodos() {
        return enfermedadRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Enfermedad obtenerPorId(Long id) {
        return enfermedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Enfermedad enfermedad = obtenerPorId(id);
        
        // Soft delete (eliminación lógica)
        enfermedad.setActivo(false);
        enfermedad.setFechaActualizacion(LocalDateTime.now());
        enfermedadRepository.save(enfermedad);
    }

    @Override
    public Enfermedad actualizar(Long id, Enfermedad enfermedadActualizada) {
        Enfermedad enfermedadExistente = obtenerPorId(id);
        
        // Validar que no exista otra enfermedad con el mismo nombre (excluyendo la actual)
        if (!enfermedadExistente.getNombre().equals(enfermedadActualizada.getNombre()) &&
            enfermedadRepository.existsByNombre(enfermedadActualizada.getNombre())) {
            throw new RuntimeException(
                "Ya existe otra enfermedad con el nombre: " + enfermedadActualizada.getNombre()
            );
        }
        
        // Validar que no exista otra enfermedad con el mismo código CIE (excluyendo la actual)
        if (enfermedadActualizada.getCodigoCie() != null) {
            Optional<Enfermedad> existente = enfermedadRepository.findByCodigoCie(
                enfermedadActualizada.getCodigoCie()
            );
            if (existente.isPresent() && !existente.get().getId().equals(id)) {
                throw new RuntimeException(
                    "Ya existe otra enfermedad con el código CIE: " + enfermedadActualizada.getCodigoCie()
                );
            }
        }
        
        // Actualizar solo los campos que vienen en la petición
        if (enfermedadActualizada.getNombre() != null) {
            enfermedadExistente.setNombre(enfermedadActualizada.getNombre());
        }
        if (enfermedadActualizada.getDescripcion() != null) {
            enfermedadExistente.setDescripcion(enfermedadActualizada.getDescripcion());
        }
        if (enfermedadActualizada.getSintomas() != null) {
            enfermedadExistente.setSintomas(enfermedadActualizada.getSintomas());
        }
        if (enfermedadActualizada.getTratamiento() != null) {
            enfermedadExistente.setTratamiento(enfermedadActualizada.getTratamiento());
        }
        if (enfermedadActualizada.getCategoria() != null) {
            enfermedadExistente.setCategoria(enfermedadActualizada.getCategoria());
        }
        if (enfermedadActualizada.getCodigoCie() != null) {
            enfermedadExistente.setCodigoCie(enfermedadActualizada.getCodigoCie());
        }
        if (enfermedadActualizada.getNivelGravedad() != null) {
            if (enfermedadActualizada.getNivelGravedad() < 1 || 
                enfermedadActualizada.getNivelGravedad() > 5) {
                throw new IllegalArgumentException("El nivel de gravedad debe estar entre 1 y 5");
            }
            enfermedadExistente.setNivelGravedad(enfermedadActualizada.getNivelGravedad());
        }
        if (enfermedadActualizada.getEsCronica() != null) {
            enfermedadExistente.setEsCronica(enfermedadActualizada.getEsCronica());
        }
        if (enfermedadActualizada.getEsContagiosa() != null) {
            enfermedadExistente.setEsContagiosa(enfermedadActualizada.getEsContagiosa());
        }
        if (enfermedadActualizada.getTiempoRecuperacionDias() != null) {
            enfermedadExistente.setTiempoRecuperacionDias(
                enfermedadActualizada.getTiempoRecuperacionDias()
            );
        }
        if (enfermedadActualizada.getActivo() != null) {
            enfermedadExistente.setActivo(enfermedadActualizada.getActivo());
        }
        
        // Actualizar fecha de modificación
        enfermedadExistente.setFechaActualizacion(LocalDateTime.now());
        
        return enfermedadRepository.save(enfermedadExistente);
    }

    @Override
    public List<Enfermedad> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return List.of();
        }
        return enfermedadRepository.findByNombreContainingIgnoreCase(nombre.trim());
    }

    @Override
    public List<Enfermedad> buscarPorCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            return List.of();
        }
        return enfermedadRepository.findByCategoria(categoria.trim());
    }

    @Override
    public List<Enfermedad> buscarActivos() {
        return enfermedadRepository.findByActivoTrue();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return enfermedadRepository.existsByNombre(nombre);
    }

    @Override
    public boolean existePorNombreYIdDiferente(String nombre, Long id) {
        return enfermedadRepository.existsByNombreAndIdNot(nombre, id);
    }
=======
package gt.edu.umg.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.dao.EnfermedadRepository;
import gt.edu.umg.core.entities.Enfermedad;

@Service
@Transactional
public class EnfermedadServiceImpl implements EnfermedadService {

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    @Override
    public Enfermedad guardar(Enfermedad enfermedad) {
        // Validar que no exista otra enfermedad con el mismo nombre
        if (enfermedadRepository.existsByNombre(enfermedad.getNombre())) {
            throw new RuntimeException("Ya existe una enfermedad con el nombre: " + enfermedad.getNombre());
        }
        
        // Validar que no exista otra enfermedad con el mismo código CIE
        if (enfermedad.getCodigoCie() != null && 
            enfermedadRepository.existsByCodigoCie(enfermedad.getCodigoCie())) {
            throw new RuntimeException("Ya existe una enfermedad con el código CIE: " + enfermedad.getCodigoCie());
        }
        
        // Validar nivel de gravedad
        if (enfermedad.getNivelGravedad() != null) {
            if (enfermedad.getNivelGravedad() < 1 || enfermedad.getNivelGravedad() > 5) {
                throw new IllegalArgumentException("El nivel de gravedad debe estar entre 1 y 5");
            }
        }
        
        // Establecer valores por defecto
        if (enfermedad.getActivo() == null) {
            enfermedad.setActivo(true);
        }
        if (enfermedad.getEsCronica() == null) {
            enfermedad.setEsCronica(false);
        }
        if (enfermedad.getEsContagiosa() == null) {
            enfermedad.setEsContagiosa(false);
        }
        
        return enfermedadRepository.save(enfermedad);
    }

    @Override
    public List<Enfermedad> obtenerTodos() {
        return enfermedadRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Enfermedad obtenerPorId(Long id) {
        return enfermedadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        Enfermedad enfermedad = obtenerPorId(id);
        
        // Soft delete (eliminación lógica)
        enfermedad.setActivo(false);
        enfermedad.setFechaActualizacion(LocalDateTime.now());
        enfermedadRepository.save(enfermedad);
    }

    @Override
    public Enfermedad actualizar(Long id, Enfermedad enfermedadActualizada) {
        Enfermedad enfermedadExistente = obtenerPorId(id);
        
        // Validar que no exista otra enfermedad con el mismo nombre (excluyendo la actual)
        if (!enfermedadExistente.getNombre().equals(enfermedadActualizada.getNombre()) &&
            enfermedadRepository.existsByNombre(enfermedadActualizada.getNombre())) {
            throw new RuntimeException(
                "Ya existe otra enfermedad con el nombre: " + enfermedadActualizada.getNombre()
            );
        }
        
        // Validar que no exista otra enfermedad con el mismo código CIE (excluyendo la actual)
        if (enfermedadActualizada.getCodigoCie() != null) {
            Optional<Enfermedad> existente = enfermedadRepository.findByCodigoCie(
                enfermedadActualizada.getCodigoCie()
            );
            if (existente.isPresent() && !existente.get().getId().equals(id)) {
                throw new RuntimeException(
                    "Ya existe otra enfermedad con el código CIE: " + enfermedadActualizada.getCodigoCie()
                );
            }
        }
        
        // Actualizar solo los campos que vienen en la petición
        if (enfermedadActualizada.getNombre() != null) {
            enfermedadExistente.setNombre(enfermedadActualizada.getNombre());
        }
        if (enfermedadActualizada.getDescripcion() != null) {
            enfermedadExistente.setDescripcion(enfermedadActualizada.getDescripcion());
        }
        if (enfermedadActualizada.getSintomas() != null) {
            enfermedadExistente.setSintomas(enfermedadActualizada.getSintomas());
        }
        if (enfermedadActualizada.getTratamiento() != null) {
            enfermedadExistente.setTratamiento(enfermedadActualizada.getTratamiento());
        }
        if (enfermedadActualizada.getCategoria() != null) {
            enfermedadExistente.setCategoria(enfermedadActualizada.getCategoria());
        }
        if (enfermedadActualizada.getCodigoCie() != null) {
            enfermedadExistente.setCodigoCie(enfermedadActualizada.getCodigoCie());
        }
        if (enfermedadActualizada.getNivelGravedad() != null) {
            if (enfermedadActualizada.getNivelGravedad() < 1 || 
                enfermedadActualizada.getNivelGravedad() > 5) {
                throw new IllegalArgumentException("El nivel de gravedad debe estar entre 1 y 5");
            }
            enfermedadExistente.setNivelGravedad(enfermedadActualizada.getNivelGravedad());
        }
        if (enfermedadActualizada.getEsCronica() != null) {
            enfermedadExistente.setEsCronica(enfermedadActualizada.getEsCronica());
        }
        if (enfermedadActualizada.getEsContagiosa() != null) {
            enfermedadExistente.setEsContagiosa(enfermedadActualizada.getEsContagiosa());
        }
        if (enfermedadActualizada.getTiempoRecuperacionDias() != null) {
            enfermedadExistente.setTiempoRecuperacionDias(
                enfermedadActualizada.getTiempoRecuperacionDias()
            );
        }
        if (enfermedadActualizada.getActivo() != null) {
            enfermedadExistente.setActivo(enfermedadActualizada.getActivo());
        }
        
        // Actualizar fecha de modificación
        enfermedadExistente.setFechaActualizacion(LocalDateTime.now());
        
        return enfermedadRepository.save(enfermedadExistente);
    }

    @Override
    public List<Enfermedad> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return List.of();
        }
        return enfermedadRepository.findByNombreContainingIgnoreCase(nombre.trim());
    }

    @Override
    public List<Enfermedad> buscarPorCategoria(String categoria) {
        if (categoria == null || categoria.trim().isEmpty()) {
            return List.of();
        }
        return enfermedadRepository.findByCategoria(categoria.trim());
    }

    @Override
    public List<Enfermedad> buscarActivos() {
        return enfermedadRepository.findByActivoTrue();
    }

    @Override
    public boolean existePorNombre(String nombre) {
        return enfermedadRepository.existsByNombre(nombre);
    }

    @Override
    public boolean existePorNombreYIdDiferente(String nombre, Long id) {
        return enfermedadRepository.existsByNombreAndIdNot(nombre, id);
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}