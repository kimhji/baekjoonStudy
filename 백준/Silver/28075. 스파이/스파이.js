function check(N, M, count, value, beforeIdx) {
  if (count === N) {
    if (value >= M) {
      result++;
    }
    return;
  }
  for (let cycleCol = 0; cycleCol < 3; cycleCol++) {
    for (let cycleRow = 0; cycleRow < 2; cycleRow++) {
      if (cycleCol === beforeIdx) {
        check(
          N,
          M,
          count + 1,
          value + mission[cycleRow][cycleCol] / 2,
          cycleCol
        );
      } else {
        check(N, M, count + 1, value + mission[cycleRow][cycleCol], cycleCol);
      }
    }
  }
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
var mission = [];
mission.push(inp[1].trim().split(" ").map(Number));
mission.push(inp[2].trim().split(" ").map(Number));

var result = 0;

check(N, M, 0, 0, -1);
console.log(result);
