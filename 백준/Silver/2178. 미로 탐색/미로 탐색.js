const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
const board = [];
for (let inpC = 1; inpC <= N; inpC++) {
  board.push(inp[inpC].trim().split("").map(Number));
}
const goal = [N - 1, M - 1];
let locs = [[0, 0]];
let count = -1;
board[0][0] = count--;

let visit = true;

while (visit) {
  visit = false;
  let nextlocs = [];
  locs.forEach((loc) => {
    if (loc[0] > 0 && board[loc[0] - 1][loc[1]] === 1) {
      board[loc[0] - 1][loc[1]] = count;
      visit = true;
      nextlocs.push([loc[0] - 1, loc[1]]);
    }
    if (loc[1] > 0 && board[loc[0]][loc[1] - 1] === 1) {
      board[loc[0]][loc[1] - 1] = count;
      visit = true;
      nextlocs.push([loc[0], loc[1] - 1]);
    }
    if (loc[0] < goal[0] && board[loc[0] + 1][loc[1]] === 1) {
      board[loc[0] + 1][loc[1]] = count;
      visit = true;
      nextlocs.push([loc[0] + 1, loc[1]]);
    }
    if (loc[1] < goal[1] && board[loc[0]][loc[1] + 1] === 1) {
      board[loc[0]][loc[1] + 1] = count;
      visit = true;
      nextlocs.push([loc[0], loc[1] + 1]);
    }
  });
  locs = nextlocs;
  count--;
  if (board[goal[0]][goal[1]] !== 1) break;
}

console.log(Math.abs(board[goal[0]][goal[1]]));
