package gt.edu.umg.controller;

import gt.edu.umg.core.entities.PacienteEnfermedad;
import gt.edu.umg.core.entities.Dtos.Request.PacienteEnfermedadRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.PacienteEnfermedadResponseDto;
import gt.edu.umg.mapper.PacienteEnfermedadMapper;
import gt.edu.umg.service.impl.PacienteEnfermedadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paciente-enfermedad")
@Tag(name = "Paciente-Enfermedad", description = "Endpoints para la relación pacientes-enfermedades")
public class PacienteEnfermedadController {

    @Autowired
    private PacienteEnfermedadService service;

    @Autowired
    private PacienteEnfermedadMapper mapper;

    @PostMapping
    @Operation(summary = "Asignar enfermedad a paciente")
    public ResponseEntity<PacienteEnfermedadResponseDto> crear(@Valid @RequestBody PacienteEnfermedadRequestDto request) {
        PacienteEnfermedad entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas las relaciones")
    public ResponseEntity<List<PacienteEnfermedadResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener relación por ID")
    public ResponseEntity<PacienteEnfermedadResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar relación")
    public ResponseEntity<PacienteEnfermedadResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody PacienteEnfermedadRequestDto request) {
        PacienteEnfermedad entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar relación")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Buscar enfermedades de un paciente")
    public ResponseEntity<List<PacienteEnfermedadResponseDto>> buscarPorPaciente(@PathVariable Long pacienteId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorPaciente(pacienteId)));
    }

    @GetMapping("/enfermedad/{enfermedadId}")
    @Operation(summary = "Buscar pacientes con una enfermedad")
    public ResponseEntity<List<PacienteEnfermedadResponseDto>> buscarPorEnfermedad(@PathVariable Long enfermedadId) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorEnfermedad(enfermedadId)));
    }
}