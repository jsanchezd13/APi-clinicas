package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record PacienteEnfermedadRequestDto(

    @NotNull(message = "El ID del paciente es obligatorio")
    Long pacienteId,

    @NotNull(message = "El ID de la enfermedad es obligatorio")
    Long enfermedadId,

    @NotNull(message = "La fecha de diagnóstico es obligatoria")
    LocalDate fechaDiagnostico,

    String estado,

    String observaciones

) {}