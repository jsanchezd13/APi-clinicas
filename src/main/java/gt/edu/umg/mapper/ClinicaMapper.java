package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Clinica;
import gt.edu.umg.core.entities.Dtos.Request.ClinicaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.ClinicaResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClinicaMapper {

    public Clinica toEntity(ClinicaRequestDto dto) {
        if (dto == null) return null;

        Clinica entity = new Clinica();
        entity.setNombre(dto.nombre());
        entity.setDireccion(dto.direccion());
        entity.setTelefono(dto.telefono());
        entity.setEmail(dto.email());
        entity.setTipo(dto.tipo());
        entity.setCapacidad(dto.capacidad());
        entity.setNivel(dto.nivel());
        entity.setActivo(true);

        return entity;
    }

    public ClinicaResponseDto toDto(Clinica entity) {
        if (entity == null) return null;

        return new ClinicaResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDireccion(),
            entity.getTelefono(),
            entity.getEmail(),
            entity.getTipo(),
            entity.getCapacidad(),
            entity.getNivel(),
            entity.getActivo(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion()
        );
    }

    public List<ClinicaResponseDto> toDtoList(List<Clinica> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(Clinica entity, ClinicaRequestDto dto) {
        if (dto == null) return;

        if (dto.nombre() != null) entity.setNombre(dto.nombre());
        if (dto.direccion() != null) entity.setDireccion(dto.direccion());
        if (dto.telefono() != null) entity.setTelefono(dto.telefono());
        if (dto.email() != null) entity.setEmail(dto.email());
        if (dto.tipo() != null) entity.setTipo(dto.tipo());
        if (dto.capacidad() != null) entity.setCapacidad(dto.capacidad());
        if (dto.nivel() != null) entity.setNivel(dto.nivel());
    }
}