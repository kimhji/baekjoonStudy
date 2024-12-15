const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let result = 0;
const standard = inp[1].trim().split(" ").map(Number);
const check = inp[2].trim().split(" ").map(Number);
standard.forEach((value, idx) => {
  if (value <= check[idx]) {
    result++;
  }
});
console.log(result);
