<<<<<<< HEAD
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.RecetaMedicamento;
import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.core.entities.Dtos.Request.RecetaMedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaMedicamentoResponseDto;
import gt.edu.umg.dao.RecetaRepository;
import gt.edu.umg.dao.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecetaMedicamentoMapper {

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public RecetaMedicamento toEntity(RecetaMedicamentoRequestDto dto) {
        if (dto == null) return null;

        RecetaMedicamento entity = new RecetaMedicamento();

        Receta receta = recetaRepository.findById(dto.recetaId())
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        entity.setReceta(receta);

        Medicamento medicamento = medicamentoRepository.findById(dto.medicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
        entity.setMedicamento(medicamento);

        entity.setCantidad(dto.cantidad());
        entity.setFrecuencia(dto.frecuencia());
        entity.setDuracionDias(dto.duracionDias());
        entity.setNotas(dto.notas());

        return entity;
    }

    public RecetaMedicamentoResponseDto toDto(RecetaMedicamento entity) {
        if (entity == null) return null;

        return new RecetaMedicamentoResponseDto(
            entity.getId(),
            entity.getReceta().getId(),
            entity.getMedicamento().getId(),
            entity.getMedicamento().getNombre(),
            entity.getMedicamento().getPresentacion(),
            entity.getCantidad(),
            entity.getFrecuencia(),
            entity.getDuracionDias(),
            entity.getNotas()
        );
    }

    public List<RecetaMedicamentoResponseDto> toDtoList(List<RecetaMedicamento> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(RecetaMedicamento entity, RecetaMedicamentoRequestDto dto) {
        if (dto == null) return;

        if (dto.cantidad() != null) entity.setCantidad(dto.cantidad());
        if (dto.frecuencia() != null) entity.setFrecuencia(dto.frecuencia());
        if (dto.duracionDias() != null) entity.setDuracionDias(dto.duracionDias());
        if (dto.notas() != null) entity.setNotas(dto.notas());
    }
=======
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.RecetaMedicamento;
import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.core.entities.Dtos.Request.RecetaMedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaMedicamentoResponseDto;
import gt.edu.umg.dao.RecetaRepository;
import gt.edu.umg.dao.MedicamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecetaMedicamentoMapper {

    @Autowired
    private RecetaRepository recetaRepository;

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    public RecetaMedicamento toEntity(RecetaMedicamentoRequestDto dto) {
        if (dto == null) return null;

        RecetaMedicamento entity = new RecetaMedicamento();

        Receta receta = recetaRepository.findById(dto.recetaId())
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        entity.setReceta(receta);

        Medicamento medicamento = medicamentoRepository.findById(dto.medicamentoId())
                .orElseThrow(() -> new RuntimeException("Medicamento no encontrado"));
        entity.setMedicamento(medicamento);

        entity.setCantidad(dto.cantidad());
        entity.setFrecuencia(dto.frecuencia());
        entity.setDuracionDias(dto.duracionDias());
        entity.setNotas(dto.notas());

        return entity;
    }

    public RecetaMedicamentoResponseDto toDto(RecetaMedicamento entity) {
        if (entity == null) return null;

        return new RecetaMedicamentoResponseDto(
            entity.getId(),
            entity.getReceta().getId(),
            entity.getMedicamento().getId(),
            entity.getMedicamento().getNombre(),
            entity.getMedicamento().getPresentacion(),
            entity.getCantidad(),
            entity.getFrecuencia(),
            entity.getDuracionDias(),
            entity.getNotas()
        );
    }

    public List<RecetaMedicamentoResponseDto> toDtoList(List<RecetaMedicamento> entities) {
        return entities.stream().map(this::toDto).toList();
    }

    public void updateEntity(RecetaMedicamento entity, RecetaMedicamentoRequestDto dto) {
        if (dto == null) return;

        if (dto.cantidad() != null) entity.setCantidad(dto.cantidad());
        if (dto.frecuencia() != null) entity.setFrecuencia(dto.frecuencia());
        if (dto.duracionDias() != null) entity.setDuracionDias(dto.duracionDias());
        if (dto.notas() != null) entity.setNotas(dto.notas());
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}