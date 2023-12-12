// src/main/kotlin/com/ejemplo/Main.kt

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import java.time.LocalDate


fun main() {

    //Parte ORM
    val entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory("ejemplo")
    val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    //SE CREAN LOS OBJETOS
    //val person = Person(name =  "John Doe", age = 30)
    var nuevadireccion=Direccion(4,"CALLE LA ALAMEDA","MADRID")
    var empleado=Empleado(apellidos = "Lopez", nombre = "ADRIAN", fechaNacimiento = LocalDate.now())
    empleado.direccion=nuevadireccion
    //val animal=Animal(name = "OSO", age = 12)

    //SE OPERA CON LA BASE Y LOS OBJETOS
    entityManager.transaction.begin()
    entityManager.persist(empleado)
    entityManager.persist(nuevadireccion)
    //entityManager.persist(animal)
    entityManager.transaction.commit()


    //SE OBTIENE LISTA DE PERSONA
    val personas: List<Person> = entityManager.createQuery("FROM Person", Person::class.java).resultList
    println("Número de personas " + personas.size)

    println("Personas en la tabla:")
    for (p in personas) {
        println("ID: ${p.id}, Nombre: ${p.name}, Edad: ${p.age}")
    }

    /*//SE OBTIENE LISTA DE ANIMALES
    val animales:List<Animal> = entityManager.createQuery("FROM Animal", Animal::class.java).resultList
    println("Numero de animales " + animales.size)

    println("Animales en la tabla:")
    for (a in animales) {
        println("ID: ${a.id}, Nombre: ${a.name}, Edad: ${a.age}")
    }

     */


    entityManager.close()
    entityManagerFactory.close()
}