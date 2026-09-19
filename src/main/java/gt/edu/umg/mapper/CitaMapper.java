package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Cita;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.CitaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.CitaResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CitaMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    // Convertir RequestDto -> Entity
    public Cita toEntity(CitaRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Cita cita = new Cita();

        // Obtener paciente y médico de la BD
        Paciente paciente = pacienteRepository.findById(requestDto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + requestDto.pacienteId()));
        Medico medico = medicoRepository.findById(requestDto.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado con ID: " + requestDto.medicoId()));

        cita.setPaciente(paciente);
        cita.setMedico(medico);
        cita.setFechaHora(requestDto.fechaHora());

        if (requestDto.duracionMinutos() != null) {
            cita.setDuracionMinutos(requestDto.duracionMinutos());
        }

        cita.setMotivo(requestDto.motivo());
        cita.setNotas(requestDto.notas());

        if (requestDto.estado() != null && !requestDto.estado().isEmpty()) {
            cita.setEstado(requestDto.estado());
        } else {
            cita.setEstado("PENDIENTE");
        }

        cita.setActivo(true);

        return cita;
    }

    // Convertir Entity -> ResponseDto
    public CitaResponseDto toDto(Cita entity) {
        if (entity == null) {
            return null;
        }

        String pacienteNombreCompleto = entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido();
        String medicoNombreCompleto = entity.getMedico().getNombre() + " " + entity.getMedico().getApellido();
        String fechaHoraFormateada = entity.getFechaHora().format(DATE_FORMATTER);
        String estadoTexto = getEstadoTexto(entity.getEstado());

        return new CitaResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            pacienteNombreCompleto,
            entity.getMedico().getId(),
            medicoNombreCompleto,
            entity.getMedico().getEspecialidad(),
            entity.getFechaHora(),
            fechaHoraFormateada,
            entity.getDuracionMinutos(),
            entity.getMotivo(),
            entity.getEstado(),
            estadoTexto,
            entity.getNotas(),
            entity.getActivo(),
            entity.getFechaCreacion(),
            entity.getFechaActualizacion()
        );
    }

    // Convertir List<Entity> -> List<ResponseDto>
    public List<CitaResponseDto> toDtoList(List<Cita> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Actualizar Entity existente desde RequestDto
    public void updateEntity(Cita entity, CitaRequestDto requestDto) {
        if (requestDto == null) {
            return;
        }

        if (requestDto.pacienteId() != null) {
            Paciente paciente = pacienteRepository.findById(requestDto.pacienteId())
                    .orElseThrow(() -> new RuntimeException("Paciente no encontrado con ID: " + requestDto.pacienteId()));
            entity.setPaciente(paciente);
        }

        if (requestDto.medicoId() != null) {
            Medico medico = medicoRepository.findById(requestDto.medicoId())
                    .orElseThrow(() -> new RuntimeException("Médico no encontrado con ID: " + requestDto.medicoId()));
            entity.setMedico(medico);
        }

        if (requestDto.fechaHora() != null) {
            entity.setFechaHora(requestDto.fechaHora());
        }

        if (requestDto.duracionMinutos() != null) {
            entity.setDuracionMinutos(requestDto.duracionMinutos());
        }

        if (requestDto.motivo() != null) {
            entity.setMotivo(requestDto.motivo());
        }

        if (requestDto.estado() != null) {
            entity.setEstado(requestDto.estado());
        }

        if (requestDto.notas() != null) {
            entity.setNotas(requestDto.notas());
        }
    }

    // Método auxiliar para convertir estado a texto
    private String getEstadoTexto(String estado) {
        if (estado == null) return "No especificado";
        switch (estado.toUpperCase()) {
            case "PENDIENTE": return "Pendiente";
            case "CONFIRMADA": return "Confirmada";
            case "COMPLETADA": return "Completada";
            case "CANCELADA": return "Cancelada";
            default: return estado;
        }
    }
}