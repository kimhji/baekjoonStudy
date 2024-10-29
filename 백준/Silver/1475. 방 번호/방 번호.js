const fs = require("fs");
const numbers = fs
  //  .readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("")
  .map(Number);

const arr = new Array(10).fill(0);
numbers.forEach((number) => {
  arr[number]++;
});
let maxV = 0;
arr[6] = Math.ceil((arr[6] + arr[9]) / 2);
arr[9] = 0;
arr.forEach((val) => {
  if (maxV < val) maxV = val;
});
console.log(maxV);
