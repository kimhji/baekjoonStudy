const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(inp[0].trim());
const cases = inp[1].trim().split(" ").map(Number);
let brand = {};

cases.forEach((c) => {
  if (c in brand) {
    brand[c]++;
  } else {
    brand[c] = 1;
  }
});

let result = 0;

for (let leng = 1; leng <= N; leng++) {
  let resultPerLength = 1;
  for (let check = 1; check <= leng; check++) {
    if (check in brand) {
      resultPerLength *= brand[check];
    } else {
      resultPerLength = 0;
      break;
    }
  }
  if (resultPerLength === 0) break;
  result += resultPerLength;
}
console.log(result);
