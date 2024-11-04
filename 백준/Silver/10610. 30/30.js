const fs = require("fs");
const inp = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("")
  .map(Number);
let sumV = 0;
let exist0 = false;
inp.forEach((item) => {
  sumV += item;
  if (!item) exist0 = true;
});
if (sumV % 3 !== 0 || !exist0) {
  console.log(-1);
} else {
  inp.sort((a, b) => {
    return b - a;
  });
  console.log(inp.join(""));
}
