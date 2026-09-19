package gt.edu.umg.controller;

import gt.edu.umg.core.entities.RecetaMedicamento;
import gt.edu.umg.core.entities.Dtos.Request.RecetaMedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaMedicamentoResponseDto;
import gt.edu.umg.mapper.RecetaMedicamentoMapper;
import gt.edu.umg.service.impl.RecetaMedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/receta-medicamento")
@Tag(name = "Receta-Medicamento", description = "Endpoints para la relación recetas-medicamentos")
public class RecetaMedicamentoController {

    @Autowired
    private RecetaMedicamentoService service;

    @Autowired
    private RecetaMedicamentoMapper mapper;

    @PostMapping
    @Operation(summary = "Agregar medicamento a receta")
    public ResponseEntity<RecetaMedicamentoResponseDto> crear(@Valid @RequestBody RecetaMedicamentoRequestDto request) {
        RecetaMedicamento entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas las relaciones")
    public ResponseEntity<List<RecetaMedicamentoResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener relación por ID")
    public ResponseEntity<RecetaMedicamentoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar relación")
    public ResponseEntity<RecetaMedicamentoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody RecetaMedicamentoRequestDto request) {
        RecetaMedicamento entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar relación")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/receta/{recetaId}")
    @Operation(summary = "Buscar medicamentos de una receta")
    public ResponseEntity<List<RecetaMedicamentoResponseDto>> buscarPorReceta(@PathVariable Long recetaId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorReceta(recetaId)));
    }

    @GetMapping("/medicamento/{medicamentoId}")
    @Operation(summary = "Buscar recetas que contienen un medicamento")
    public ResponseEntity<List<RecetaMedicamentoResponseDto>> buscarPorMedicamento(@PathVariable Long medicamentoId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorMedicamento(medicamentoId)));
    }

}