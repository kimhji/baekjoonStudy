const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const T = parseInt(inp[0].trim());
let idx = 1;
for (let cycle = 0; cycle < T; cycle++) {
  let [N, M] = inp[idx++].trim().split(" ").map(Number);
  let A = inp[idx++].trim().split(" ").map(Number);
  let B = inp[idx++].trim().split(" ").map(Number);
  let result = 0;
  B.sort((a, b) => {
    return a - b;
  });
  A.forEach((predator) => {
    for (let check = 0; check < M; check++) {
      if (B[check] < predator) {
        result++;
      } else break;
    }
  });
  console.log(result);
}
