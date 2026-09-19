package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.MedicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicoResponseDto;
import gt.edu.umg.mapper.MedicoMapper;
import gt.edu.umg.service.impl.MedicoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/medicos")
@Tag(name = "Médicos", description = "Endpoints para la gestión de médicos")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private MedicoMapper medicoMapper;

    @PostMapping
    @Operation(summary = "Crear un nuevo médico")
    public ResponseEntity<MedicoResponseDto> crear(@Valid @RequestBody MedicoRequestDto request) {
        Medico entidad = medicoMapper.toEntity(request);
        Medico guardado = medicoService.guardar(entidad);
        return new ResponseEntity<>(medicoMapper.toDto(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener lista de todos los médicos")
    public ResponseEntity<List<MedicoResponseDto>> obtenerTodos() {
        List<MedicoResponseDto> respuesta = medicoService.obtenerTodos()
                .stream()
                .map(medicoMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un médico por su ID")
    public ResponseEntity<MedicoResponseDto> obtenerPorId(@PathVariable Long id) {
        Medico medico = medicoService.obtenerPorId(id);
        return ResponseEntity.ok(medicoMapper.toDto(medico));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un médico existente")
    public ResponseEntity<MedicoResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody MedicoRequestDto request) {
        Medico entidad = medicoMapper.toEntity(request);
        Medico actualizado = medicoService.actualizar(id, entidad);
        return ResponseEntity.ok(medicoMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar (desactivar) un médico por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        medicoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar médicos por nombre")
    public ResponseEntity<List<MedicoResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        List<MedicoResponseDto> respuesta = medicoService.buscarPorNombre(nombre)
                .stream()
                .map(medicoMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/especialidad/{especialidad}")
    @Operation(summary = "Buscar médicos por especialidad")
    public ResponseEntity<List<MedicoResponseDto>> buscarPorEspecialidad(@PathVariable String especialidad) {
        List<MedicoResponseDto> respuesta = medicoService.buscarPorEspecialidad(especialidad)
                .stream()
                .map(medicoMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/activos")
    @Operation(summary = "Obtener todos los médicos activos")
    public ResponseEntity<List<MedicoResponseDto>> obtenerActivos() {
        List<MedicoResponseDto> respuesta = medicoService.buscarActivos()
                .stream()
                .map(medicoMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/matricula/{matricula}")
    @Operation(summary = "Obtener un médico por su matrícula")
    public ResponseEntity<MedicoResponseDto> obtenerPorMatricula(@PathVariable String matricula) {
        Medico medico = medicoService.obtenerPorMatricula(matricula);
        return ResponseEntity.ok(medicoMapper.toDto(medico));
    }
}