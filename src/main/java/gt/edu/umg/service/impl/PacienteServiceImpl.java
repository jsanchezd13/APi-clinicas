<<<<<<< HEAD
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
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
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
=======
package gt.edu.umg.service.impl;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.dao.PacienteRepository;

@Service
public class PacienteServiceImpl implements PacienteService {

	private final PacienteRepository pacienteRepository;

	public PacienteServiceImpl(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;
	}
	
	@Override
	@Transactional
	public Paciente guardar(Paciente paciente) {
		// TODO Auto-generated method stubS
		return pacienteRepository.guardar(paciente);
		//return null;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> obtenerTodos() {
		// TODO Auto-generated method stub
		//return null;
		return pacienteRepository.obtenerTodos();
	}

	@Override
	@Transactional(readOnly = true)
	public Paciente obtenerPorId(Long id) {
		// TODO Auto-generated method stub
		//return null;
		return pacienteRepository.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con el ID: " + id));
	}

	@Override
	@Transactional
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		//if (!pacienteRepository.existsById(id)) {
        //    throw new RuntimeException("No se puede eliminar. El paciente no existe con ID: " + id);
        //}
        pacienteRepository.eliminarPorId(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Paciente> buscarConFiltro(Specification<Paciente> spec) {
		// TODO Auto-generated method stub
		//return null;
		return pacienteRepository.findAll(spec);
	}

}
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
