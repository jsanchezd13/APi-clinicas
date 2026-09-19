package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Enfermedad;
import gt.edu.umg.core.entities.Dtos.Request.EnfermedadRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.EnfermedadResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class EnfermedadMapper {

    // Convertir RequestDto -> Entity
    public Enfermedad toEntity(EnfermedadRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Enfermedad enfermedad = new Enfermedad();
        
        // Asignar valores del DTO a la entidad
        enfermedad.setNombre(requestDto.nombre());
        enfermedad.setDescripcion(requestDto.descripcion());
        enfermedad.setSintomas(requestDto.sintomas());
        enfermedad.setTratamiento(requestDto.tratamiento());
        enfermedad.setCategoria(requestDto.categoria());
        enfermedad.setCodigoCie(requestDto.codigoCie());
        enfermedad.setNivelGravedad(requestDto.nivelGravedad());
        
        // Valores por defecto
        enfermedad.setActivo(true);
        enfermedad.setEsCronica(requestDto.esCronica() != null ? requestDto.esCronica() : false);
        enfermedad.setEsContagiosa(requestDto.esContagiosa() != null ? requestDto.esContagiosa() : false);
        enfermedad.setTiempoRecuperacionDias(requestDto.tiempoRecuperacionDias());
        
        return enfermedad;
    }

    // Convertir Entity -> ResponseDto
    public EnfermedadResponseDto toDto(Enfermedad entity) {
        if (entity == null) {
            return null;
        }

        return new EnfermedadResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getSintomas(),
            entity.getTratamiento(),
            entity.getCategoria(),
            entity.getCodigoCie(),
            entity.getNivelGravedad(),
            nivelGravedadToTexto(entity.getNivelGravedad()),
            entity.getEsCronica(),
            entity.getEsContagiosa(),
            entity.getTiempoRecuperacionDias(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion(),
            entity.getActivo()
        );
    }

    // Convertir List<Entity> -> List<ResponseDto>
    public List<EnfermedadResponseDto> toDtoList(List<Enfermedad> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Método auxiliar para convertir nivel de gravedad a texto
    private String nivelGravedadToTexto(Integer nivel) {
        if (nivel == null) {
            return "No especificado";
        }
        switch (nivel) {
            case 1: return "Leve";
            case 2: return "Moderado";
            case 3: return "Grave";
            case 4: return "Muy Grave";
            case 5: return "Crítico";
            default: return "Desconocido";
        }
    }
}