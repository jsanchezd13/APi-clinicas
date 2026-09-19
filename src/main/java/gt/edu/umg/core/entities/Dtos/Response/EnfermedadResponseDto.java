
package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;

public record EnfermedadResponseDto(
    
    Long id,
    
    String nombre,
    
    String descripcion,
    
    String sintomas,
    
    String tratamiento,
    
    String categoria,
    
    String codigoCie,
    
    Integer nivelGravedad,
    
    String nivelGravedadTexto,  // Campo calculado: "Leve", "Moderado", etc.
    
    Boolean esCronica,
    
    Boolean esContagiosa,
    
    Integer tiempoRecuperacionDias,
    
    LocalDateTime fechaRegistro,
    
    LocalDateTime fechaActualizacion,
    
    Boolean activo
    
) {}