object Main {
    // Ejemplos Pruebas
    def main(args: Array[String]): Unit = {

    val usuario1 = Usuario(
        80068,
        "Emanuel",
        "emaguesa@gmail.com",
        "78057489"
    )

    val usuario2 = Usuario(
        67890,
        "Carlos",
        "carlos4@gmail.com",
        "71256158"
    )

    val scooter1 = new Scooter(
        1,
        Disponible,
        1.50,
        "Plaza Murillo"
    )

    val bicicleta1 = new Bicicleta(
        2,
        Disponible,
        1.00,
        "Av. Arce"
    )

    val auto1 = new Auto(
        3,
        Alquilado,
        3.50,
        "Zona Sur"
    )

    val alquiler1 = Alquiler(
        1,
        usuario1,
        scooter1,
        "2026-09-15",
        8.5
    )

    val alquiler2 = Alquiler(
        2,
        usuario2,
        bicicleta1,
        "2026-09-13",
        5.0
    )

    val alquiler3 = Alquiler(
        3,
        usuario1,
        scooter1,
        "2026-09-11",
        10.0
    )

    val sistema = Sistema(
        List(usuario1, usuario2),
        List(scooter1, bicicleta1, auto1),
        List(alquiler1, alquiler2, alquiler3)
    )

    // Diseño Terminal
    println("----- Bienvenido a MoveRENT -----")
    println(
        s"Usuarios: ${sistema.usuarios.length}"
    )
    println(
        s"Vehiculos: ${sistema.vehiculos.length}"
    )


    println()
    println("----- Disponibilidad de Vehiculos -----") //Funcion orden superior
    val vehiculosDisponibles =
        Funciones.filtrarVehiculos(
            sistema.vehiculos,
            vehiculo => vehiculo.estado == Disponible
        )
    println(
        s"Vehiculos disponibles: ${vehiculosDisponibles.length}"
    )


    println()
    println("----- Informacion Vehiculo -----")
    val resultadoVehiculo =
        Resultado(
            bicicleta1,
            "Vehiculo encontrado"
        )
    println(
        s"Resultado: ${resultadoVehiculo.mensaje}"
    )
    println(
        s"Vehiculo: ${resultadoVehiculo.dato}"
    )

    println()
    println("----- Recorrido -----")
    val kilometrosTotales =
        Funciones.kilometrosTotales(
            sistema.alquileres
        )
    println(
        s"Total kilometros recorridos: ${kilometrosTotales}"
    )


    println()
    println("----- Informacion Scooter -----") // Cambio de Estado
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
    val alquileresEma =
        Funciones.alquileresDeUsuario(
            sistema.alquileres,
            1
        )
    println(
        s"Alquileres de Emanuel: ${alquileresEma.length}"
    )


    println()
    println("----- Informacion Alquileres -----") // Flatmap
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
            println("----- RESUMEN MENSUAL -----")
            println(s"Mes: ${resultado.mes}")
            println(s"Vehiculo mas usado: ${resultado.vehiculoMasUsado}")
            println(s"Cantidad de alquileres: ${resultado.cantidadAlquileres}")
            println(s"Ingresos generados: Bs ${resultado.ingresos}")
        case None => println("No hay alquileres para este mes.")
    }


    println()
    println("----- Nuevo Alquiler -----")
    val nuevoAlquiler =
        Funciones.realizarAlquiler(
            usuario1,
            scooter1,
            10
        )
    nuevoAlquiler match {
        case Some((alquiler, vehiculoActualizado)) =>
            println("Alquiler realizado correctamente")
            println(s"Usuario: ${alquiler.usuario.nombre}")
            println(s"Vehiculo: ${alquiler.vehiculo}")
            println(s"Estado anterior: ${alquiler.vehiculo.estado}")
            println(s"Estado nuevo: ${vehiculoActualizado.estado}")
        val nuevoSistema =
            Funciones.actualizarSistema(
                sistema,
                alquiler,
                vehiculoActualizado
            )
        println()
        println("----- Sistema Actualizado -----")
        println(
            s"Vehiculos disponibles antes: ${
                Funciones.vehiculosDisponibles(
                    sistema.vehiculos
                ).length
            }"
        )
        println(
            s"Vehiculos disponibles ahora: ${
                Funciones.vehiculosDisponibles(
                    nuevoSistema.vehiculos
                ).length
            }"
        )
        println(s"Cantidad de alquileres antes: ${sistema.alquileres.length}")
        println(s"Cantidad de alquileres despues: ${nuevoSistema.alquileres.length}")
        case None => println("No se pudo realizar el alquiler")
        }
    }
}