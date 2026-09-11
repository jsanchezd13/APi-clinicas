<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record ClinicaResponseDto(

    Long id,

    String nombre,

    String direccion,

    String telefono,

    String email,

    String tipo,

    Integer capacidad,

    String nivel,

    Boolean activo,

    LocalDateTime fechaRegistro,

    LocalDateTime fechaActualizacion

=======
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record ClinicaResponseDto(

    Long id,

    String nombre,

    String direccion,

    String telefono,

    String email,

    String tipo,

    Integer capacidad,

    String nivel,

    Boolean activo,

    LocalDateTime fechaRegistro,

    LocalDateTime fechaActualizacion

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}