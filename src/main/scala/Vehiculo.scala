abstract class Vehiculo(
    val id: Int,
    val estado: EstadoVehiculo,
    val costoPorKm: Double,
    val ubicacion: String
){
    def calcularCosto(kilometros: Double): Double
    def cambiarEstado(nuevoEstado: EstadoVehiculo): Vehiculo
}