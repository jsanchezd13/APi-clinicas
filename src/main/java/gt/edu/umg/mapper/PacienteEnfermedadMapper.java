package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.PacienteEnfermedad;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Enfermedad;
import gt.edu.umg.core.entities.Dtos.Request.PacienteEnfermedadRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.PacienteEnfermedadResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.EnfermedadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PacienteEnfermedadMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnfermedadRepository enfermedadRepository;

    public PacienteEnfermedad toEntity(PacienteEnfermedadRequestDto dto) {
        if (dto == null) return null;

        PacienteEnfermedad entity = new PacienteEnfermedad();

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        entity.setPaciente(paciente);

        Enfermedad enfermedad = enfermedadRepository.findById(dto.enfermedadId())
                .orElseThrow(() -> new RuntimeException("Enfermedad no encontrada"));
        entity.setEnfermedad(enfermedad);

        entity.setFechaDiagnostico(dto.fechaDiagnostico());
        entity.setEstado(dto.estado() != null ? dto.estado() : "Activo");
        entity.setObservaciones(dto.observaciones());

        return entity;
    }

    public PacienteEnfermedadResponseDto toDto(PacienteEnfermedad entity) {
        if (entity == null) return null;

        return new PacienteEnfermedadResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido(),
            entity.getEnfermedad().getId(),
            entity.getEnfermedad().getNombre(),
            entity.getFechaDiagnostico(),
            entity.getEstado(),
            entity.getObservaciones()
        );
    }

    public List<PacienteEnfermedadResponseDto> toDtoList(List<PacienteEnfermedad> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(PacienteEnfermedad entity, PacienteEnfermedadRequestDto dto) {
        if (dto == null) return;

        if (dto.fechaDiagnostico() != null) {
            entity.setFechaDiagnostico(dto.fechaDiagnostico());
        }
        if (dto.estado() != null) {
            entity.setEstado(dto.estado());
        }
        if (dto.observaciones() != null) {
            entity.setObservaciones(dto.observaciones());
        }
    }

}