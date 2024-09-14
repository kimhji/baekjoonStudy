const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
let result = 0;
for (let i = 1; i <= N; i++) {
  if (i * i <= N) result++;
}
console.log(result);
