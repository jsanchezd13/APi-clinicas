package gt.edu.umg.controller;

import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Dtos.Request.PacienteFilter;
import gt.edu.umg.core.entities.Dtos.Request.PacienteRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.PacienteResponseDto;
import gt.edu.umg.core.entities.Dtos.Response.PageResponseDto;
import gt.edu.umg.mapper.PacienteMapper;
import gt.edu.umg.service.impl.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/pacientes")
@Tag(name = "Pacientes", description = "Endpoints para la gestión de pacientes")
public class PacienteController {

    private final PacienteService pacienteService;
    private final PacienteMapper pacienteMapper;

    public PacienteController(PacienteService pacienteService, PacienteMapper pacienteMapper) {
        this.pacienteService = pacienteService;
        this.pacienteMapper = pacienteMapper;
    }

    @PostMapping
    public ResponseEntity<PacienteResponseDto> crear(@RequestBody PacienteRequestDto request) {
        Paciente entidad = pacienteMapper.toEntity(request);
        Paciente guardado = pacienteService.guardar(entidad);
        return new ResponseEntity<>(pacienteMapper.toDto(guardado), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Obtener pacientes con filtros y paginación")
    public ResponseEntity<PageResponseDto<PacienteResponseDto>> obtenerTodos(
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String apellido,
            @RequestParam(required = false) String dpi,
            @RequestParam(required = false) Boolean activo,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "50") Integer size
    ) {
        PacienteFilter filter = new PacienteFilter(nombre, apellido, dpi, activo, page, size);
        Page<Paciente> resultado = pacienteService.buscarConFiltros(filter);

        var data = resultado.getContent().stream()
                .map(pacienteMapper::toDto)
                .toList();

        var metadata = new PageResponseDto.PageMetadata(
                resultado.getTotalElements(),
                resultado.getNumber(),
                resultado.getSize(),
                resultado.getTotalPages(),
                resultado.hasPrevious(),
                resultado.hasNext()
        );

        return ResponseEntity.ok(new PageResponseDto<>(data, metadata));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un paciente por su ID")
    public ResponseEntity<PacienteResponseDto> obtenerPorId(@PathVariable Long id) {
        Paciente paciente = pacienteService.obtenerPorId(id);
        return ResponseEntity.ok(pacienteMapper.toDto(paciente));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un paciente por su ID")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        pacienteService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}