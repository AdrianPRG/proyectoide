import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne
import java.time.LocalDate

@Entity
data class Empleado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COD_EMPLEADO")
    var codigo:Long?=null,

    @Column(name = "APELLIDOS")
    private val apellidos:String,

    @Column(name = "NOMBRE")
    private val nombre:String,

    @Column(name = "FECHA_NACIMIENTO")
    private val fechaNacimiento:LocalDate,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "ID_DIRECCION")
    var direccion:Direccion?=null
){
    override fun toString(): String {
        return "Empleado(codigo=$codigo, apellidos='$apellidos', nombre='$nombre', fechaNacimiento=$fechaNacimiento, direccion=$direccion)"
    }
}
