<<<<<<< HEAD
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

public record MedicoRequestDto(
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    String apellido,

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 100, message = "La especialidad no puede exceder 100 caracteres")
    String especialidad,

    @NotBlank(message = "La matrícula es obligatoria")
    @Size(max = 50, message = "La matrícula no puede exceder 50 caracteres")
    String matricula,

    @Size(max = 20, message = "El teléfono no puede exceder 20 caracteres")
    String telefono,

    @Size(max = 100, message = "El correo no puede exceder 100 caracteres")
    String email,

    @Size(max = 50, message = "El horario debe tener formato HH:mm:ss")
    String horarioInicio,

    @Size(max = 50, message = "El horario debe tener formato HH:mm:ss")
    String horarioFin,

    Integer aniosExperiencia

=======
package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

public record MedicoRequestDto(
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    String nombre,

    @NotBlank(message = "El apellido es obligatorio")
    @Size(min = 2, max = 100, message = "El apellido debe tener entre 2 y 100 caracteres")
    String apellido,

    @NotBlank(message = "La especialidad es obligatoria")
    @Size(max = 100, message = "La especialidad no puede exceder 100 caracteres")
    String especialidad,

    @NotBlank(message = "La matrícula es obligatoria")
    @Size(max = 50, message = "La matrícula no puede exceder 50 caracteres")
    String matricula,

    @Size(max = 20, message = "El teléfono no puede exceder 20 caracteres")
    String telefono,

    @Size(max = 100, message = "El correo no puede exceder 100 caracteres")
    String email,

    @Size(max = 50, message = "El horario debe tener formato HH:mm:ss")
    String horarioInicio,

    @Size(max = 50, message = "El horario debe tener formato HH:mm:ss")
    String horarioFin,

    Integer aniosExperiencia

>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
) {}