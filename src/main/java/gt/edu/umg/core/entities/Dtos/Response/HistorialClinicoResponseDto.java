package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record HistorialClinicoResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombre,

    Long medicoId,

    String medicoNombre,

    LocalDateTime fechaVisita,

    String diagnostico,

    String tratamiento,

    String observaciones,

    Double peso,

    Double altura,

    String presionArterial,

    Double temperatura,

    Boolean activo,

    LocalDateTime fechaRegistro

) {}