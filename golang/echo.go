package main

import (
	"fmt"
	"os"
	"strings"
	"time"
)

func main() {
	// Default
	fmt.Println(strings.Join(os.Args[1:], " ") + "\n")

	// Modify the program to also print the name of the command invoked
	fmt.Println("Exercise 1.1")
	fmt.Println(os.Args[0] + " " + strings.Join(os.Args[1:], " ") + "\n")

	// Modify the program to print the index and the value of each of
	// its arguments (one per line)
	fmt.Println("Exercise 1.2")
	for i := 1; i < len(os.Args); i++ {
		fmt.Printf("i=%d;arg=%s\n", i, os.Args[i])
	}

	// Experiment to measure the difference in running time between loops
	// and string concatenation
	fmt.Println("\nExercise 1.3 (for,+=)")
	s, sep := "", ""
	start := time.Now()
	for i := 1; i < len(os.Args); i++ {
		s += sep + os.Args[i]
		sep = " "
	}

	// Duration (nanosecond) & result
	fmt.Printf(":concat: %dns elapsed\n", time.Since(start).Nanoseconds())
	fmt.Println(":result: " + s + "\n")

	fmt.Println("Exercise 1.3 (while,+=)")
	s, sep = "", ""
	start = time.Now()
	for _, arg := range os.Args[1:] {
		s += sep + arg
		sep = " "
	}

	// Duration (nanosecond) & result
	fmt.Printf(":concat: %dns elapsed\n", time.Since(start).Nanoseconds())
	fmt.Println(":result: " + s + "\n")

	fmt.Println("Exercise 1.3 (func,strings.Join)")
	start = time.Now()
	s = strings.Join(os.Args[1:], " ")

	// Duration (nanosecond) & result
	fmt.Printf(":concat: %dns elapsed\n", time.Since(start).Nanoseconds())
	fmt.Println(":result: " + s)
}
