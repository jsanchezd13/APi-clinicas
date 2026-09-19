package gt.edu.umg.core.entities.Dtos.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ClinicaRequestDto(

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 200, message = "El nombre debe tener entre 2 y 200 caracteres")
    String nombre,

    @NotBlank(message = "La dirección es obligatoria")
    @Size(max = 300, message = "La dirección no puede exceder 300 caracteres")
    String direccion,

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(max = 20, message = "El teléfono no puede exceder 20 caracteres")
    String telefono,

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe ser un correo electrónico válido")
    @Size(max = 100, message = "El email no puede exceder 100 caracteres")
    String email,

    @Size(max = 50, message = "El tipo no puede exceder 50 caracteres")
    String tipo,

    Integer capacidad,

    @Size(max = 20, message = "El nivel no puede exceder 20 caracteres")
    String nivel
) {}