const fs = require("fs");
//const strs = fs.readFileSync("input.txt").toString().trim().split("\n");
const strs = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const one = strs[0].trim().split("");
const oneL = strs[0].trim().length;
const two = strs[1].trim().split("");
const twoL = strs[1].trim().length;
const arr = Array.from({ length: oneL + 1 }, () => new Array(twoL + 1).fill(0));
for (let oneIdx = 1; oneIdx <= oneL; oneIdx++) {
  for (let twoIdx = 1; twoIdx <= twoL; twoIdx++) {
    if (one[oneIdx - 1] === two[twoIdx - 1]) {
      arr[oneIdx][twoIdx] = arr[oneIdx - 1][twoIdx - 1] + 1;
    } else {
      arr[oneIdx][twoIdx] = Math.max(
        arr[oneIdx][twoIdx - 1],
        arr[oneIdx - 1][twoIdx]
      );
    }
  }
}
console.log(arr[oneL][twoL]);
