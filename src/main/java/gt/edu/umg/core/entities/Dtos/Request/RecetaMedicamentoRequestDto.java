<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RecetaMedicamentoRequestDto(

    @NotNull(message = "El ID de la receta es obligatorio")
    Long recetaId,

    @NotNull(message = "El ID del medicamento es obligatorio")
    Long medicamentoId,

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    Integer cantidad,

    String frecuencia,

    Integer duracionDias,

    String notas

=======
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record RecetaMedicamentoRequestDto(

    @NotNull(message = "El ID de la receta es obligatorio")
    Long recetaId,

    @NotNull(message = "El ID del medicamento es obligatorio")
    Long medicamentoId,

    @NotNull(message = "La cantidad es obligatoria")
    @Min(value = 1, message = "La cantidad debe ser al menos 1")
    Integer cantidad,

    String frecuencia,

    Integer duracionDias,

    String notas

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}