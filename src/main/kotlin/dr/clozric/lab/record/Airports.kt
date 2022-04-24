package dr.clozric.lab.record

fun main(){
    val departureTime: Time = Time(hours = 10, mins = 20)
    val arrivalTime: Time = Time(hours = 12, mins = 50)
    val flightMoscowToAmsterdam = Flight(flightCode = "JU308", departure = "Moscow", destination = "Amsterdam", departureTime = departureTime, arrivalTime = arrivalTime)
    println(flightMoscowToAmsterdam.makeDescription())
}

data class Flight(val flightCode: String,
                  val departure: String,
                  val destination: String,
                  val departureTime: Time,
                  val arrivalTime: Time) {
    fun makeDescription(): String {
        return "Flight № $flightCode from $departure to $destination takes off at $departureTime and lands approximately at $arrivalTime"
    }
}

data class Time(val hours: Int,
                val mins: Int){
    override fun toString(): String {
        return "$hours:$mins"
    }
}
