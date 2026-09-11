<<<<<<< HEAD
package gt.edu.umg.dao;

import gt.edu.umg.core.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PacienteRepository extends JpaRepository<Paciente, Long>, JpaSpecificationExecutor<Paciente> {
}
=======
package gt.edu.umg.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import gt.edu.umg.core.entities.Paciente;

@Repository
public interface PacienteRepository extends IGenericRepository<Paciente, Long>, JpaSpecificationExecutor<Paciente>  {

}
>>>>>>> ffcf5a27d8dc35521b8fa58bbb4e95f6aef4e943
