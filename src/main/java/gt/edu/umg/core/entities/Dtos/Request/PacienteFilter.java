package gt.edu.umg.core.entities.Dtos.Request;

public record PacienteFilter(
    String nombre,
    String apellido,
    String dpi,
    Boolean activo,
    Integer page,
    Integer size
) {}