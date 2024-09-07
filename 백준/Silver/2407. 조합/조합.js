const fs = require("fs");
// const [n, m] = fs
//   .readFileSync("input.txt")
//   .toString()
//   .trim()
//   .split(" ")
//   .map(Number);
const [n, m] = fs
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
let result = BigInt(1);
for (let up = 0; up < m; up++) {
  result *= BigInt(n - up);
}
for (let down = 1; down <= m; down++) {
  result /= BigInt(down);
}
console.log(result.toString());
