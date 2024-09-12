const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const findNum = parseInt(inp[1].trim());

let board = Array.from({ length: N }, () => {
  return new Array(N).fill(0);
});

let idx = [Math.floor(N / 2), Math.floor(N / 2)];
let dir = -1;
let count = 1;
let cycle = 0;
let cycleLeng = 0;
let flag = true;
let result = [];

while (count <= N * N) {
  switch (dir) {
    case 0:
      idx[0]--;
      break;
    case 1:
      idx[1]++;
      break;
    case 2:
      idx[0]++;
      break;
    case 3:
      idx[1]--;
      break;
  }
  if (count === findNum) {
    result = [...idx];
  }
  board[idx[0]][idx[1]] = count++;
  if (cycle === cycleLeng) {
    if (flag) {
      cycleLeng++;
      flag = false;
      cycle = 0;
    } else {
      flag = true;
      cycle = 0;
    }
    dir = (dir + 1) % 4;
  }
  cycle++;
}
board.forEach((row) => {
  console.log(row.join(" "));
});
console.log(result.map((idx) => idx + 1).join(" "));
