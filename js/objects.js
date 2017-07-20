// Object literals provide a very convenient notation for creating new
// object values. An object literal is a pair of curl braces surrounding
// zero or more name/value pairs, like so:

var empty_object = {};

var stooge = {
  // A property name can be any string including the empty string.
  "": "Empty string",

  // The quotes around a property's name in an object literal are
  // optional if the name would be a legal JavaScript name and not a
  // reserved word.

  "first-name": "Michael", // Commas are used to seperate the paris.

  // The names are treated as literal names, not as variable names, so
  // the names of the object must be known at compile time.

  "last-name": "Surbey"

  // The values of the properties are expressions. As in, 'Surbey' is
  // an expression for the value 'last-name'.
};

// A property's value can be obtained from any expression, including another
// object literal.

// Also, objects can nest:
var flight = {
  airline: "American",
  number: 815,
  departure: {
    IATA: "SYD",
    time: "2016-08-29 08:30",
    city: "Sydney"
  },
  arrival: {
    IATA: "LAX",
    time: "2016-08-30 13:35",
    city: "Los Angeles"
  }
};

// Values can be retrieved from an object by wrapping a string expression in a
// [ ] suffix, or if the string expression is a string literal, and a legal
// JavaScript name and not a reserved word, then the '.' (dot) notation can be
// used instead.

// [NOTE]: The . (dot) notation is preferred because it is more compact and it
// reads better:

stooge["first-name"]  // "Michael"
flight.departure.IATA // "SYD"

// The '||' operator can be used to fill in default values.
var middle = stooge["middle-name"] || "(none)";

// [NOTE]: Attempting to retrieve values from 'undefined' will throw a
// 'TypeError' exception. This can be guarded against with the && operator:

flight.equipment                            // undefined
flight.equipment.model                      // throw "TypeError"
flight.equipment && flight.equipment.model  // undefined

// A value in an object can be updated by assignment. If the property name
// already exists in the object, the property value is replaced.

stooge['first-name'] = 'Jerome';
stooge.nickname = 'Curly';
flight.equipment = {
  model: 'Boeing 777'
};

// If the object does not already have that property name, the object is
// augmented.

// Objects are passed around by reference. They are never copied:
var x = stooge;
x.nickname = 'Tyler';
var nick = stooge.nickname; // nick is 'Tyler' because x and stooge are
                            // references to the same object.

var a = {}, b = {}, c = {}; // a, b, and c each refer to a different empty
                            // object.

a = b = c = {};             // a, b, and c all refer to the same empty object

// JavaScript makes it really easy to define global variables that can hold
// all assets of an application. But, this weakens application resiliency.

// [NOTE]: Global variables are generally static variables, whose extent
// (lifetime) is the entire runtime of the program for compiled languages,
// whereas for interpreted they're generally dynamically allocated when
// declared, since they are not known ahead of time. Either way, a global
// variable is a variable with global scope, meaning that it is visible
// (hence accessible) throughout the program, unless shadowed.

// Meaning, it could be realitively easy to overwrite pre-existing variables
// without known until runtime execution. In order to avoid this unintended
// behavior, a way to minimize the use of global variables is to create
// a single global variable for your application:

var MYAPP = {};

// That variable then becomes the container for your application:

MYAPP.stooge = {
  "first-name": "Joe",
  "last-name": "Howard"
};

MYAPP.flight = {
  airline: "American",
  number: 815,
  departure: {
    IATA: "SYD",
    time: "2016-08-29 08:30",
    city: "Sydney"
  },
  arrival: {
    IATA: "LAX",
    time: "2016-08-30 13:35",
    city: "Los Angeles"
  }
};

// This methodology reduces your global footprint to a single name, and
// significantly reduces the chance of bad interactions with other applications,
// widgets, or libraries. Additionally, this makes the program easier to reads
// because it is obvious that 'MYAAP.stooge' refers to a top-level structure.
