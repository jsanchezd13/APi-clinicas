<<<<<<< HEAD
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

=======
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

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}