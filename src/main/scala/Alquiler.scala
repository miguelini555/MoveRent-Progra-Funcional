case class Alquiler(
    id: Int,
    usuario: Usuario,
    vehiculo: Vehiculo,
    fecha: String,
    kilometrosRecorridos: Double
){
    def calcularCosto(): Double = {
        vehiculo.calcularCosto(kilometrosRecorridos)
    }
}