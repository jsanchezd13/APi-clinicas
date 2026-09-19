package gt.edu.umg.core.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "enfermedades")
@Data // Genera getters, setters, toString, equals, hashCode
@NoArgsConstructor // Constructor vacío
@AllArgsConstructor // Constructor con todos los argumentos
public class Enfermedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la enfermedad es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
    @Column(nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(columnDefinition = "TEXT")
    private String sintomas;

    @Column(columnDefinition = "TEXT")
    private String tratamiento;

    @Size(max = 50)
    private String categoria; // Ej: "Infecciosa", "Crónica", "Genética", etc.

    @Column(name = "codigo_cie")
    @Size(max = 20)
    private String codigoCie; // Clasificación Internacional de Enfermedades

    @Column(name = "nivel_gravedad")
    private Integer nivelGravedad; // 1-5, donde 5 es más grave

    @Column(name = "es_cronica")
    private Boolean esCronica = false;

    @Column(name = "es_contagiosa")
    private Boolean esContagiosa = false;

    @Column(name = "tiempo_recuperacion_dias")
    private Integer tiempoRecuperacionDias;

    @Column(name = "fecha_registro", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime fechaRegistro;

    @Column(name = "fecha_actualizacion")
    @UpdateTimestamp
    private LocalDateTime fechaActualizacion;

    @Column(name = "activo")
    private Boolean activo = true;

    // Relación con Paciente (muchos a muchos) - Ejemplo
    /*
    @ManyToMany(mappedBy = "enfermedades")
    private List<Paciente> pacientes = new ArrayList<>();
    */

    // Relación con Historial Médico (uno a muchos) - Ejemplo
    /*
    @OneToMany(mappedBy = "enfermedad")
    private List<HistorialMedico> historiales = new ArrayList<>();
    */
}