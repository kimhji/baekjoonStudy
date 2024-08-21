const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let N = parseInt(inp[0].trim());
let slime = inp[1].trim().split(" ").map(Number);

let result = 0;
while (N > 1) {
  slime.sort((a, b) => {
    return a - b;
  });
  let one = slime.shift();
  let two = slime.shift();
  slime.push(one + two);
  result += one * two;
  N--;
}
console.log(result);
