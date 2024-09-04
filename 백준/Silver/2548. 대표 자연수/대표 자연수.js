const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());

let numbers = inp[1].trim().split(" ").map(Number);
let result = [];
let minDiff = 9999999999;
numbers.forEach((number) => {
  let diff = 0;
  numbers.forEach((numberXycle) => {
    diff += Math.abs(numberXycle - number);
  });
  if (minDiff > diff) {
    result = [number];
    minDiff = diff;
  } else if (minDiff === diff) {
    result.push(number);
  }
});

result.sort((a, b) => {
  return a - b;
});

console.log(result[0]);
