<<<<<<< HEAD
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Cita;
import gt.edu.umg.core.entities.Dtos.Request.RecetaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.MedicoRepository;
import gt.edu.umg.dao.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class RecetaMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private CitaRepository citaRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Receta toEntity(RecetaRequestDto dto) {
        if (dto == null) return null;

        Receta entity = new Receta();

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        entity.setPaciente(paciente);

        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
        entity.setMedico(medico);

        if (dto.citaId() != null) {
            Cita cita = citaRepository.findById(dto.citaId())
                    .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
            entity.setCita(cita);
        }

        entity.setFechaEmision(dto.fechaEmision() != null ? dto.fechaEmision() : LocalDateTime.now());
        entity.setMedicamentos(dto.medicamentos());
        entity.setIndicaciones(dto.indicaciones());
        entity.setDuracionDias(dto.duracionDias());
        entity.setFechaVencimiento(dto.fechaVencimiento());
        entity.setActivo(true);

        return entity;
    }

    public RecetaResponseDto toDto(Receta entity) {
        if (entity == null) return null;

        String fechaEmisionFormateada = entity.getFechaEmision().format(DATE_FORMATTER);

        return new RecetaResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido(),
            entity.getMedico().getId(),
            entity.getMedico().getNombre() + " " + entity.getMedico().getApellido(),
            entity.getCita() != null ? entity.getCita().getId() : null,
            entity.getFechaEmision(),
            fechaEmisionFormateada,
            entity.getMedicamentos(),
            entity.getIndicaciones(),
            entity.getDuracionDias(),
            entity.getFechaVencimiento(),
            entity.getActivo(),
            entity.getFechaRegistro()
        );
    }

    public List<RecetaResponseDto> toDtoList(List<Receta> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(Receta entity, RecetaRequestDto dto) {
        if (dto == null) return;

        if (dto.medicamentos() != null) entity.setMedicamentos(dto.medicamentos());
        if (dto.indicaciones() != null) entity.setIndicaciones(dto.indicaciones());
        if (dto.duracionDias() != null) entity.setDuracionDias(dto.duracionDias());
        if (dto.fechaVencimiento() != null) entity.setFechaVencimiento(dto.fechaVencimiento());
    }
=======
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Cita;
import gt.edu.umg.core.entities.Dtos.Request.RecetaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaResponseDto;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.dao.MedicoRepository;
import gt.edu.umg.dao.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class RecetaMapper {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private CitaRepository citaRepository;

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public Receta toEntity(RecetaRequestDto dto) {
        if (dto == null) return null;

        Receta entity = new Receta();

        Paciente paciente = pacienteRepository.findById(dto.pacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));
        entity.setPaciente(paciente);

        Medico medico = medicoRepository.findById(dto.medicoId())
                .orElseThrow(() -> new RuntimeException("Médico no encontrado"));
        entity.setMedico(medico);

        if (dto.citaId() != null) {
            Cita cita = citaRepository.findById(dto.citaId())
                    .orElseThrow(() -> new RuntimeException("Cita no encontrada"));
            entity.setCita(cita);
        }

        entity.setFechaEmision(dto.fechaEmision() != null ? dto.fechaEmision() : LocalDateTime.now());
        entity.setMedicamentos(dto.medicamentos());
        entity.setIndicaciones(dto.indicaciones());
        entity.setDuracionDias(dto.duracionDias());
        entity.setFechaVencimiento(dto.fechaVencimiento());
        entity.setActivo(true);

        return entity;
    }

    public RecetaResponseDto toDto(Receta entity) {
        if (entity == null) return null;

        String fechaEmisionFormateada = entity.getFechaEmision().format(DATE_FORMATTER);

        return new RecetaResponseDto(
            entity.getId(),
            entity.getPaciente().getId(),
            entity.getPaciente().getNombre() + " " + entity.getPaciente().getApellido(),
            entity.getMedico().getId(),
            entity.getMedico().getNombre() + " " + entity.getMedico().getApellido(),
            entity.getCita() != null ? entity.getCita().getId() : null,
            entity.getFechaEmision(),
            fechaEmisionFormateada,
            entity.getMedicamentos(),
            entity.getIndicaciones(),
            entity.getDuracionDias(),
            entity.getFechaVencimiento(),
            entity.getActivo(),
            entity.getFechaRegistro()
        );
    }

    public List<RecetaResponseDto> toDtoList(List<Receta> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(Receta entity, RecetaRequestDto dto) {
        if (dto == null) return;

        if (dto.medicamentos() != null) entity.setMedicamentos(dto.medicamentos());
        if (dto.indicaciones() != null) entity.setIndicaciones(dto.indicaciones());
        if (dto.duracionDias() != null) entity.setDuracionDias(dto.duracionDias());
        if (dto.fechaVencimiento() != null) entity.setFechaVencimiento(dto.fechaVencimiento());
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}