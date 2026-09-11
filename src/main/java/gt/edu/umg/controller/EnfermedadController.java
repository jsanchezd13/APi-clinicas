<<<<<<< HEAD
package gt.edu.umg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.core.entities.Enfermedad;
import gt.edu.umg.core.entities.Dtos.Request.EnfermedadRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.EnfermedadResponseDto;
import gt.edu.umg.mapper.EnfermedadMapper;  
import gt.edu.umg.service.impl.EnfermedadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/enfermedades")
@Tag(name = "Enfermedades", description = "Endpoints para la gestión de enfermedades")
public class EnfermedadController {

    private final EnfermedadService enfermedadService;
    private final EnfermedadMapper enfermedadMapper;  

    public EnfermedadController(EnfermedadService enfermedadService, EnfermedadMapper enfermedadMapper) {
        this.enfermedadService = enfermedadService;
        this.enfermedadMapper = enfermedadMapper;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva enfermedad")
    public ResponseEntity<EnfermedadResponseDto> crear(@RequestBody EnfermedadRequestDto request) {
        Enfermedad entidad = enfermedadMapper.toEntity(request);
        Enfermedad guardado = enfermedadService.guardar(entidad);
        return new ResponseEntity<>(enfermedadMapper.toDto(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener lista de todas las enfermedades")
    public ResponseEntity<List<EnfermedadResponseDto>> obtenerTodos() {
        List<EnfermedadResponseDto> respuesta = enfermedadService.obtenerTodos()
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una enfermedad por su ID")
    public ResponseEntity<EnfermedadResponseDto> obtenerPorId(@PathVariable Long id) {
        Enfermedad enfermedad = enfermedadService.obtenerPorId(id);
        return ResponseEntity.ok(enfermedadMapper.toDto(enfermedad));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una enfermedad existente")
    public ResponseEntity<EnfermedadResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody EnfermedadRequestDto request) {
        Enfermedad entidad = enfermedadMapper.toEntity(request);
        Enfermedad actualizado = enfermedadService.actualizar(id, entidad);
        return ResponseEntity.ok(enfermedadMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una enfermedad por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        enfermedadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar enfermedades por nombre")
    public ResponseEntity<List<EnfermedadResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarPorNombre(nombre)
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar enfermedades por categoría")
    public ResponseEntity<List<EnfermedadResponseDto>> buscarPorCategoria(@PathVariable String categoria) {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarPorCategoria(categoria)
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/activos")
    @Operation(summary = "Obtener todas las enfermedades activas")
    public ResponseEntity<List<EnfermedadResponseDto>> obtenerActivos() {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarActivos()
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }
=======
package gt.edu.umg.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gt.edu.umg.core.entities.Enfermedad;
import gt.edu.umg.core.entities.Dtos.Request.EnfermedadRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.EnfermedadResponseDto;
import gt.edu.umg.mapper.EnfermedadMapper;  
import gt.edu.umg.service.impl.EnfermedadService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1/enfermedades")
@Tag(name = "Enfermedades", description = "Endpoints para la gestión de enfermedades")
public class EnfermedadController {

    private final EnfermedadService enfermedadService;
    private final EnfermedadMapper enfermedadMapper;  

    public EnfermedadController(EnfermedadService enfermedadService, EnfermedadMapper enfermedadMapper) {
        this.enfermedadService = enfermedadService;
        this.enfermedadMapper = enfermedadMapper;
    }

    @PostMapping
    @Operation(summary = "Crear una nueva enfermedad")
    public ResponseEntity<EnfermedadResponseDto> crear(@RequestBody EnfermedadRequestDto request) {
        Enfermedad entidad = enfermedadMapper.toEntity(request);
        Enfermedad guardado = enfermedadService.guardar(entidad);
        return new ResponseEntity<>(enfermedadMapper.toDto(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener lista de todas las enfermedades")
    public ResponseEntity<List<EnfermedadResponseDto>> obtenerTodos() {
        List<EnfermedadResponseDto> respuesta = enfermedadService.obtenerTodos()
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener una enfermedad por su ID")
    public ResponseEntity<EnfermedadResponseDto> obtenerPorId(@PathVariable Long id) {
        Enfermedad enfermedad = enfermedadService.obtenerPorId(id);
        return ResponseEntity.ok(enfermedadMapper.toDto(enfermedad));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar una enfermedad existente")
    public ResponseEntity<EnfermedadResponseDto> actualizar(
            @PathVariable Long id,
            @RequestBody EnfermedadRequestDto request) {
        Enfermedad entidad = enfermedadMapper.toEntity(request);
        Enfermedad actualizado = enfermedadService.actualizar(id, entidad);
        return ResponseEntity.ok(enfermedadMapper.toDto(actualizado));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar una enfermedad por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        enfermedadService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar")
    @Operation(summary = "Buscar enfermedades por nombre")
    public ResponseEntity<List<EnfermedadResponseDto>> buscarPorNombre(@RequestParam String nombre) {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarPorNombre(nombre)
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/categoria/{categoria}")
    @Operation(summary = "Buscar enfermedades por categoría")
    public ResponseEntity<List<EnfermedadResponseDto>> buscarPorCategoria(@PathVariable String categoria) {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarPorCategoria(categoria)
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }

    @GetMapping("/activos")
    @Operation(summary = "Obtener todas las enfermedades activas")
    public ResponseEntity<List<EnfermedadResponseDto>> obtenerActivos() {
        List<EnfermedadResponseDto> respuesta = enfermedadService.buscarActivos()
                .stream()
                .map(enfermedadMapper::toDto)
                .toList();
        return ResponseEntity.ok(respuesta);
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}