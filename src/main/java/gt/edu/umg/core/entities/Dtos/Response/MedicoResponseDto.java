package gt.edu.umg.core.entities.Dtos.Response;

import java.time.LocalDateTime;
import java.time.LocalTime;

public record MedicoResponseDto(
    
    Long id,
    
    String nombre,
    
    String apellido,
    
    String nombreCompleto,
    
    String especialidad,
    
    String matricula,
    
    String telefono,
    
    String email,
    
    LocalTime horarioInicio,
    
    LocalTime horarioFin,
    
    Integer aniosExperiencia,
    
    String aniosExperienciaTexto,
    
    Boolean activo,
    
    LocalDateTime fechaRegistro,
    
    LocalDateTime fechaActualizacion

) {}