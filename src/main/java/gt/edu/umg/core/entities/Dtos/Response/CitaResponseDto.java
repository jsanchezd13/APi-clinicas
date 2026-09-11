<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record CitaResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombreCompleto,

    Long medicoId,

    String medicoNombreCompleto,

    String medicoEspecialidad,

    LocalDateTime fechaHora,

    String fechaHoraFormateada,

    Integer duracionMinutos,

    String motivo,

    String estado,

    String estadoTexto,

    String notas,

    Boolean activo,

    LocalDateTime fechaCreacion,

    LocalDateTime fechaActualizacion

=======
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record CitaResponseDto(

    Long id,

    Long pacienteId,

    String pacienteNombreCompleto,

    Long medicoId,

    String medicoNombreCompleto,

    String medicoEspecialidad,

    LocalDateTime fechaHora,

    String fechaHoraFormateada,

    Integer duracionMinutos,

    String motivo,

    String estado,

    String estadoTexto,

    String notas,

    Boolean activo,

    LocalDateTime fechaCreacion,

    LocalDateTime fechaActualizacion

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}