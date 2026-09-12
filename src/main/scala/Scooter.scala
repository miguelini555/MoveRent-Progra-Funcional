class Scooter(
    id: Int,
    estado: EstadoVehiculo,
    costoPorKm: Double,
    ubicacion: String,
)extends Vehiculo(id, estado, costoPorKm, ubicacion){
    def calcularCosto(kilometros: Double): Double = {
        kilometros*costoPorKm
    }
    def cambiarEstado(nuevoEstado: EstadoVehiculo): Vehiculo = {
        new Scooter(
            id,
            nuevoEstado,
            costoPorKm,
            ubicacion
        )
    }
}