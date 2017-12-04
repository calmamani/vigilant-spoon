object EvenFibonacci {
    def main(args: Array[String]): Unit = {
    	var sum: Int = 0
    	var x: Int = 1
    	var y: Int = 1
    	var z: Int = 0
    	while(z < 4000000) {
    		z = y + x
    		x = y
    		y = z
    		if(z%2 == 0) {
    			sum = sum + z
    		}
    	}
    	println(sum)
    }	
}