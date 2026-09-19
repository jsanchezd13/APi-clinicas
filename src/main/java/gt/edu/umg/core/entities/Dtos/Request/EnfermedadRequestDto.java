package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record EnfermedadRequestDto(
    
    @NotBlank(message = "El nombre de la enfermedad es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    String nombre,
    
    @Size(max = 500, message = "La descripción no puede exceder 500 caracteres")
    String descripcion,
    
    @Size(max = 500, message = "Los síntomas no pueden exceder 500 caracteres")
    String sintomas,
    
    @Size(max = 500, message = "El tratamiento no puede exceder 500 caracteres")
    String tratamiento,
    
    @Size(max = 50, message = "La categoría no puede exceder 50 caracteres")
    String categoria,
    
    @Size(max = 20, message = "El código CIE no puede exceder 20 caracteres")
    String codigoCie,
    
    @Min(value = 1, message = "El nivel de gravedad debe ser al menos 1")
    @Max(value = 5, message = "El nivel de gravedad no puede ser mayor a 5")
    Integer nivelGravedad,
    
    Boolean esCronica,
    
    Boolean esContagiosa,
    
    @Min(value = 1, message = "El tiempo de recuperación debe ser al menos 1 día")
    Integer tiempoRecuperacionDias

) {}