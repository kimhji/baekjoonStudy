const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(inp[0].trim());
let files = [];
for (let inputCycle = 1; inputCycle <= N; inputCycle++) {
  files.push(inp[inputCycle].trim().split(" "));
}
let k = 0;
let result = false;
while (!result) {
  k++;
  let setFile = new Set();
  files.forEach((fileName) => {
    let tnsFileName = [...fileName];
    let sizeDiff = k - fileName.length;
    if (sizeDiff > 0) {
      tnsFileName.push(...new Array(sizeDiff).fill("0"));
    }
    setFile.add(tnsFileName.splice(0, k).join(""));
  });
  if (setFile.size === N) result = true;
}
console.log(k);
