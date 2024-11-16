const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
let result = inp[1]
  .trim()
  .split("")
  .map((data, idx) => [data, idx]);
result.sort((a, b) => {
  if (a[0] < b[0]) return 1;
  else if (b[0] > a[0]) return -1;
  else return b[1] - a[1];
});

for (let cycle = 0; cycle < M; cycle++) {
  result.pop();
}

const print = result
  .sort((a, b) => {
    return a[1] - b[1];
  })
  .map((value) => value[0]);
console.log(print.join(""));
