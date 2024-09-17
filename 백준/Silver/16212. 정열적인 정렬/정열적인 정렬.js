const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const numbers = inp[1].trim().split(" ").map(Number);
numbers.sort((a, b) => {
  return a - b;
});
console.log(numbers.join(" "));
