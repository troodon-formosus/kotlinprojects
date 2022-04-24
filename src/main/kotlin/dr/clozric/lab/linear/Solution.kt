package dr.clozric.lab.linear

fun retrieveData(prompt: String): Int {
    println(prompt)
    return readln().toInt()
}

fun calculateGrossSalary(salaryRate: Int, monthlyTaxRate: Int, semiAnnualTaxRate: Int): Double {
    val monthlyTaxPercentage: Double = monthlyTaxRate / 100.0
    val semiAnnualTaxPercentage: Double = semiAnnualTaxRate / 100.0
    val monthlyGrossSalary = salaryRate - salaryRate * monthlyTaxPercentage
    val salary = monthlyGrossSalary * 6
    return salary - salary * semiAnnualTaxPercentage
}

fun solve() {
    val salaryRate: Int = retrieveData("Please input salary rate")
    val monthlyTaxRate: Int = retrieveData("Please input monthly tax rate")
    val semiAnnualTaxRate: Int = retrieveData("Please input semi-annual tax rate")
    val grossSalary = calculateGrossSalary(salaryRate, monthlyTaxRate, semiAnnualTaxRate)
    println("Your gross salary is $grossSalary")
}
