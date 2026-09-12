class Bicicleta(
  id: Int,
  estado: EstadoVehiculo,
  costoPorKm: Double,
  ubicacion: String,
  val esElectrica: Boolean,
  val tipoBicicleta: String,
  val talla: String
) extends Vehiculo(id, estado, costoPorKm, ubicacion) {

  def calcularCosto(kilometros: Double): Double = {
    kilometros * costoPorKm
  }

  def cambiarEstado(nuevoEstado: EstadoVehiculo): Vehiculo = {
    new Bicicleta(
      id,
      nuevoEstado,
      costoPorKm,
      ubicacion,
      esElectrica,
      tipoBicicleta,
      talla
    )
  }
}