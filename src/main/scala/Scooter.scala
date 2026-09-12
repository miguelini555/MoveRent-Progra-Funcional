class Scooter(
  id: Int,
  estado: EstadoVehiculo,
  costoPorKm: Double,
  ubicacion: String,
  val autonomiaKm: Int,
  val esElectrico: Boolean,
  val velocidadMax: Int
) extends Vehiculo(id, estado, costoPorKm, ubicacion) {

  def calcularCosto(kilometros: Double): Double = {
    kilometros * costoPorKm
  }

  def cambiarEstado(nuevoEstado: EstadoVehiculo): Vehiculo = {
    new Scooter(
      id,
      nuevoEstado,
      costoPorKm,
      ubicacion,
      autonomiaKm,
      esElectrico,
      velocidadMax
    )
  }
}