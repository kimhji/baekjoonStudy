const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const T = parseInt(inp[0].trim());
for (let cycle = 1; cycle <= T; cycle++) {
  let N = parseInt(inp[cycle].trim());
  let str_2 = N.toString(2).split("");
  let result = BigInt(0);
  let curNum = BigInt(1);
  while (str_2.length > 0) {
    let check = str_2.pop();
    if (check === "1") {
      result += curNum;
    }
    curNum *= BigInt(3);
  }
  console.log(result.toString());
}
