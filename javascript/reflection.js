// Generally, when you are reflecting, you are only interested in data.
// Therefore, you should be aware that some values could be functions, your
// program should look for and reject function values.

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

// The 'typeof' operator is very useful for determining the type of a
// property.

typeof flight.number   // 'number'

// Update object via assignment.
flight.status = 'overdue';

typeof flight.status      // 'string'
typeof flight.arrival     // 'object'
typeof flight.manifest    // 'unfedined'

// Recalling the lesson on prototypes, there should be special attention given
// to prototype property chains. Meaning, there could be undesireable
// properties that result from prototype linkage.

typeof flight.toString    // 'function'
typeof flight.constructor // 'function'

// Ratther than write logic to check for function values, the 'hasOwnProperty'
// method is another approach to retrieving properties for objects.

flight.hasOwnProperty('number')       // true
flight.hasOwnProperty('constructor')  // false

// [NOTE]: What makes this unique is that the 'hasOwnProperty' method does not
// look at the prototype chain.
