package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
 
import java.time.LocalDateTime;

public record CitaRequestDto(

    @NotNull(message = "El ID del paciente es obligatorio")
    Long pacienteId,

    @NotNull(message = "El ID del médico es obligatorio")
    Long medicoId,

    @NotNull(message = "La fecha y hora de la cita es obligatoria")
    @Future(message = "La fecha de la cita debe ser futura")
    LocalDateTime fechaHora,

    Integer duracionMinutos,

    @Size(max = 255, message = "El motivo no puede exceder 255 caracteres")
    String motivo,

    String estado,

    String notas
) {}