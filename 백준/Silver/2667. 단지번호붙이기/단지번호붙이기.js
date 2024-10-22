const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const board = [];
for (let inpC = 1; inpC <= N; inpC++) {
  board.push(inp[inpC].trim().split("").map(Number));
}

let value = 0;
let countArr = [];
let length = 0;
for (let cycleY = 0; cycleY < N; cycleY++) {
  for (let cycleX = 0; cycleX < N; cycleX++) {
    if (board[cycleY][cycleX] === 1) {
      countArr.push(0);
      length++;
      let bag = [[cycleY, cycleX]];
      let count = 1;
      value--;
      while (count > 0) {
        count = 0;
        let nextBag = [];
        bag.forEach(([y, x]) => {
          if (board[y][x] === 1) {
            countArr[length - 1]++;
            board[y][x] = value;
            if (x > 0) {
              if (board[y][x - 1] === 1) {
                nextBag.push([y, x - 1]);
                count++;
              }
            }
            if (x < N - 1) {
              if (board[y][x + 1] === 1) {
                nextBag.push([y, x + 1]);
                count++;
              }
            }
            if (y > 0) {
              if (board[y - 1][x] === 1) {
                nextBag.push([y - 1, x]);
                count++;
              }
            }
            if (y < N - 1) {
              if (board[y + 1][x] === 1) {
                nextBag.push([y + 1, x]);
                count++;
              }
            }
          }
        });
        bag = nextBag;
      }
    }
  }
}
console.log(length);
countArr.sort((a, b) => {
  return a - b;
});
countArr.forEach((value) => {
  console.log(value);
});
