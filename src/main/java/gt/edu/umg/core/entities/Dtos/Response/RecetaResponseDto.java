<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecetaResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombre,

    Long medicoId,

    String medicoNombre,

    Long citaId,

    LocalDateTime fechaEmision,

    String fechaEmisionFormateada,

    String medicamentos,

    String indicaciones,

    Integer duracionDias,

    LocalDate fechaVencimiento,

    Boolean activo,

    LocalDateTime fechaRegistro

=======
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record RecetaResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombre,

    Long medicoId,

    String medicoNombre,

    Long citaId,

    LocalDateTime fechaEmision,

    String fechaEmisionFormateada,

    String medicamentos,

    String indicaciones,

    Integer duracionDias,

    LocalDate fechaVencimiento,

    Boolean activo,

    LocalDateTime fechaRegistro

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}