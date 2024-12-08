const fs =require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const numbers = inp[1].trim().split(" ").map(Number);
const findV = parseInt(inp[2].trim());
console.log(numbers.filter(number=>{return number === findV}).length);