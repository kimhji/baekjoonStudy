const fs = require("fs");
const [N, M, K] = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
if (N + M - 1 > K) {
  console.log("NO");
  return;
}

const board = Array.from({ length: N }, () => new Array(M).fill(0));
for (let y = 0; y < N; y++) {
  for (let x = 0; x < M; x++) {
    board[y][x] = x + y + 1;
  }
}
console.log("YES");
board.forEach((line) => {
  console.log(line.join(" "));
});
