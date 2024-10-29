const fs = require("fs");
const inp = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

let idx = 0;
const [N, M] = inp[idx++].trim().split(" ").map(Number);
const board = [];
for (let boardC = 0; boardC < N; boardC++) {
  board.push(inp[idx++].trim().split(" ").map(Number));
}
const K = parseInt(inp[idx++].trim());
for (let cycle = 0; cycle < K; cycle++) {
  const [i, j, x, y] = inp[idx++].trim().split(" ").map(Number);
  let value = 0;
  for (let front = i - 1; front < x; front++) {
    for (let back = j - 1; back < y; back++) {
      value += board[front][back];
    }
  }
  console.log(value);
}
