error id: file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Main.scala:scala/Predef.println(+1).
file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Main.scala
empty definition using pc, found symbol in pc: 
found definition using semanticdb; symbol scala/Predef.println(+1).
empty definition using fallback
non-local guesses:

offset: 4542
uri: file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Main.scala
text:
```scala
object Main {
    def main(args: Array[String]): Unit = {

    val usuario1 = Usuario(
        1,
        "Emanuel",
        "emaguesa@gmail.com",
        "78057489"
    )

    val usuario2 = Usuario(
        2,
        "Carlos",
        "carlos4@gmail.com",
        "71256158"
    )

    val scooter1 = new Scooter(
        1,
        Disponible,
        1.50,
        "Plaza Central",
        40,
        25
    )

    val bicicleta1 = new Bicicleta(
        2,
        Disponible,
        1.00,
        "Av. Arce",
        "Montaña",
        "M"
    )

    val auto1 = new Auto(
        3,
        Alquilado,
        3.50,
        "Zona Sur",
        4
    )

    val alquiler1 = Alquiler(
        1,
        usuario1,
        scooter1,
        "2026-09-12",
        8.5
    )

    val alquiler2 = Alquiler(
        2,
        usuario2,
        bicicleta1,
        "2026-09-12",
        5.0
    )

    val alquiler3 = Alquiler(
        3,
        usuario1,
        scooter1,
        "2026-09-15",
        10.0
    )

    val sistema = Sistema(
        List(usuario1, usuario2),
        List(scooter1, bicicleta1, auto1),
        List(alquiler1, alquiler2, alquiler3)
    )

    println("===== MOVARENT =====")
    println(
        s"Usuarios: ${sistema.usuarios.length}"
    )

    println(
        s"Vehiculos: ${sistema.vehiculos.length}"
    )
    
    println(
        s"Vehiculos disponibles: ${
            Funciones.vehiculosDisponibles(
                sistema.vehiculos
            ).length
        }"
    )


    println()
    println("===== FUNCION DE ORDEN SUPERIOR =====")
    val vehiculosDisponibles =
        Funciones.filtrarVehiculos(
            sistema.vehiculos,
            vehiculo => vehiculo.estado == Disponible
        )
    println(
        s"Vehiculos disponibles encontrados: ${
            vehiculosDisponibles.length
        }"
    )


    println()
    println("===== COMPONENTE GENERICO =====")
    val resultadoVehiculo =
        Resultado(
            bicicleta1,
            "Vehiculo encontrado correctamente"
        )
    println(
        s"Mensaje: ${resultadoVehiculo.mensaje}"
    )
    println(
        s"Vehiculo: ${
            resultadoVehiculo.dato
            .getClass
            .getSimpleName
        }"
    )


    println()
    println("===== REDUCE =====")
    val kilometrosTotales =
        Funciones.kilometrosTotales(
            sistema.alquileres
        )
    println(
        s"Kilometros totales recorridos: ${
            kilometrosTotales
        }"
    )


    println()
    println("===== CAMBIO DE ESTADO =====")
    val vehiculosActualizados =
        Funciones.cambiarEstadoVehiculo(
            sistema.vehiculos,
            1,
            Alquilado
        )
    println(
        s"Estado anterior del Scooter: ${scooter1.estado}"
    )
    println(
        s"Estado nuevo del Scooter: ${
            vehiculosActualizados
            .find(vehiculo => vehiculo.id == 1)
            .map(vehiculo => vehiculo.estado)
        }"
    )
    println(
        s"Ingresos totales: Bs ${
            Funciones.calcularIngresos(
                sistema.alquileres
            )
        }"
    )
    val alquileresManu =
        Funciones.alquileresDeUsuario(
            sistema.alquileres,
            1
        )
    println(
        s"Alquileres de Manu: ${alquileresManu.length}"
    )


    println()
    println("===== FLATMAP =====")
    val nombresUsuarios =
        Funciones.nombresUsuariosConAlquileres(
            sistema.alquileres
        )
    println(
        s"Usuarios de los alquileres: ${
            nombresUsuarios.mkString(", ")
        }"
    )
    val vehiculoEncontrado =
        Funciones.buscarVehiculo(
            sistema.vehiculos,
            2
        )
    println(
        s"Vehiculo con ID 2: $vehiculoEncontrado"
    )
    val resumen =
        Funciones.generarResumenMensual(
            sistema.alquileres,
            sistema.vehiculos,
            "2026-09"
        )
    resumen match {
        case Some(resultado) =>
            println()
            println("===== RESUMEN MENSUAL =====")
            println(s"Mes: ${resultado.mes}")
            println(s"Vehiculo mas usado: ${
                resultado.vehiculoMasUsado
                .getClass
                .getSimpleName
            }"
        
        print@@ln(
            s"Cantidad de alquileres: ${
                resultado.cantidadAlquileres
            }"
        )
        println(
            s"Kilometros recorridos: ${
                resultado.kilometrosRecorridos
            }"
        )
        println(
            s"Ingresos generados: Bs ${
                resultado.ingresos
            }"
        )
        case None =>
            println()
            println("No hay alquileres para este mes.")
    }


    println()
    println("===== NUEVO ALQUILER =====")
    val nuevoAlquiler =
        Funciones.realizarAlquiler(
            usuario1,
            scooter1,
            10
        )
        nuevoAlquiler match {
            case Some((alquiler, vehiculoActualizado)) =>
                println(
                    "Alquiler realizado correctamente"
                )
                println(
                    s"Usuario: ${alquiler.usuario.nombre}"
                )
                println(
                    s"Vehiculo: ${
                        alquiler.vehiculo
                        .getClass
                        .getSimpleName
                    }"
                )
                println(
                    s"Kilometros: ${alquiler.kilometrosRecorridos}"
                )
                println(
                    s"Costo: Bs ${alquiler.calcularCosto()}"
                )
                println(
                    s"Estado anterior: ${alquiler.vehiculo.estado}"
                )
                println(
                    s"Estado nuevo: ${vehiculoActualizado.estado}"
                )
                val nuevoSistema =
                    Funciones.actualizarSistema(
                        sistema,
                        alquiler,
                        vehiculoActualizado
                    )


                println()
                println("===== SISTEMA ACTUALIZADO =====")
                println(
                    s"Vehiculos disponibles antes: ${
                        Funciones.vehiculosDisponibles(
                            sistema.vehiculos
                        ).length
                    }"
                )
                println(
                    s"Vehiculos disponibles despues: ${
                        Funciones.vehiculosDisponibles(
                            nuevoSistema.vehiculos
                        ).length
                    }"
                )
                println(
                    s"Cantidad de alquileres antes: ${
                        sistema.alquileres.length
                    }"
                )
                println(
                    s"Cantidad de alquileres despues: ${
                        nuevoSistema.alquileres.length
                    }"
                )
                case None =>
                    println(
                        "No se pudo realizar el alquiler"
                    )
        }

    }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 