// The simplest expressions are a literal value (such as a string or number),
// a variable, a built-in value (true, false, null, undefined, NaN, or
// Infinity), an invocation expression preceded by 'new', a refinement
// expression preceeded by 'delete', an expression wrapped in parentheses,
// an expression preceeded by a prefix operator, or an expression followed
// by:

// - An infix operator or another expression
// - The '?' ternary operator followed by another expression, then by ':', and
//   then by yet another expression
// - An invocation
// - A refinement

// Operator precedence is as follows (highest to lowest):
// (1) Refinement and invocation            :   . [] ()
// (2) Unary operators                      :   delete new typeof + - !

// [NOTE]: The values produced by 'typeof' are 'number', 'string', 'boolean',
// 'undefined', 'function', and 'object'. If the operand is an array or 'null',
// then the result is 'object'.

// (3) Multiplication, devision, remainder  :   * / %
// (4) Addition/concatenation, subtraction  :   + -
// (5) Inequality                           :   >= <= > <
// (6) Logical 'and'                        :   &&
// (7) Logical 'or'                         :   ||
// (8) Ternary                              :   ?:

// [NOTE]: Parentheses can be used to alter the normal precedence.

// Infix, Postfix and Prefix notations are three different but equivalent ways
// of writing expressions. It is easiest to demonstrate the differences by
// looking at examples of operators that take two operands.

// Infix notation: X + Y
//    Operators are written in-between their operands. The '+' operator adds or
//    concatenates, the '/' operator can produce a noninterger result even if
//    both operands are integers, the '&&' operator produces the value of its
//    first operand if the first operand is 'falsy' (otherwise, it produces the
//    value of the second operand, etc.), and the '||' operator produces the
//    value of its first operand if the first operand is  'truthy' (otherwise,
//    it produces the value of the second operand).

// Postfix notation (also known as "Reverse Polish notation"): X Y +
//    Operators are written after their operands.

// Prefix notation (also known as "Polish notation"): + X Y
//    Operators are written before their operands. This can occur using
//    'typeof', '+' (to number), '-' (negate), or '!' (logical not).


// Invocation causes the execution of a function value, and a refinement is
// used to specify a property or element of an obejct or array.
