package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record MedicamentoRequestDto(

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    String nombre,

    String descripcion,

    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    String categoria,

    @Size(max = 100, message = "El laboratorio no puede exceder 100 caracteres")
    String laboratorio,

    @Size(max = 50, message = "La presentación no puede exceder 50 caracteres")
    String presentacion,

    String dosisRecomendada,

    Boolean requiereReceta,

    Double precio,

    Integer stock


) {}