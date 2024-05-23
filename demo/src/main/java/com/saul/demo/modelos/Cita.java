package com.saul.demo.modelos;
import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
// Clase que representa la entidad Cita
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Cita", uniqueConstraints = {
    @UniqueConstraint(name = "uk_telefono", columnNames = {"telefono"})
    })
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_paterno", nullable = false, length = 50)
    private String apellidopaterno;

    @Column(name = "apellido_materno", nullable = false, length = 50)
    private String apellidomaterno;

    @Column(name = "fecha_reservacion", columnDefinition = "DATETIME", nullable = false)
    private LocalDate fechaReservacion;

    @Column(name = "Correo", nullable = false, length = 300)
    private String correo;

    @Column(name = "telefono",columnDefinition = "CHAR(10)", nullable = false, length = 10)
    private String telefono;

    @Column(name = "sintomas", nullable = false, length = 700)
    private String sintomas;

    @ManyToOne(targetEntity = Consultorio.class)
    @JoinColumn(name = "idConsultorio",foreignKey = @ForeignKey(name = "FK_consultorio_cita_id"), nullable = false)
    private Consultorio consultorio;

   
}

