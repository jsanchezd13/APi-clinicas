package gt.edu.umg.core.entities.Dtos.Response;

public record RecetaMedicamentoResponseDto(

    Long id,

    Long recetaId,

    Long medicamentoId,

    String medicamentoNombre,

    String medicamentoPresentacion,

    Integer cantidad,

    String frecuencia,

    Integer duracionDias,

    String notas
) {}