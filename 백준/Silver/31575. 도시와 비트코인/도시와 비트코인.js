function check(visited, board, x, y, maxX, maxY) {
  if (x === maxX && y === maxY) {
    return true;
  }
  if (visited[y][x]) return false;
  visited[y][x] = true;
  let downResult = false;
  let rightResult = false;
  if (x < maxX && board[y][x + 1]) {
    rightResult = check(visited, board, x + 1, y, maxX, maxY);
  }
  if (y < maxY && board[y + 1][x]) {
    downResult = check(visited, board, x, y + 1, maxX, maxY);
  }
  return downResult || rightResult;
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [M, N] = inp[0].trim().split(" ").map(Number);

const board = [];
for (let cycleInp = 1; cycleInp <= N; cycleInp++) {
  board.push(inp[cycleInp].trim().split(" ").map(Number));
}
const result = check(
  Array.from({ length: N }, () => Array(M).fill(false)),
  board,
  0,
  0,
  M - 1,
  N - 1
);
console.log(result ? "Yes" : "No");
