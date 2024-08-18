const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let T = parseInt(inp[0].trim());
let curIdx = 1;
for (let cycle = 0; cycle < T; cycle++) {
  let dict = [];
  let conditions = inp[curIdx++].trim().split(",");
  conditions.forEach((condition) => {
    let [name, val] = condition.split(":");
    dict[name] = parseInt(val);
  });
  let herWants = inp[curIdx++].trim().split("|");
  let result = null;
  herWants.forEach((ands) => {
    let andArr = ands.split("&");
    let maxVal = null;
    andArr.forEach((and) => {
      if (maxVal === null || dict[and] > maxVal) maxVal = dict[and];
    });
    if (result === null || result > maxVal) result = maxVal;
  });
  console.log(result);
}
