const fs = require("fs");
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
let result = 0;
const arr = new Array(N + 1).fill(false);

arr.forEach((value, idx) => {
  if (!idx) return;

  if (N % idx === 0) result += idx;
});
console.log(result * 5 - 24);
