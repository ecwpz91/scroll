// A function literal defines a function value. It can have an optional name
// that it can use to call itself recursively, and it can specify a list of
// parameters that will act as variables initialized by the invocation
// arguments.

// Create a variable called 'add' and store a function
// in it that adds two numbers.

var add = function (a, b) {
  // The body of the function includes variable definitions and statements.
  return a + b;
}

// A function literal has four parts:
// (1) The reserved word 'function'.
// (2) The name of the function (optional).
// (3) The set of parameters of the function, wrapped in parentheses.
// (4) A set of statements wrapped in curly braces.
