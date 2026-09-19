package gt.edu.umg.controller;

import gt.edu.umg.core.entities.HistorialClinico;
import gt.edu.umg.core.entities.Dtos.Request.HistorialClinicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.HistorialClinicoResponseDto;
import gt.edu.umg.mapper.HistorialClinicoMapper;
import gt.edu.umg.service.impl.HistorialClinicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/historial")
@Tag(name = "Historial Clínico", description = "Endpoints para el historial clínico")
public class HistorialClinicoController {

    @Autowired
    private HistorialClinicoService service;

    @Autowired
    private HistorialClinicoMapper mapper;

    @PostMapping
    @Operation(summary = "Crear registro en historial clínico")
    public ResponseEntity<HistorialClinicoResponseDto> crear(@Valid @RequestBody HistorialClinicoRequestDto request) {
        HistorialClinico entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todo el historial clínico")
    public ResponseEntity<List<HistorialClinicoResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener historial por ID")
    public ResponseEntity<HistorialClinicoResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar historial")
    public ResponseEntity<HistorialClinicoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody HistorialClinicoRequestDto request) {
        HistorialClinico entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar historial")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Buscar historial por paciente")
    public ResponseEntity<List<HistorialClinicoResponseDto>> buscarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorPaciente(pacienteId)));
    }

    @GetMapping("/medico/{medicoId}")
    @Operation(summary = "Buscar historial por médico")
    public ResponseEntity<List<HistorialClinicoResponseDto>> buscarPorMedico(@PathVariable Long medicoId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorMedico(medicoId)));
    }
}