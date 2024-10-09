const fs = require("fs");
const [N, M] = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map((x) => BigInt(x));

let curVal = BigInt(1);
if (M <= N) curVal = 0;
else {
  for (let cycle = BigInt(1); cycle <= N; cycle++) {
    curVal *= cycle;
    curVal %= M;
  }
}
console.log(curVal.toString());
