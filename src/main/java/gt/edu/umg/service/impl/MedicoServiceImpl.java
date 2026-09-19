package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.dao.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    @Override
    public Medico guardar(Medico medico) {
        // Validar matrícula única
        if (medicoRepository.existsByMatricula(medico.getMatricula())) {
            throw new RuntimeException("Ya existe un médico con la matrícula: " + medico.getMatricula());
        }

        // ELIMINAR validación de email único
        // if (medico.getEmail() != null && medicoRepository.existsByEmail(medico.getEmail())) {
        //     throw new RuntimeException("Ya existe un médico con el email: " + medico.getEmail());
        // }

        // Validar horario
        if (medico.getHorarioInicio() != null && medico.getHorarioFin() != null) {
            if (medico.getHorarioInicio().isAfter(medico.getHorarioFin())) {
                throw new RuntimeException("El horario de inicio debe ser anterior al horario de fin");
            }
        }

        // Valores por defecto
        if (medico.getActivo() == null) {
            medico.setActivo(true);
        }

        return medicoRepository.save(medico);
    }

    @Override
    public List<Medico> obtenerTodos() {
        return medicoRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Medico obtenerPorId(Long id) {
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con ID: " + id));
    }

    @Override
public void eliminar(Long id) {
    // Verificar que existe
    if (!medicoRepository.existsById(id)) {
        throw new RuntimeException("Médico no encontrado con ID: " + id);
    }
    // Eliminar físicamente
    medicoRepository.deleteById(id);
}

    @Override
    public Medico actualizar(Long id, Medico medicoActualizado) {
        Medico medicoExistente = obtenerPorId(id);

        // Validar matrícula única (excluyendo la actual)
        if (!medicoExistente.getMatricula().equals(medicoActualizado.getMatricula()) &&
            medicoRepository.existsByMatricula(medicoActualizado.getMatricula())) {
            throw new RuntimeException("Ya existe otro médico con la matrícula: " + medicoActualizado.getMatricula());
        }

        // ELIMINAR validación de email único en actualización
        // if (medicoActualizado.getEmail() != null) {
        //     Optional<Medico> existente = medicoRepository.findByEmail(medicoActualizado.getEmail());
        //     if (existente.isPresent() && !existente.get().getId().equals(id)) {
        //         throw new RuntimeException("Ya existe otro médico con el email: " + medicoActualizado.getEmail());
        //     }
        // }

        // Actualizar campos
        if (medicoActualizado.getNombre() != null) {
            medicoExistente.setNombre(medicoActualizado.getNombre());
        }
        if (medicoActualizado.getApellido() != null) {
            medicoExistente.setApellido(medicoActualizado.getApellido());
        }
        if (medicoActualizado.getEspecialidad() != null) {
            medicoExistente.setEspecialidad(medicoActualizado.getEspecialidad());
        }
        if (medicoActualizado.getMatricula() != null) {
            medicoExistente.setMatricula(medicoActualizado.getMatricula());
        }
        if (medicoActualizado.getTelefono() != null) {
            medicoExistente.setTelefono(medicoActualizado.getTelefono());
        }
        if (medicoActualizado.getEmail() != null) {
            medicoExistente.setEmail(medicoActualizado.getEmail());
        }
        if (medicoActualizado.getHorarioInicio() != null) {
            medicoExistente.setHorarioInicio(medicoActualizado.getHorarioInicio());
        }
        if (medicoActualizado.getHorarioFin() != null) {
            medicoExistente.setHorarioFin(medicoActualizado.getHorarioFin());
        }
        if (medicoActualizado.getAniosExperiencia() != null) {
            medicoExistente.setAniosExperiencia(medicoActualizado.getAniosExperiencia());
        }
        if (medicoActualizado.getActivo() != null) {
            medicoExistente.setActivo(medicoActualizado.getActivo());
        }

        medicoExistente.setFechaActualizacion(LocalDateTime.now());
        return medicoRepository.save(medicoExistente);
    }

    @Override
    public List<Medico> buscarPorEspecialidad(String especialidad) {
        if (especialidad == null || especialidad.trim().isEmpty()) {
            return List.of();
        }
        return medicoRepository.findByEspecialidadContainingIgnoreCase(especialidad.trim());
    }

    @Override
    public List<Medico> buscarPorNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            return List.of();
        }
        return medicoRepository.findByNombreContainingIgnoreCase(nombre.trim());
    }

    @Override
    public List<Medico> buscarActivos() {
        return medicoRepository.findByActivoTrue();
    }

    @Override
    public List<Medico> buscarPorNombreYApellido(String nombre, String apellido) {
        return medicoRepository.findByNombreContainingIgnoreCaseAndApellidoContainingIgnoreCase(
            nombre != null ? nombre : "",
            apellido != null ? apellido : ""
        );
    }

    @Override
    public boolean existePorMatricula(String matricula) {
        return medicoRepository.existsByMatricula(matricula);
    }

    @Override
    public boolean existePorEmail(String email) {
        return false;
    }

    @Override
    public Medico obtenerPorMatricula(String matricula) {
        return medicoRepository.findByMatricula(matricula)
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con matrícula: " + matricula));
    }
}