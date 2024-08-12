const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, K] = inp[0].split(" ").map(Number);
let board = [];
let boardFlag = [];
for (let inputIdx = 0; inputIdx < N; inputIdx++) {
  board.push(parseInt(inp[inputIdx + 1]));
  boardFlag.push(false);
}

let result = -1;
let count = 0;
for (let check = 0; check < N; check++) {
  if (boardFlag[check]) break;
  count += 1;
  boardFlag[check] = true;
  if (board[check] === K) {
    result = count;
    break;
  }
  check = board[check] - 1;
}
console.log(result);
