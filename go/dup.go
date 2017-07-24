// dup prints the count and text of lines that appear more than once
// in the input. It reads from stdin or from a list of named files.
package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	// A 'map' is a reference to the data structure created by 'make'
	counts := make(map[string]int)

	// The 'os' package provides functions and other values for dealing with the platform-
	// independent fashion

	// os.Args is a slice of strings; this example begins at user passed command-line arguments,
	// but had we started at '0', we'd see the the name of the command itself
	files := os.Args[1:]

	if len(files) == 0 {
		// Functions and other package-level entities may be declared in
		// any order
		countLines(os.Stdin, counts)
	} else {
		// An example of a loop that iterates over a 'range' of values; in each iteration
		// of the loop, 'range' produces a pair of valued: the index and the value of the
		// element at that index

		// In this example, we don't need the index, but the syntax of a 'range' loop
		// requires that if we deal with the element, we must deal with the index too

		// The 'blank identifier', whose name is '_' (that is, an underscore) may be used
		// whenever syntax requires a variable name but program logic does not

		// For instance, to discard an unwanted loop index when we require only the element
		// value

		// It's encouraged to use 'range' and '_' when indexing implicit (created by the native
		// compiler), not explicit (created by the programmer).
		for _, arg := range files {
			// 'os.Open' returns two values. The first is an open file (*os.File),
			// and the second is of the built-in 'error' type

			// 'os.Open' opens the named file for reading. If successful, methods
			// on the returned file can be used for reading; the associated file
			// descriptor has mode O_RDONLY. If there is an error, it will be of type
			// *PathError

			// If the 'error' type equals the special build-in value 'nil', the file
			// was opened successfully
			f, err := os.Open(arg)

			if err != nil {
				// Fprint formats using the default formats for its operands and writes to 'os.Stderr'

				// Spaces are added between operands when neither is a string; it returns the number of
				// bytes written and any write error encountered.

				// Stdin, Stdout, and Stderr are open Files pointing to the standard input, standard
				// output, and standard error file descriptors
				fmt.Fprintf(os.Stderr, "dup: %v\n", err) // Printf conversions are called 'verbs' (http://bit.ly/21Luz9I)
				continue                                 // Statement that goes to the next iteration of the enclosing 'for' loop
			}

			countLines(f, counts)
			f.Close() // Closes the file and releases any resources
		}

		// [NOTE]: Since functions can be defined in any order, take a look at
		// the countLines below to better understand how/where 'line' is initialized
		for line, n := range counts {
			if n > 1 {
				fmt.Printf("%d\t%s\n", n, line)
			}
		}
	}
}

// When a map is passed to a function, the function receives a copy of the
// reference, so any changes the called function makes to the underlying
// data structure will be visible through the caller's map reference too.
func countLines(f *os.File, counts map[string]int) {
	input := bufio.NewScanner(f)

	// This operates in a "streaming" mode in which input is read and broken into
	// lines as needed, so in principal this program and handle an arbitrary amount
	// of input
	for input.Scan() {
		// This statement (shorthand) is equivalent to the following:
		// 		line := input.Text()
		// 		counts[line] = counts[line] + 1
		counts[input.Text()]++ // This is a copy of the reference to the 'counts' map called by countLines in main()
	}

	// [NOTE]: ignoring potential errors from input.Err()
}
