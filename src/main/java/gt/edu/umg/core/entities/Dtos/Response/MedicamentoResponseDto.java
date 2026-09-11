<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record MedicamentoResponseDto(

    Long id,

    String nombre,

    String descripcion,

    String categoria,

    String laboratorio,

    String presentacion,

    String dosisRecomendada,

    Boolean requiereReceta,

    String requiereRecetaTexto,

    Double precio,

    Integer stock,

    Boolean activo,

    LocalDateTime fechaRegistro,

    LocalDateTime fechaActualizacion

=======
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record MedicamentoResponseDto(

    Long id,

    String nombre,

    String descripcion,

    String categoria,

    String laboratorio,

    String presentacion,

    String dosisRecomendada,

    Boolean requiereReceta,

    String requiereRecetaTexto,

    Double precio,

    Integer stock,

    Boolean activo,

    LocalDateTime fechaRegistro,

    LocalDateTime fechaActualizacion

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}