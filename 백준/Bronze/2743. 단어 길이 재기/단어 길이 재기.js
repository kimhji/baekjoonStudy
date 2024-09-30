const fs = require("fs");
const data = fs.readFileSync("/dev/stdin").toString().trim();
console.log(data.length);
