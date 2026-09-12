class Auto(
  id: Int,
  estado: EstadoVehiculo,
  costoPorKm: Double,
  ubicacion: String,
  val puertas: Int,
  val tipoCombustible: String,
  val capacidadPasajeros: Int
) extends Vehiculo(id, estado, costoPorKm, ubicacion) {

  def calcularCosto(kilometros: Double): Double = {
    kilometros * costoPorKm
  }

  def cambiarEstado(nuevoEstado: EstadoVehiculo): Vehiculo = {
    new Auto(
      id,
      nuevoEstado,
      costoPorKm,
      ubicacion,
      puertas,
      tipoCombustible,
      capacidadPasajeros
    )
  }
}