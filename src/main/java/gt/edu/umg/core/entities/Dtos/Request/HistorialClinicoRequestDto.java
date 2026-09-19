package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record HistorialClinicoRequestDto(

    @NotNull(message = "El paciente es obligatorio")
    Long pacienteId,

    Long medicoId,

    LocalDateTime fechaVisita,

    String diagnostico,

    String tratamiento,

    String observaciones,

    Double peso,

    Double altura,

    String presionArterial,

    Double temperatura

) {}