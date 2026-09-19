package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Medicamento;
import gt.edu.umg.core.entities.Dtos.Request.MedicamentoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicamentoResponseDto;
import gt.edu.umg.mapper.MedicamentoMapper;
import gt.edu.umg.service.impl.MedicamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicamentos")
@Tag(name = "Medicamentos", description = "Endpoints para el catálogo de medicamentos")
public class MedicamentoController {

    @Autowired
    private MedicamentoService service;

    @Autowired
    private MedicamentoMapper mapper;

    @PostMapping
    @Operation(summary = "Crear un medicamento")
    public ResponseEntity<MedicamentoResponseDto> crear(@Valid @RequestBody MedicamentoRequestDto request) {
        Medicamento entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todos los medicamentos")
    public ResponseEntity<List<MedicamentoResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener medicamento por ID")
    public ResponseEntity<MedicamentoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar medicamento")
    public ResponseEntity<MedicamentoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MedicamentoRequestDto request) {
        Medicamento entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar medicamento")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar medicamentos por nombre")
    public ResponseEntity<List<MedicamentoResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorNombre(nombre)));
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar medicamentos por categoría")
    public ResponseEntity<List<MedicamentoResponseDto>> buscarPorCategoria(@PathVariable String categoria) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorCategoria(categoria)));
    }

    @GetMapping("/laboratorio/{laboratorio}")
    @Operation(summary = "Buscar medicamentos por laboratorio")
    public ResponseEntity<List<MedicamentoResponseDto>> buscarPorLaboratorio(@PathVariable String laboratorio) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorLaboratorio(laboratorio)));
    }

    @GetMapping("/activos")
    @Operation(summary = "Listar medicamentos activos")
    public ResponseEntity<List<MedicamentoResponseDto>> listarActivos() {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarActivos()));
    }

    @GetMapping("/receta")
    @Operation(summary = "Listar medicamentos que requieren receta")
    public ResponseEntity<List<MedicamentoResponseDto>> listarConReceta() {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarConReceta()));
    }
}