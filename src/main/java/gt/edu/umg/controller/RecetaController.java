package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Receta;
import gt.edu.umg.core.entities.Dtos.Request.RecetaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.RecetaResponseDto;
import gt.edu.umg.mapper.RecetaMapper;
import gt.edu.umg.service.impl.RecetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recetas")
@Tag(name = "Recetas", description = "Endpoints para la gestión de recetas médicas")
public class RecetaController {

    @Autowired
    private RecetaService service;

    @Autowired
    private RecetaMapper mapper;

    @PostMapping
    @Operation(summary = "Crear una receta médica")
    public ResponseEntity<RecetaResponseDto> crear(@Valid @RequestBody RecetaRequestDto request) {
        Receta entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas las recetas")
    public ResponseEntity<List<RecetaResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener receta por ID")
    public ResponseEntity<RecetaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar receta")
    public ResponseEntity<RecetaResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody RecetaRequestDto request) {
        Receta entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar receta")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Buscar recetas por paciente")
    public ResponseEntity<List<RecetaResponseDto>> buscarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorPaciente(pacienteId)));
    }

    @GetMapping("/medico/{medicoId}")
    @Operation(summary = "Buscar recetas por médico")
    public ResponseEntity<List<RecetaResponseDto>> buscarPorMedico(@PathVariable Long medicoId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorMedico(medicoId)));
    }

    @GetMapping("/cita/{citaId}")
    @Operation(summary = "Buscar recetas por cita")
    public ResponseEntity<List<RecetaResponseDto>> buscarPorCita(@PathVariable Long citaId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorCita(citaId)));
    }

    @GetMapping("/rango-fechas")
    @Operation(summary = "Buscar recetas por rango de fechas")
    public ResponseEntity<List<RecetaResponseDto>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorRangoFechas(inicio, fin)));
    }

    @GetMapping("/paciente/{pacienteId}/ultimas")
    @Operation(summary = "Últimas recetas de un paciente")
    public ResponseEntity<List<RecetaResponseDto>> buscarUltimasPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarUltimasPorPaciente(pacienteId)));
    }

    @GetMapping("/vencidas")
    @Operation(summary = "Recetas vencidas")
    public ResponseEntity<List<RecetaResponseDto>> buscarRecetasVencidas() {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarRecetasVencidas()));
    }
}