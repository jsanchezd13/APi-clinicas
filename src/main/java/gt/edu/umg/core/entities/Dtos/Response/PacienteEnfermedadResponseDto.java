package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDate;

public record PacienteEnfermedadResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombre,

    Long enfermedadId,

    String enfermedadNombre,

    LocalDate fechaDiagnostico,

    String estado,

    String observaciones

) {}