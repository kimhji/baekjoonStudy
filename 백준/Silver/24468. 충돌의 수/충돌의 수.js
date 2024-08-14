const dir = {
  left: 0,
  right: 1,
};

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const [L, N, T] = inp[0].split(" ").map(Number);
let balls = [];
let board = new Array(L + 1).fill(0);
let crashResult = 0;
for (let ballInp = 1; ballInp <= N; ballInp++) {
  let [loc, dirInp] = inp[ballInp].trim().split(" ");
  board[loc]++;
  balls.push([parseInt(loc), dirInp == "R" ? dir.right : dir.left]);
}
for (let cycle = 0; cycle < T; cycle++) {
  for (let ballMove = 0; ballMove < N; ballMove++) {
    board[balls[ballMove][0]]--;
    if (balls[ballMove][1] === dir.left) {
      balls[ballMove][0]--;
      if (balls[ballMove][0] <= 0) balls[ballMove][1] = dir.right;
    } else {
      balls[ballMove][0]++;
      if (balls[ballMove][0] >= L) balls[ballMove][1] = dir.left;
    }

    board[balls[ballMove][0]]++;
  }
  board.forEach((location) => {
    if (location > 1) crashResult++;
  });
}
console.log(crashResult);
