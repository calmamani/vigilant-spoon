object MultiplesOfThreeAndFive {
  def main(args: Array[String]): Unit = {
    var a: Int = 1;
    var total: Int = 0;
    while(a < 1000) {
      if(a%3 == 0 || a%5 == 0) {
        total = total + a
      }
      a = a + 1
    }
    println(total)
  }
}
