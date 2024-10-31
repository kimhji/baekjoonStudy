const fs = require("fs");
//const star = parseInt(fs.readFileSync("input.txt").toString().trim());
const star = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
const length = 4 * star - 3;
const mapArray = Array.from({ length }, () => Array(length).fill(" "));

function starPattern(n, x, y) {
  const length = 4 * n - 3;
  if (length === 1) {
    mapArray[x][y] = "*";
    return;
  } else {
    for (let i = 0; i < length; i++) {
      mapArray[x][y + i] = "*";
      mapArray[x + i][y] = "*";
      mapArray[x + (length - 1)][y + i] = "*";
      mapArray[x + i][y + (length - 1)] = "*";
    }
    n = n - 1;
    x = x + 2;
    y = y + 2;
    starPattern(n, x, y);
  }
}

starPattern(star, 0, 0);
for (let i = 0; i < length; i++) {
  console.log(mapArray[i].join(""));
}
