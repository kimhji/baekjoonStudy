const dir = {
  left: 0,
  up: 1,
  right: 2,
  bottom: 3,
};
const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
for (let cycle = 1; cycle <= N; cycle++) {
  let result = 0;
  let minLoc = [0, 0];
  let maxLoc = [0, 0];
  let loc = [0, 0];
  let curDir = dir.up;
  let order = inp[cycle].trim();
  order.split("").forEach((move) => {
    if (move === "F") {
      switch (curDir) {
        case dir.up:
          loc[1] += 1;
          if (maxLoc[1] < loc[1]) maxLoc[1] = loc[1];
          break;
        case dir.bottom:
          loc[1] -= 1;
          if (minLoc[1] > loc[1]) minLoc[1] = loc[1];
          break;
        case dir.right:
          loc[0] += 1;
          if (maxLoc[0] < loc[0]) maxLoc[0] = loc[0];
          break;
        case dir.left:
          loc[0] -= 1;
          if (minLoc[0] > loc[0]) minLoc[0] = loc[0];
          break;
      }
    } else if (move === "B") {
      switch (curDir) {
        case dir.up:
          loc[1] -= 1;
          if (minLoc[1] > loc[1]) minLoc[1] = loc[1];
          break;
        case dir.bottom:
          loc[1] += 1;
          if (maxLoc[1] < loc[1]) maxLoc[1] = loc[1];
          break;
        case dir.right:
          loc[0] -= 1;
          if (minLoc[0] > loc[0]) minLoc[0] = loc[0];
          break;
        case dir.left:
          loc[0] += 1;
          if (maxLoc[0] < loc[0]) maxLoc[0] = loc[0];
          break;
      }
    } else if (move === "L") {
      curDir -= 1;
      if (curDir < 0) curDir += 4;
    } else if (move === "R") {
      curDir += 1;
      if (curDir > 3) curDir -= 4;
    }
  });

  result = (maxLoc[0] - minLoc[0]) * (maxLoc[1] - minLoc[1]);
  console.log(result);
}
