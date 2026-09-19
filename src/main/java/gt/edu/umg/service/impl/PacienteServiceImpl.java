// PacienteServiceImpl.java
package gt.edu.umg.service.impl;

import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Dtos.Request.PacienteFilter;
import gt.edu.umg.dao.PacienteRepository;
import gt.edu.umg.specification.PacienteSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PacienteServiceImpl implements PacienteService {

    private static final int MAX_PAGE_SIZE = 200;
    private static final int DEFAULT_PAGE_SIZE = 50;

    private final PacienteRepository pacienteRepository;

    public PacienteServiceImpl(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    @Override
    public Page<Paciente> buscarConFiltros(PacienteFilter filter) {
        int page = (filter.page() != null && filter.page() >= 0) ? filter.page() : 0;
        int size = (filter.size() != null) ? filter.size() : DEFAULT_PAGE_SIZE;

        // Punto 9: validar el tamaño máximo permitido, sin importar lo que pida el cliente
        if (size > MAX_PAGE_SIZE) {
            size = MAX_PAGE_SIZE;
        }
        if (size <= 0) {
            size = DEFAULT_PAGE_SIZE;
        }

        // Punto 10: ordenar del más reciente al más antiguo (id DESC)
        Sort sort = Sort.by(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);

        return pacienteRepository.findAll(PacienteSpecification.withFilter(filter), pageable);
    }

    @Override
    public Paciente obtenerPorId(Long id) {
        return pacienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado: " + id));
    }

    @Override
    public void eliminar(Long id) {
        pacienteRepository.deleteById(id);
    }
}