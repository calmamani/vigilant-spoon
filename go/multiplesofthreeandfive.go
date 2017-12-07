package main

import "fmt"

func main() {
	var z int
	z = 0
	for i := 1; i < 1000; i++ {
		if (i%3 == 0) || (i%5 == 0) {
			z = z + i
		}
	}
	fmt.Println(z)
}
