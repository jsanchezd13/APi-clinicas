<<<<<<< HEAD
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.HistorialClinico;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.HistorialClinicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.HistorialClinicoResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HistorialClinicoMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public HistorialClinico toEntity(HistorialClinicoRequestDto dto) {
        if (dto == null) return null;

        HistorialClinico entity = new HistorialClinico();

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        entity.setPaciente(paciente);

        if (dto.medicoId() != null) {
            Medico medico = medicoRepository.findById(dto.medicoId())
                    .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
            entity.setMedico(medico);
        }

        entity.setFechaVisita(dto.fechaVisita() != null ? dto.fechaVisita() : LocalDateTime.now());
        entity.setDiagnostico(dto.diagnostico());
        entity.setTratamiento(dto.tratamiento());
        entity.setObservaciones(dto.observaciones());
        entity.setPeso(dto.peso());
        entity.setAltura(dto.altura());
        entity.setPresionArterial(dto.presionArterial());
        entity.setTemperatura(dto.temperatura());
        entity.setActivo(true);

        return entity;
    }

    public HistorialClinicoResponseDto toDto(HistorialClinico entity) {
        if (entity == null) return null;

        return new HistorialClinicoResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido(),
            entity.getMedico() != null ? entity.getMedico().getId() : null,
            entity.getMedico() != null ? entity.getMedico().getNombre() + " " + entity.getMedico().getApellido() : null,
            entity.getFechaVisita(),
            entity.getDiagnostico(),
            entity.getTratamiento(),
            entity.getObservaciones(),
            entity.getPeso(),
            entity.getAltura(),
            entity.getPresionArterial(),
            entity.getTemperatura(),
            entity.getActivo(),
            entity.getFechaRegistro()
        );
    }

    public List<HistorialClinicoResponseDto> toDtoList(List<HistorialClinico> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(HistorialClinico entity, HistorialClinicoRequestDto dto) {
        if (dto == null) return;

        if (dto.diagnostico() != null) entity.setDiagnostico(dto.diagnostico());
        if (dto.tratamiento() != null) entity.setTratamiento(dto.tratamiento());
        if (dto.observaciones() != null) entity.setObservaciones(dto.observaciones());
        if (dto.peso() != null) entity.setPeso(dto.peso());
        if (dto.altura() != null) entity.setAltura(dto.altura());
        if (dto.presionArterial() != null) entity.setPresionArterial(dto.presionArterial());
        if (dto.temperatura() != null) entity.setTemperatura(dto.temperatura());
    }
=======
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.HistorialClinico;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.HistorialClinicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.HistorialClinicoResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HistorialClinicoMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public HistorialClinico toEntity(HistorialClinicoRequestDto dto) {
        if (dto == null) return null;

        HistorialClinico entity = new HistorialClinico();

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        entity.setPaciente(paciente);

        if (dto.medicoId() != null) {
            Medico medico = medicoRepository.findById(dto.medicoId())
                    .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
            entity.setMedico(medico);
        }

        entity.setFechaVisita(dto.fechaVisita() != null ? dto.fechaVisita() : LocalDateTime.now());
        entity.setDiagnostico(dto.diagnostico());
        entity.setTratamiento(dto.tratamiento());
        entity.setObservaciones(dto.observaciones());
        entity.setPeso(dto.peso());
        entity.setAltura(dto.altura());
        entity.setPresionArterial(dto.presionArterial());
        entity.setTemperatura(dto.temperatura());
        entity.setActivo(true);

        return entity;
    }

    public HistorialClinicoResponseDto toDto(HistorialClinico entity) {
        if (entity == null) return null;

        return new HistorialClinicoResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido(),
            entity.getMedico() != null ? entity.getMedico().getId() : null,
            entity.getMedico() != null ? entity.getMedico().getNombre() + " " + entity.getMedico().getApellido() : null,
            entity.getFechaVisita(),
            entity.getDiagnostico(),
            entity.getTratamiento(),
            entity.getObservaciones(),
            entity.getPeso(),
            entity.getAltura(),
            entity.getPresionArterial(),
            entity.getTemperatura(),
            entity.getActivo(),
            entity.getFechaRegistro()
        );
    }

    public List<HistorialClinicoResponseDto> toDtoList(List<HistorialClinico> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(HistorialClinico entity, HistorialClinicoRequestDto dto) {
        if (dto == null) return;

        if (dto.diagnostico() != null) entity.setDiagnostico(dto.diagnostico());
        if (dto.tratamiento() != null) entity.setTratamiento(dto.tratamiento());
        if (dto.observaciones() != null) entity.setObservaciones(dto.observaciones());
        if (dto.peso() != null) entity.setPeso(dto.peso());
        if (dto.altura() != null) entity.setAltura(dto.altura());
        if (dto.presionArterial() != null) entity.setPresionArterial(dto.presionArterial());
        if (dto.temperatura() != null) entity.setTemperatura(dto.temperatura());
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}