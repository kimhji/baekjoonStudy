const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

let result = 0;
for (let cycle = N; cycle > 0; cycle--) {
  result += N / cycle;
}
console.log(result);
