var minmax = {
  minX: 0,
  minY: 0,
  maxX: 5,
  maxY: 5,
  xLength: 6,
  yLength: 6,
};

function checkCanGo(beforeLoc, afterLoc) {
  if (
    beforeLoc[0] < minmax.minY ||
    beforeLoc[1] < minmax.minX ||
    beforeLoc[1] > minmax.maxX ||
    beforeLoc[0] > minmax.maxY
  )
    return false;
  if (
    afterLoc[0] < minmax.minY ||
    afterLoc[1] < minmax.minX ||
    afterLoc[1] > minmax.maxX ||
    afterLoc[0] > minmax.maxY
  )
    return false;

  if (beforeLoc[0] - 1 === afterLoc[0] && beforeLoc[1] - 2 === afterLoc[1])
    return true;
  if (beforeLoc[0] - 1 === afterLoc[0] && beforeLoc[1] + 2 === afterLoc[1])
    return true;
  if (beforeLoc[0] + 1 === afterLoc[0] && beforeLoc[1] - 2 === afterLoc[1])
    return true;
  if (beforeLoc[0] + 1 === afterLoc[0] && beforeLoc[1] + 2 === afterLoc[1])
    return true;
  if (beforeLoc[1] - 1 === afterLoc[1] && beforeLoc[0] - 2 === afterLoc[0])
    return true;
  if (beforeLoc[1] - 1 === afterLoc[1] && beforeLoc[0] + 2 === afterLoc[0])
    return true;
  if (beforeLoc[1] + 1 === afterLoc[1] && beforeLoc[0] - 2 === afterLoc[0])
    return true;
  if (beforeLoc[1] + 1 === afterLoc[1] && beforeLoc[0] + 2 === afterLoc[0])
    return true;
  return false;
}

const fs = require("fs");
//const chess = fs.readFileSync("input.txt").toString().split("\n");
const chess = fs.readFileSync("/dev/stdin").toString().split("\n").filter(Boolean);
let chessBoard = Array.from({ length: minmax.yLength }, () =>
  Array(minmax.xLength).fill(false)
);
let result = true;
let preLoc = null;

chess.forEach((play, index) => {
  const loc = play.trim().split("");
  const x = loc[0].charCodeAt() - "A".charCodeAt();
  const y = parseInt(loc[1]) - 1;

  if (
    x > minmax.maxX ||
    x < minmax.minX ||
    y > minmax.maxY ||
    y < minmax.minY ||
    chessBoard[y][x]
  ) {
    result = false;
  } else {
    chessBoard[y][x] = true;
    
    if (preLoc) {
      if (!checkCanGo(preLoc, [y, x])) {
        result = false;
      }
    }
    preLoc = [y, x];
  }
});

// 마지막 위치와 첫 번째 위치를 비교
if (preLoc) {
  let firstLoc = chess[0].trim().split("");
  firstLoc = [parseInt(firstLoc[1]) - 1, firstLoc[0].charCodeAt() - "A".charCodeAt()];

  if (!checkCanGo(preLoc, firstLoc)) {
    result = false;
  }
}

// 모든 위치가 사용되었는지 확인
for (let boardCycleY = minmax.minY; boardCycleY < minmax.maxY; boardCycleY++) {
  for (
    let boardCycleX = minmax.minX;
    boardCycleX < minmax.maxX;
    boardCycleX++
  ) {
    if (!chessBoard[boardCycleY][boardCycleX]) result = false;
  }
}

if (result) {
  console.log("Valid");
} else {
  console.log("Invalid");
}
