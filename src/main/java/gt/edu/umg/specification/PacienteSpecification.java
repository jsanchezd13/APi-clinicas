package gt.edu.umg.specification;

import gt.edu.umg.core.entities.Paciente;
import gt.edu.umg.core.entities.Dtos.Request.PacienteFilter;
import org.springframework.data.jpa.domain.Specification;

public class PacienteSpecification {

    public static Specification<Paciente> withFilter(PacienteFilter filter) {
        return (root, query, cb) -> {
            var predicates = cb.conjunction();

            if (filter.nombre() != null && !filter.nombre().isBlank()) {
                predicates = cb.and(predicates,
                    cb.like(cb.lower(root.get("nombre")), "%" + filter.nombre().toLowerCase() + "%"));
            }

            if (filter.apellido() != null && !filter.apellido().isBlank()) {
                predicates = cb.and(predicates,
                    cb.like(cb.lower(root.get("apellido")), "%" + filter.apellido().toLowerCase() + "%"));
            }

            if (filter.dpi() != null && !filter.dpi().isBlank()) {
                predicates = cb.and(predicates,
                    cb.like(root.get("dpi"), "%" + filter.dpi() + "%"));
            }

            if (filter.activo() != null) {
                predicates = cb.and(predicates,
                    cb.equal(root.get("activo"), filter.activo()));
            }

            return predicates;
        };
    }
}