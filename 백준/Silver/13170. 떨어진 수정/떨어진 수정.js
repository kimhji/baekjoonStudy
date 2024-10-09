const fs = require("fs");
const [N, K, P, W] = fs
  //  .readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
console.log(Math.ceil(P / W));
