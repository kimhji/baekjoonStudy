const fs = require("fs");
// const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

const [N, M, Q] = inp[0].trim().split(" ").map(Number);

let rowAdd = new Array(N).fill(0);
let colAdd = new Array(M).fill(0);

for (let cycle = 1; cycle <= Q; cycle++) {
  let [order, idx, value] = inp[cycle].trim().split(" ").map(Number);
  idx--;
  if (order === 1) {
    rowAdd[idx] += value;
  } else if (order === 2) {
    colAdd[idx] += value;
  }
}

let result = [];

for (let r = 0; r < N; r++) {
  let row = [];
  for (let c = 0; c < M; c++) {
    row.push(rowAdd[r] + colAdd[c]);
  }
  result.push(row.join(" "));
}

console.log(result.join("\n"));
