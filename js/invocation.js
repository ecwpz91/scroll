// Invoking a function suspends the execution of the current function,
// passing control and parameters to the new function.

// [NOTE]: In addition to the declared parameters, every function recieves
// two additional parameters: 'this' and 'arguments'.

// The invocation operator is a pair of parentheses that follow any expression
// that produces a function value.

// [NOTE]: This is no runtime error when the number of arguments and the number
// of paramters do not match. Also, there is no type checking on the arguments
// values: any type of value can be passed to any parameter.

// There are four patterns of invaction in JavaScript:
// (1) Method Invocation Pattern
// (2) Function Invocation Pattern
// (3) Constructor Invocation Pattern
// (4) Apply Invocation Pattern

// [NOTE]: The patterns differ in how the bonus parameter 'this' is initialized.

// The Method Invocation Pattern

var myObject = {
  value: 0,
  // When a function is stored as a property of an object, we call it a method.
  // Methods that get their object context from 'this' are called 'public methods'.
  increment: function (inc) {
    // When a method is invoked, 'this' is bound to that object.
    // A method can use 'this' to access the object so it can retrieve values
    // from the object or modify the object.
    this.value += typeof inc === 'number' ? inc : 1;
    // [NOTE]: The binding of 'this' to the object happens at invocation time.
    // This very late binding makes functions that use 'this' highly reusable.
  }
};

myObject.increment( );
document.writeln( myObject.value); // 1

myObject.increment( 2);
document.writeln( myObject.value); // 3

// Function Invocation Pattern

// When a function is not the property of an object, then it is invoked as a function:
var sum = add(3, 4); // sum is 7

// When a function is invoked with this pattern, 'this' is bound to the global object.

// [NOTE]: This was a mistake in the design of the language. A consequence of this error
// is that a method cannot employ an inner function to help it do its work because the
// inner function does not share the method's access to the object, as its 'this' is
// bound to the wrong value.

// The workaround is, if the method defines a variable and assigns it the value of 'this'
// the inner function function will have access to 'this' through that variable. By
// convention, the name of that variable is 'that':

// Augment myObject with a double method.
myObject.double = function ( ) {
  var that = this; // Workaround.

  var helper = function ( ) {
    that.value = add(that.value, that.value);
  };

  helper( ); // Invoke helper as a function.
};

// Invoke double as a method.
myObject.double( );
document.writeln( myObject.value); // 6
