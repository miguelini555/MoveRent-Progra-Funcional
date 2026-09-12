error id: A31D5F1B7689D9C2ACEAE4ECA998D1D6
file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Main.scala
### java.lang.StringIndexOutOfBoundsException: Index 7571 out of bounds for length 7559

occurred in the presentation compiler.



action parameters:
offset: 7572
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
        )
        println(
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
}@@
```


presentation compiler configuration:
Scala version: 3.8.4-bin-nonbootstrapped
Classpath:
<WORKSPACE>\.scala-build\MoveRent-Progra-Funcional_66e974c94b\classes\main [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala3-library_3\3.8.4\scala3-library_3-3.8.4.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\org\scala-lang\scala-library\3.8.4\scala-library-3.8.4.jar [exists ], <HOME>\AppData\Local\Coursier\cache\v1\https\repo1.maven.org\maven2\com\sourcegraph\semanticdb-javac\0.12.3\semanticdb-javac-0.12.3.jar [exists ], <WORKSPACE>\.scala-build\MoveRent-Progra-Funcional_66e974c94b\classes\main\META-INF\best-effort [missing ]
Options:
-Xsemanticdb -sourceroot <WORKSPACE> -Ywith-best-effort-tasty




#### Error stacktrace:

```
java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:55)
	java.base/jdk.internal.util.Preconditions$1.apply(Preconditions.java:52)
	java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:213)
	java.base/jdk.internal.util.Preconditions$4.apply(Preconditions.java:210)
	java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:98)
	java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
	java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
	java.base/java.lang.String.checkIndex(String.java:4822)
	java.base/java.lang.StringLatin1.charAt(StringLatin1.java:46)
	java.base/java.lang.String.charAt(String.java:1544)
	scala.collection.StringOps$.apply$extension(StringOps.scala:191)
	dotty.tools.dotc.interactive.Completion$.naiveCompletionPrefix(Completion.scala:141)
	dotty.tools.dotc.interactive.Completion$.completionPrefix(Completion.scala:170)
	dotty.tools.dotc.interactive.Completion$.scopeContext(Completion.scala:60)
	dotty.tools.pc.IndexedContext$LazyWrapper.<init>(IndexedContext.scala:91)
	dotty.tools.pc.IndexedContext$.apply(IndexedContext.scala:80)
	dotty.tools.pc.AutoImportsProvider.autoImports(AutoImportsProvider.scala:49)
	dotty.tools.pc.ScalaPresentationCompiler.autoImports$$anonfun$1(ScalaPresentationCompiler.scala:338)
	scala.meta.internal.pc.CompilerAccess.withSharedCompiler(CompilerAccess.scala:149)
	scala.meta.internal.pc.CompilerAccess.withNonInterruptableCompiler$$anonfun$1(CompilerAccess.scala:133)
	scala.meta.internal.pc.CompilerAccess.onCompilerJobQueue$$anonfun$1(CompilerAccess.scala:210)
	scala.meta.internal.pc.CompilerJobQueue$Job.run(CompilerJobQueue.scala:153)
	java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	java.base/java.lang.Thread.run(Thread.java:1583)
```
#### Short summary: 

java.lang.StringIndexOutOfBoundsException: Index 7571 out of bounds for length 7559