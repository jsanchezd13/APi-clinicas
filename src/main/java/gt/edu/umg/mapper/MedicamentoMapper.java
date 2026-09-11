<<<<<<< HEAD
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.core.entities.Dtos.Request.MedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicamentoResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoMapper {

    public Medicamento toEntity(MedicamentoRequestDto dto) {
        if (dto == null) return null;

        Medicamento entity = new Medicamento();
        entity.setNombre(dto.nombre());
        entity.setDescripcion(dto.descripcion());
        entity.setCategoria(dto.categoria());
        entity.setLaboratorio(dto.laboratorio());
        entity.setPresentacion(dto.presentacion());
        entity.setDosisRecomendada(dto.dosisRecomendada());
        entity.setRequiereReceta(dto.requiereReceta() != null ? dto.requiereReceta() : true);
        entity.setPrecio(dto.precio());
        entity.setStock(dto.stock() != null ? dto.stock() : 0);
        entity.setActivo(true);

        return entity;
    }

    public MedicamentoResponseDto toDto(Medicamento entity) {
        if (entity == null) return null;

        return new MedicamentoResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getCategoria(),
            entity.getLaboratorio(),
            entity.getPresentacion(),
            entity.getDosisRecomendada(),
            entity.getRequiereReceta(),
            entity.getRequiereReceta() ? "Sí" : "No",
            entity.getPrecio(),
            entity.getStock(),
            entity.getActivo(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion()
        );
    }

    public List<MedicamentoResponseDto> toDtoList(List<Medicamento> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(Medicamento entity, MedicamentoRequestDto dto) {
        if (dto == null) return;

        if (dto.nombre() != null) entity.setNombre(dto.nombre());
        if (dto.descripcion() != null) entity.setDescripcion(dto.descripcion());
        if (dto.categoria() != null) entity.setCategoria(dto.categoria());
        if (dto.laboratorio() != null) entity.setLaboratorio(dto.laboratorio());
        if (dto.presentacion() != null) entity.setPresentacion(dto.presentacion());
        if (dto.dosisRecomendada() != null) entity.setDosisRecomendada(dto.dosisRecomendada());
        if (dto.requiereReceta() != null) entity.setRequiereReceta(dto.requiereReceta());
        if (dto.precio() != null) entity.setPrecio(dto.precio());
        if (dto.stock() != null) entity.setStock(dto.stock());
    }
=======
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.core.entities.Dtos.Request.MedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicamentoResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicamentoMapper {

    public Medicamento toEntity(MedicamentoRequestDto dto) {
        if (dto == null) return null;

        Medicamento entity = new Medicamento();
        entity.setNombre(dto.nombre());
        entity.setDescripcion(dto.descripcion());
        entity.setCategoria(dto.categoria());
        entity.setLaboratorio(dto.laboratorio());
        entity.setPresentacion(dto.presentacion());
        entity.setDosisRecomendada(dto.dosisRecomendada());
        entity.setRequiereReceta(dto.requiereReceta() != null ? dto.requiereReceta() : true);
        entity.setPrecio(dto.precio());
        entity.setStock(dto.stock() != null ? dto.stock() : 0);
        entity.setActivo(true);

        return entity;
    }

    public MedicamentoResponseDto toDto(Medicamento entity) {
        if (entity == null) return null;

        return new MedicamentoResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getDescripcion(),
            entity.getCategoria(),
            entity.getLaboratorio(),
            entity.getPresentacion(),
            entity.getDosisRecomendada(),
            entity.getRequiereReceta(),
            entity.getRequiereReceta() ? "Sí" : "No",
            entity.getPrecio(),
            entity.getStock(),
            entity.getActivo(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion()
        );
    }

    public List<MedicamentoResponseDto> toDtoList(List<Medicamento> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(Medicamento entity, MedicamentoRequestDto dto) {
        if (dto == null) return;

        if (dto.nombre() != null) entity.setNombre(dto.nombre());
        if (dto.descripcion() != null) entity.setDescripcion(dto.descripcion());
        if (dto.categoria() != null) entity.setCategoria(dto.categoria());
        if (dto.laboratorio() != null) entity.setLaboratorio(dto.laboratorio());
        if (dto.presentacion() != null) entity.setPresentacion(dto.presentacion());
        if (dto.dosisRecomendada() != null) entity.setDosisRecomendada(dto.dosisRecomendada());
        if (dto.requiereReceta() != null) entity.setRequiereReceta(dto.requiereReceta());
        if (dto.precio() != null) entity.setPrecio(dto.precio());
        if (dto.stock() != null) entity.setStock(dto.stock());
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}