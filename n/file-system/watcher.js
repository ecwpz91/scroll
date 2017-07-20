const fs = require('fs');

fs.watch('target.txt', function() {
// - 'console' echos a message to standard output
console.log("File 'target.txt' just changed!");
});

console.log("Now watching target.txt for changes...");
