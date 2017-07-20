// Prototype-based programming is a style of object-oriented programming in
// which behaviour reuse (known as inheritance) is performed via a process of
// reusing existing objects via delegation that serve as prototypes.

// In JavaScript every object is linked to a prototype obejct from which it can
// inherit properties. All objects created from object literals are linked
// to 'Object.prototype', and object that comes standard with JavaScript.

// Remembering that in a prototypal system, objects inherit from objects.
// JavaScript, lacks an operator that performs that operation, instead it has
// a 'new' operator.

// In JavaScript, new only works with functions (which are a special type
// of object).

var person = new Object();

// The 'new' operator creates an instance of a user-defined object type or
// of one of the built-in object types that has a constructor function, and
// inherits from 'Object.prototype'.

// The disadvantage of leveraging new is that an Object cannot be used as a
// constructor. But, Functions in JavaScript are objects. So, in order to
// maintain Prototypal Inheritance in JavaScript you can do the following:

function object(o) {
  function F() {};
  F.prototype = o;
  return new F();
}

// The object function untangles JavaScript's constructor pattern, achieving
// true prototypal inheritance.

// It takes an old object as a parameter and returns an empty new object that
// inherits from the old one. If we attempt to obtain a member from the new
// object, and it lacks that key, then the old object will supply the member.
// Objects inherit from objects.

// So instead of creating classes, you make prototype objects, and then use
// the object function to make new instances.

// If we have a maker function that calls another maker function instead of
// calling the object function, then we have a parasitic inheritance pattern.

// When you make a new object, you can select the object that should be its
// prototype. The mechanism that JavaScript provides to do this is messy and
// complex, but it can be simplified by adding a method to an Object's function
// that creates a new object that uses an old object as its prototype.

// For example:
if (typeof Object.create !== 'function') {
  Object.create = function (o) {
    var F = function () {};
    F.prototype = o;
    return new F();
  };
}

var another_stooge = Object.create(stooge);

// The prototype link has no effect on updating. When we make changes to an
// object, the object's prototype is not touched.

// The prototype link is used only in retrieval. If we try to retrieve a
// property value from an object, and if the object lacks the property name,
// then JavaScript attempts to retrieve the property value from the
// prototype object. And if that object is lacking the property, then it goes
// to its prototype, and so on until the process finally bottoms out with
// 'Object.prototype'.

// If the value exists nowhere in the prototype chain, then the result is the
// undefined value. This is called 'delegation'.

// The prototype relationship is a dynamic relationship. If we add a new
// property to a prototype, that property will immediately be visible in all
// of the objects that are based on that prototype.
