error id: file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Funciones.scala:
file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Funciones.scala
empty definition using pc, found symbol in pc: 
empty definition using semanticdb
empty definition using fallback
non-local guesses:
	 -usuario.
	 -usuario#
	 -usuario().
	 -scala/Predef.usuario.
	 -scala/Predef.usuario#
	 -scala/Predef.usuario().
offset: 833
uri: file:///C:/Users/Usuario/Desktop/MoveRent-Progra-Funcional/src/main/scala/Funciones.scala
text:
```scala
object Funciones {

  def vehiculosDisponibles(
    vehiculos: List[Vehiculo]
  ): List[Vehiculo] = {

    vehiculos.filter(
      vehiculo => vehiculo.estado match {
        case Disponible => true
        case Alquilado => false
      }
    )
  }


  def buscarVehiculo(
    vehiculos: List[Vehiculo],
    id: Int
  ): Option[Vehiculo] = {

    vehiculos.find(
      vehiculo => vehiculo.id == id
    )
  }


  def calcularIngresos(
    alquileres: List[Alquiler]
  ): Double = {

    alquileres
      .map(alquiler => alquiler.calcularCosto())
      .sum
  }


  def alquileresDeUsuario(
    alquileres: List[Alquiler],
    idUsuario: Int
  ): List[Alquiler] = {

    alquileres.filter(
      alquiler => alquiler.usuario.id == idUsuario
    )
  }


  def realizarAlquiler(
    usua@@rio: Usuario,
    vehiculo: Vehiculo,
    kilometros: Double
  ): Option[Alquiler] = {

    vehiculo.estado match {

      case Disponible =>
        Some(
          Alquiler(
            100,
            usuario,
            vehiculo,
            "2026-09-12",
            kilometros
          )
        )

      case Alquilado =>
        None
    }
  }


  def alquileresDelMes(
    alquileres: List[Alquiler],
    mes: String
  ): List[Alquiler] = {

    alquileres.filter(
      alquiler => alquiler.fecha.startsWith(mes)
    )
  }


  def generarResumenMensual(
    alquileres: List[Alquiler],
    vehiculos: List[Vehiculo],
    mes: String
  ): Option[ResumenMensual] = {

    val alquileresMes = alquileresDelMes(
      alquileres,
      mes
    )

    val vehiculoMasUsado = vehiculos.foldLeft(
      Option.empty[(Vehiculo, Int)]
    ) {

      case (mejor, vehiculo) =>

        val cantidad = alquileresMes.count(
          alquiler => alquiler.vehiculo.id == vehiculo.id
        )

        mejor match {

          case None =>
            if (cantidad > 0) {
              Some((vehiculo, cantidad))
            } else {
              None
            }

          case Some((vehiculoActual, cantidadActual)) =>
            if (cantidad > cantidadActual) {
              Some((vehiculo, cantidad))
            } else {
              Some((vehiculoActual, cantidadActual))
            }
        }
    }


    vehiculoMasUsado.map {

      case (vehiculo, cantidad) =>

        val alquileresVehiculo = alquileresMes.filter(
          alquiler => alquiler.vehiculo.id == vehiculo.id
        )

        val kilometros = alquileresVehiculo
          .map(alquiler => alquiler.kilometrosRecorridos)
          .sum

        val ingresos = alquileresVehiculo
          .map(alquiler => alquiler.calcularCosto())
          .sum

        ResumenMensual(
          mes,
          vehiculo,
          cantidad,
          kilometros,
          ingresos
        )
    }
  }

    def cambiarEstadoVehiculo(
    vehiculos: List[Vehiculo],
    idVehiculo: Int,
    nuevoEstado: EstadoVehiculo
  ): List[Vehiculo] = {

    vehiculos.map(
      vehiculo =>
        if (vehiculo.id == idVehiculo) {
          vehiculo.cambiarEstado(nuevoEstado)
        } else {
          vehiculo
        }
    )
  }
}
```


#### Short summary: 

empty definition using pc, found symbol in pc: 