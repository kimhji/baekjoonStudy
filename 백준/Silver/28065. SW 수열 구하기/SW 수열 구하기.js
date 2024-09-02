const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
let startP = 1;
let endP = N;
let flagS = false;

let result = [];

while (startP !== endP) {
  if (flagS) {
    result.push(startP++);
    flagS = false;
  } else {
    result.push(endP--);
    flagS = true;
  }
}
result.push(endP);

console.log(result.join(" "));
