<<<<<<< HEAD
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.MedicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicoResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoMapper {

    // Convertir RequestDto -> Entity
    public Medico toEntity(MedicoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Medico medico = new Medico();
        medico.setNombre(requestDto.nombre());
        medico.setApellido(requestDto.apellido());
        medico.setEspecialidad(requestDto.especialidad());
        medico.setMatricula(requestDto.matricula());
        medico.setTelefono(requestDto.telefono());
        medico.setEmail(requestDto.email());  // ✅ Puede ser null o cualquier string
        
        // ✅ Convertir String a LocalTime
        if (requestDto.horarioInicio() != null && !requestDto.horarioInicio().isEmpty()) {
            medico.setHorarioInicio(LocalTime.parse(requestDto.horarioInicio()));
        }
        if (requestDto.horarioFin() != null && !requestDto.horarioFin().isEmpty()) {
            medico.setHorarioFin(LocalTime.parse(requestDto.horarioFin()));
        }
        
        medico.setAniosExperiencia(requestDto.aniosExperiencia());
        medico.setActivo(true);

        return medico;
    }

    // Convertir Entity -> ResponseDto
    public MedicoResponseDto toDto(Medico entity) {
        if (entity == null) {
            return null;
        }

        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        String aniosExperienciaTexto = entity.getAniosExperiencia() != null ? 
            entity.getAniosExperiencia() + " años" : "No especificado";

        return new MedicoResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            nombreCompleto,
            entity.getEspecialidad(),
            entity.getMatricula(),
            entity.getTelefono(),
            entity.getEmail(),
            entity.getHorarioInicio(),
            entity.getHorarioFin(),
            entity.getAniosExperiencia(),
            aniosExperienciaTexto,
            entity.getActivo(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion()
        );
    }

    // Convertir List<Entity> -> List<ResponseDto>
    public List<MedicoResponseDto> toDtoList(List<Medico> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Actualizar Entity existente desde RequestDto
    public void updateEntity(Medico entity, MedicoRequestDto requestDto) {
        if (requestDto == null) {
            return;
        }

        if (requestDto.nombre() != null) {
            entity.setNombre(requestDto.nombre());
        }
        if (requestDto.apellido() != null) {
            entity.setApellido(requestDto.apellido());
        }
        if (requestDto.especialidad() != null) {
            entity.setEspecialidad(requestDto.especialidad());
        }
        if (requestDto.matricula() != null) {
            entity.setMatricula(requestDto.matricula());
        }
        if (requestDto.telefono() != null) {
            entity.setTelefono(requestDto.telefono());
        }
        if (requestDto.email() != null) {
            entity.setEmail(requestDto.email());
        }
        if (requestDto.horarioInicio() != null && !requestDto.horarioInicio().isEmpty()) {
            entity.setHorarioInicio(LocalTime.parse(requestDto.horarioInicio()));
        }
        if (requestDto.horarioFin() != null && !requestDto.horarioFin().isEmpty()) {
            entity.setHorarioFin(LocalTime.parse(requestDto.horarioFin()));
        }
        if (requestDto.aniosExperiencia() != null) {
            entity.setAniosExperiencia(requestDto.aniosExperiencia());
        }
    }
=======
package gt.edu.umg.mapper;

import gt.edu.umg.core.entities.Medico;
import gt.edu.umg.core.entities.Dtos.Request.MedicoRequestDto;
import gt.edu.umg.core.entities.Dtos.Response.MedicoResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MedicoMapper {

    // Convertir RequestDto -> Entity
    public Medico toEntity(MedicoRequestDto requestDto) {
        if (requestDto == null) {
            return null;
        }

        Medico medico = new Medico();
        medico.setNombre(requestDto.nombre());
        medico.setApellido(requestDto.apellido());
        medico.setEspecialidad(requestDto.especialidad());
        medico.setMatricula(requestDto.matricula());
        medico.setTelefono(requestDto.telefono());
        medico.setEmail(requestDto.email());  // ✅ Puede ser null o cualquier string
        
        // ✅ Convertir String a LocalTime
        if (requestDto.horarioInicio() != null && !requestDto.horarioInicio().isEmpty()) {
            medico.setHorarioInicio(LocalTime.parse(requestDto.horarioInicio()));
        }
        if (requestDto.horarioFin() != null && !requestDto.horarioFin().isEmpty()) {
            medico.setHorarioFin(LocalTime.parse(requestDto.horarioFin()));
        }
        
        medico.setAniosExperiencia(requestDto.aniosExperiencia());
        medico.setActivo(true);

        return medico;
    }

    // Convertir Entity -> ResponseDto
    public MedicoResponseDto toDto(Medico entity) {
        if (entity == null) {
            return null;
        }

        String nombreCompleto = entity.getNombre() + " " + entity.getApellido();
        String aniosExperienciaTexto = entity.getAniosExperiencia() != null ? 
            entity.getAniosExperiencia() + " años" : "No especificado";

        return new MedicoResponseDto(
            entity.getId(),
            entity.getNombre(),
            entity.getApellido(),
            nombreCompleto,
            entity.getEspecialidad(),
            entity.getMatricula(),
            entity.getTelefono(),
            entity.getEmail(),
            entity.getHorarioInicio(),
            entity.getHorarioFin(),
            entity.getAniosExperiencia(),
            aniosExperienciaTexto,
            entity.getActivo(),
            entity.getFechaRegistro(),
            entity.getFechaActualizacion()
        );
    }

    // Convertir List<Entity> -> List<ResponseDto>
    public List<MedicoResponseDto> toDtoList(List<Medico> entities) {
        if (entities == null) {
            return List.of();
        }
        return entities.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // Actualizar Entity existente desde RequestDto
    public void updateEntity(Medico entity, MedicoRequestDto requestDto) {
        if (requestDto == null) {
            return;
        }

        if (requestDto.nombre() != null) {
            entity.setNombre(requestDto.nombre());
        }
        if (requestDto.apellido() != null) {
            entity.setApellido(requestDto.apellido());
        }
        if (requestDto.especialidad() != null) {
            entity.setEspecialidad(requestDto.especialidad());
        }
        if (requestDto.matricula() != null) {
            entity.setMatricula(requestDto.matricula());
        }
        if (requestDto.telefono() != null) {
            entity.setTelefono(requestDto.telefono());
        }
        if (requestDto.email() != null) {
            entity.setEmail(requestDto.email());
        }
        if (requestDto.horarioInicio() != null && !requestDto.horarioInicio().isEmpty()) {
            entity.setHorarioInicio(LocalTime.parse(requestDto.horarioInicio()));
        }
        if (requestDto.horarioFin() != null && !requestDto.horarioFin().isEmpty()) {
            entity.setHorarioFin(LocalTime.parse(requestDto.horarioFin()));
        }
        if (requestDto.aniosExperiencia() != null) {
            entity.setAniosExperiencia(requestDto.aniosExperiencia());
        }
    }
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
}