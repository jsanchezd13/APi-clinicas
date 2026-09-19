package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Cita;
import gt.edu.umg.dao.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaRepository citaRepository;

    @Override
    public Cita guardar(Cita cita) {
        // Validar que no haya cita en el mismo horario para el médico
        if (citaRepository.existsByMedicoAndFechaHora(cita.getMedico().getId(), cita.getFechaHora())) {
            throw new RuntimeException("Ya existe una cita para este médico en esa fecha y hora");
        }

        // Validar que la cita sea en el futuro
        if (cita.getFechaHora().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("La cita debe ser en una fecha futura");
        }

        // Valores por defecto
        if (cita.getEstado() == null) {
            cita.setEstado("PENDIENTE");
        }
        if (cita.getActivo() == null) {
            cita.setActivo(true);
        }
        if (cita.getDuracionMinutos() == null) {
            cita.setDuracionMinutos(30);
        }

        return citaRepository.save(cita);
    }

    @Override
    public List<Cita> obtenerTodos() {
        return citaRepository.findAll();
    }

    @Override
    public Cita obtenerPorId(Long id) {
        return citaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cita no encontrada con ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        if (!citaRepository.existsById(id)) {
            throw new RuntimeException("Cita no encontrada con ID: " + id);
        }
        citaRepository.deleteById(id);
    }

    @Override
    public Cita actualizar(Long id, Cita citaActualizada) {
        Cita citaExistente = obtenerPorId(id);

        // Validar que no haya cita en el mismo horario para el médico (excluyendo la actual)
        if (citaRepository.existsByMedicoAndFechaHora(
                citaActualizada.getMedico().getId(), 
                citaActualizada.getFechaHora())) {
            // Verificar que no sea la misma cita
            List<Cita> citas = citaRepository.findByMedicoIdAndFechaHoraBetween(
                citaActualizada.getMedico().getId(),
                citaActualizada.getFechaHora().minusMinutes(1),
                citaActualizada.getFechaHora().plusMinutes(1)
            );
            for (Cita c : citas) {
                if (!c.getId().equals(id)) {
                    throw new RuntimeException("Ya existe una cita para este médico en esa fecha y hora");
                }
            }
        }

        // Actualizar campos
        if (citaActualizada.getPaciente() != null) {
            citaExistente.setPaciente(citaActualizada.getPaciente());
        }
        if (citaActualizada.getMedico() != null) {
            citaExistente.setMedico(citaActualizada.getMedico());
        }
        if (citaActualizada.getFechaHora() != null) {
            citaExistente.setFechaHora(citaActualizada.getFechaHora());
        }
        if (citaActualizada.getDuracionMinutos() != null) {
            citaExistente.setDuracionMinutos(citaActualizada.getDuracionMinutos());
        }
        if (citaActualizada.getMotivo() != null) {
            citaExistente.setMotivo(citaActualizada.getMotivo());
        }
        if (citaActualizada.getEstado() != null) {
            citaExistente.setEstado(citaActualizada.getEstado());
        }
        if (citaActualizada.getNotas() != null) {
            citaExistente.setNotas(citaActualizada.getNotas());
        }
        if (citaActualizada.getActivo() != null) {
            citaExistente.setActivo(citaActualizada.getActivo());
        }

        citaExistente.setFechaActualizacion(LocalDateTime.now());
        return citaRepository.save(citaExistente);
    }

    @Override
    public List<Cita> buscarPorPaciente(Long pacienteId) {
        return citaRepository.findByPacienteId(pacienteId);
    }

    @Override
    public List<Cita> buscarPorMedico(Long medicoId) {
        return citaRepository.findByMedicoId(medicoId);
    }

    @Override
    public List<Cita> buscarPorEstado(String estado) {
        return citaRepository.findByEstado(estado);
    }

    @Override
    public List<Cita> buscarPorRangoFechas(LocalDateTime inicio, LocalDateTime fin) {
        return citaRepository.findByFechaHoraBetween(inicio, fin);
    }

    @Override
    public List<Cita> buscarCitasFuturasPorPaciente(Long pacienteId) {
        return citaRepository.findCitasFuturasByPaciente(pacienteId, LocalDateTime.now());
    }

    @Override
    public List<Cita> buscarCitasFuturasPorMedico(Long medicoId) {
        return citaRepository.findCitasFuturasByMedico(medicoId, LocalDateTime.now());
    }

    @Override
    public List<Cita> buscarActivos() {
        return citaRepository.findByActivoTrue();
    }

    @Override
    public boolean existeCitaEnHorario(Long medicoId, LocalDateTime fechaHora) {
        return citaRepository.existsByMedicoAndFechaHora(medicoId, fechaHora);
    }

    @Override
    public Cita confirmarCita(Long id) {
        Cita cita = obtenerPorId(id);
        cita.setEstado("CONFIRMADA");
        cita.setFechaActualizacion(LocalDateTime.now());
        return citaRepository.save(cita);
    }

    @Override
    public Cita completarCita(Long id) {
        Cita cita = obtenerPorId(id);
        cita.setEstado("COMPLETADA");
        cita.setFechaActualizacion(LocalDateTime.now());
        return citaRepository.save(cita);
    }

    @Override
    public Cita cancelarCita(Long id) {
        Cita cita = obtenerPorId(id);
        cita.setEstado("CANCELADA");
        cita.setActivo(false);
        cita.setFechaActualizacion(LocalDateTime.now());
        return citaRepository.save(cita);
    }

}