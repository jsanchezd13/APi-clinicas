<<<<<<< HEAD
package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Clinica;
import gt.edu.umg.core.entities.Dtos.Request.ClinicaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.ClinicaResponseDto;
import gt.edu.umg.mapper.ClinicaMapper;
import gt.edu.umg.service.impl.ClinicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clinicas")
@Tag(name = "Clínicas", description = "Endpoints para la gestión de clínicas")
public class ClinicaController {

    @Autowired
    private ClinicaService service;

    @Autowired
    private ClinicaMapper mapper;

    @PostMapping
    @Operation(summary = "Crear una clínica")
    public ResponseEntity<ClinicaResponseDto> crear(@Valid @RequestBody ClinicaRequestDto request) {
        Clinica entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas las clínicas")
    public ResponseEntity<List<ClinicaResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener clínica por ID")
    public ResponseEntity<ClinicaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar clínica")
    public ResponseEntity<ClinicaResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClinicaRequestDto request) {
        Clinica entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar clínica")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar clínicas por nombre")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorNombre(nombre)));
    }

    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Buscar clínicas por tipo")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorTipo(tipo)));
    }

    @GetMapping("/nivel/{nivel}")
    @Operation(summary = "Buscar clínicas por nivel")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorNivel(@PathVariable String nivel) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorNivel(nivel)));
    }

    @GetMapping("/activos")
    @Operation(summary = "Listar clínicas activas")
    public ResponseEntity<List<ClinicaResponseDto>> listarActivos() {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarActivos()));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Buscar clínica por email")
    public ResponseEntity<ClinicaResponseDto> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorEmail(email)));
    }
=======
package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Clinica;
import gt.edu.umg.core.entities.Dtos.Request.ClinicaRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.ClinicaResponseDto;
import gt.edu.umg.mapper.ClinicaMapper;
import gt.edu.umg.service.impl.ClinicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clinicas")
@Tag(name = "Clínicas", description = "Endpoints para la gestión de clínicas")
public class ClinicaController {

    @Autowired
    private ClinicaService service;

    @Autowired
    private ClinicaMapper mapper;

    @PostMapping
    @Operation(summary = "Crear una clínica")
    public ResponseEntity<ClinicaResponseDto> crear(@Valid @RequestBody ClinicaRequestDto request) {
        Clinica entity = mapper.toEntity(request);
        return new ResponseEntity<>(mapper.toDto(service.guardar(entity)), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Listar todas las clínicas")
    public ResponseEntity<List<ClinicaResponseDto>> listar() {
        return ResponseEntity.ok(mapper.toDtoList(service.obtenerTodos()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener clínica por ID")
    public ResponseEntity<ClinicaResponseDto> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorId(id)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar clínica")
    public ResponseEntity<ClinicaResponseDto> actualizar(
            @PathVariable Long id,
            @Valid @RequestBody ClinicaRequestDto request) {
        Clinica entity = mapper.toEntity(request);
        return ResponseEntity.ok(mapper.toDto(service.actualizar(id, entity)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar clínica")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar clínicas por nombre")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorNombre(nombre)));
    }

    @GetMapping("/tipo/{tipo}")
    @Operation(summary = "Buscar clínicas por tipo")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorTipo(@PathVariable String tipo) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorTipo(tipo)));
    }

    @GetMapping("/nivel/{nivel}")
    @Operation(summary = "Buscar clínicas por nivel")
    public ResponseEntity<List<ClinicaResponseDto>> buscarPorNivel(@PathVariable String nivel) {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarPorNivel(nivel)));
    }

    @GetMapping("/activos")
    @Operation(summary = "Listar clínicas activas")
    public ResponseEntity<List<ClinicaResponseDto>> listarActivos() {
        return ResponseEntity.ok(mapper.toDtoList(service.buscarActivos()));
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Buscar clínica por email")
    public ResponseEntity<ClinicaResponseDto> buscarPorEmail(@PathVariable String email) {
        return ResponseEntity.ok(mapper.toDto(service.obtenerPorEmail(email)));
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}