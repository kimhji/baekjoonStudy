function checkWin(board, x, y) {
  return (
    checkHori(board, x, y) ||
    checkVerti(board, x, y) ||
    checkDiag_plus(board, x, y) ||
    checkDiag_minus(board, x, y)
  );
}

function checkHori(board, x, y) {
  let count = 0;
  if (x >= findMax) return false;
  for (let cycle = 0; cycle < 5; cycle++) {
    switch (board[y][x + cycle]) {
      case "X":
        break;
      case "O":
        return false;
      default:
        count++;
    }
  }
  return count <= 1;
}

function checkVerti(board, x, y) {
  let count = 0;
  if (y >= findMax) return false;
  for (let cycle = 0; cycle < 5; cycle++) {
    switch (board[y + cycle][x]) {
      case "X":
        break;
      case "O":
        return false;
      default:
        count++;
    }
  }
  return count <= 1;
}
function checkDiag_plus(board, x, y) {
  let count = 0;
  if (y < 4 || x >= findMax) return false;
  for (let cycle = 0; cycle < 5; cycle++) {
    switch (board[y - cycle][x + cycle]) {
      case "X":
        break;
      case "O":
        return false;
      default:
        count++;
    }
  }
  return count <= 1;
}

function checkDiag_minus(board, x, y) {
  let count = 0;
  if (y >= findMax || x >= findMax) return false;
  for (let cycle = 0; cycle < 5; cycle++) {
    switch (board[y + cycle][x + cycle]) {
      case "X":
        break;
      case "O":
        return false;
      default:
        count++;
    }
  }
  return count <= 1;
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const findMax = 6;
const size = 10;
let board = [];
for (let idx = 0; idx < size; idx++) {
  board.push(inp[idx].trim().split(""));
}

let result = false;
for (let y = 0; y < size; y++) {
  for (let x = 0; x < size; x++) {
    if (checkWin(board, x, y)) {
      result = true;
      break;
    }
  }
  if (result) break;
}
console.log(result ? 1 : 0);
