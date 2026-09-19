package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Cita;
import gt.edu.umg.core.entities.Dtos.Request.CitaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.CitaResponseDto;
import gt.edu.umg.mapper.CitaMapper;
import gt.edu.umg.service.impl.CitaService;
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
@RequestMapping("/api/v1/citas")
@Tag(name = "Citas", description = "Endpoints para la gestión de citas médicas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @Autowired
    private CitaMapper citaMapper;

    @PostMapping
    @Operation(summary = "Crear una nueva cita")
    public ResponseEntity<CitaResponseDto> crear(@Valid @RequestBody CitaRequestDto request) {
        Cita entidad = citaMapper.toEntity(request);
        Cita guardado = citaService.guardar(entidad);
        return new ResponseEntity<>(citaMapper.toDto(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener lista de todas las citas")
    public ResponseEntity<List<CitaResponseDto>> obtenerTodos() {
        List<CitaResponseDto> respuesta = citaService.obtenerTodos()
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una cita por su ID")
    public ResponseEntity<CitaResponseDto> obtenerPorId(@PathVariable Long id) {
        Cita cita = citaService.obtenerPorId(id);
        return ResponseEntity.ok(citaMapper.toDto(cita));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una cita existente")
    public ResponseEntity<CitaResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody CitaRequestDto request) {
        Cita entidad = citaMapper.toEntity(request);
        Cita actualizado = citaService.actualizar(id, entidad);
        return ResponseEntity.ok(citaMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una cita")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        citaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/paciente/{pacienteId}")
    @Operation(summary = "Buscar citas por paciente")
    public ResponseEntity<List<CitaResponseDto>> buscarPorPaciente(@PathVariable Long pacienteId) {
        List<CitaResponseDto> respuesta = citaService.buscarPorPaciente(pacienteId)
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/medico/{medicoId}")
    @Operation(summary = "Buscar citas por médico")
    public ResponseEntity<List<CitaResponseDto>> buscarPorMedico(@PathVariable Long medicoId) {
        List<CitaResponseDto> respuesta = citaService.buscarPorMedico(medicoId)
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/estado/{estado}")
    @Operation(summary = "Buscar citas por estado")
    public ResponseEntity<List<CitaResponseDto>> buscarPorEstado(@PathVariable String estado) {
        List<CitaResponseDto> respuesta = citaService.buscarPorEstado(estado.toUpperCase())
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/rango-fechas")
    @Operation(summary = "Buscar citas en un rango de fechas")
    public ResponseEntity<List<CitaResponseDto>> buscarPorRangoFechas(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime inicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime fin) {
        List<CitaResponseDto> respuesta = citaService.buscarPorRangoFechas(inicio, fin)
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/paciente/{pacienteId}/futuras")
    @Operation(summary = "Buscar citas futuras de un paciente")
    public ResponseEntity<List<CitaResponseDto>> buscarCitasFuturasPorPaciente(@PathVariable Long pacienteId) {
        List<CitaResponseDto> respuesta = citaService.buscarCitasFuturasPorPaciente(pacienteId)
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/medico/{medicoId}/futuras")
    @Operation(summary = "Buscar citas futuras de un médico")
    public ResponseEntity<List<CitaResponseDto>> buscarCitasFuturasPorMedico(@PathVariable Long medicoId) {
        List<CitaResponseDto> respuesta = citaService.buscarCitasFuturasPorMedico(medicoId)
                .stream()
                .map(citaMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @PatchMapping("/{id}/confirmar")
    @Operation(summary = "Confirmar una cita")
    public ResponseEntity<CitaResponseDto> confirmarCita(@PathVariable Long id) {
        Cita cita = citaService.confirmarCita(id);
        return ResponseEntity.ok(citaMapper.toDto(cita));
    }

    @PatchMapping("/{id}/completar")
    @Operation(summary = "Completar una cita")
    public ResponseEntity<CitaResponseDto> completarCita(@PathVariable Long id) {
        Cita cita = citaService.completarCita(id);
        return ResponseEntity.ok(citaMapper.toDto(cita));
    }

    @PatchMapping("/{id}/cancelar")
    @Operation(summary = "Cancelar una cita")
    public ResponseEntity<CitaResponseDto> cancelarCita(@PathVariable Long id) {
        Cita cita = citaService.cancelarCita(id);
        return ResponseEntity.ok(citaMapper.toDto(cita));
    }
}