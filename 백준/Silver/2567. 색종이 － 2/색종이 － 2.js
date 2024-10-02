const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0]);
const locs = [];
const board = Array.from({ length: 100 }, () => {
  return new Array(100).fill(false);
});
for (let inpCycle = 1; inpCycle <= N; inpCycle++) {
  const [x, y] = inp[inpCycle].trim().split(" ").map(Number);
  locs.push([x, y]);
  for (let tnsY = 0; tnsY < 10; tnsY++) {
    for (let tnsX = 0; tnsX < 10; tnsX++) {
      board[y + tnsY][x + tnsX] = true;
    }
  }
}

let result = 0;
for (let checkY = 0; checkY < 100; checkY++) {
  for (let checkX = 0; checkX < 100; checkX++) {
    if (board[checkY][checkX]) {
      if (checkY === 0) {
        result++;
        if (!board[checkY + 1][checkX]) result++;
      } else if (checkY === 99) {
        result++;
        if (!board[checkY - 1][checkX]) result++;
      } else {
        if (!board[checkY - 1][checkX]) result++;
        if (!board[checkY + 1][checkX]) result++;
      }
      if (checkX === 0) {
        result++;
        if (!board[checkY][checkX + 1]) result++;
      } else if (checkX === 99) {
        result++;
        if (!board[checkY][checkX - 1]) result++;
      } else {
        if (!board[checkY][checkX - 1]) result++;
        if (!board[checkY][checkX + 1]) result++;
      }
    }
  }
}
console.log(result);
