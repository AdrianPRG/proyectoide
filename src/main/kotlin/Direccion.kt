import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "DIRECCION")
data class Direccion (

    @Id
    @Column(name = "ID_DIRECCION")
    private val iddireccion:Int,
    @Column(name = "DIRECCION")
    private val nombredireccion:String,
    @Column(name = "LOCALIDAD")
    private val localidad:String,
)