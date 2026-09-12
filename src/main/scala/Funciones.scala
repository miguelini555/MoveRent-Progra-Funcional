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
    usuario: Usuario,
    vehiculo: Vehiculo,
    kilometros: Double
  ): Option[(Alquiler, Vehiculo)] = {

    vehiculo.estado match {

      case Disponible =>

        val nuevoAlquiler = Alquiler(
          100,
          usuario,
          vehiculo,
          "2026-09-12",
          kilometros
        )

        val vehiculoActualizado =
          vehiculo.cambiarEstado(Alquilado)

        Some(
          (nuevoAlquiler, vehiculoActualizado)
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
          kilometros
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


  def actualizarSistema(
    sistema: Sistema,
    alquiler: Alquiler,
    vehiculoActualizado: Vehiculo
  ): Sistema = {
    val nuevosVehiculos =
      sistema.vehiculos.map(
        vehiculo =>
          if (vehiculo.id == vehiculoActualizado.id) {
            vehiculoActualizado
          } else {
            vehiculo
          }
      )

    val nuevosAlquileres =
      sistema.alquileres :+ alquiler

    Sistema(
      sistema.usuarios,
      nuevosVehiculos,
      nuevosAlquileres
    )
  }


  def filtrarVehiculos(
    vehiculos: List[Vehiculo],
    criterio: Vehiculo => Boolean
  ): List[Vehiculo] = {
    vehiculos.filter(
      vehiculo => criterio(vehiculo)
    )
  }


  def kilometrosTotales(
    alquileres: List[Alquiler]
  ): Double = {
    alquileres
      .map(alquiler => alquiler.kilometrosRecorridos)
      .reduce(_ + _)
  }

    def nombresUsuariosConAlquileres(
    alquileres: List[Alquiler]
  ): List[String] = {

    alquileres.flatMap(
      alquiler => List(alquiler.usuario.nombre)
    )
  }

}