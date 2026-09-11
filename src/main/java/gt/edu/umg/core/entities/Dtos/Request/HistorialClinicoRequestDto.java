<<<<<<< HEAD
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

=======
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

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}