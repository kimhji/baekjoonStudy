const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(inp[0].trim());
let numbersOfDrink = inp[1].trim().split(" ").map(Number);
numbersOfDrink.sort((a, b) => {
  return b - a;
});

let result = 0;
numbersOfDrink.forEach((drink) => {
  if (result === 0) {
    result += drink;
  } else {
    result += drink / 2;
  }
});
console.log(result);
