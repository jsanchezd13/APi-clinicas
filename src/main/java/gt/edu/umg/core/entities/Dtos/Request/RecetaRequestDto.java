<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecetaRequestDto(

    @NotNull(message = "El ID del paciente es obligatorio")
    Long pacienteId,

    @NotNull(message = "El ID del médico es obligatorio")
    Long medicoId,

    Long citaId,

    LocalDateTime fechaEmision,

    @NotBlank(message = "Los medicamentos son obligatorios")
    String medicamentos,

    String indicaciones,

    Integer duracionDias,

    LocalDate fechaVencimiento

=======
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecetaRequestDto(

    @NotNull(message = "El ID del paciente es obligatorio")
    Long pacienteId,

    @NotNull(message = "El ID del médico es obligatorio")
    Long medicoId,

    Long citaId,

    LocalDateTime fechaEmision,

    @NotBlank(message = "Los medicamentos son obligatorios")
    String medicamentos,

    String indicaciones,

    Integer duracionDias,

    LocalDate fechaVencimiento

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}