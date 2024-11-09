const fs = require("fs");
const [N, K] = fs
  .readFileSync("/dev/stdin")
  //.readFileSync("input.txt")
  .toString()
  .trim()
  .split(" ")
  .map(Number);
const numbers = new Array(N + 1).fill(true);
numbers[0] = false;
numbers[1] = false;
let count = 0;
let curN = 0;
let result = 0;
while (curN <= N) {
  curN = numbers.indexOf(true);
  if (curN === -1) break;
  result = curN;
  while (result <= N) {
    if (numbers[result]) {
      numbers[result] = false;
      count++;
      if (count === K) {
        break;
      }
    }
    result += curN;
  }
  if (count === K) {
    break;
  }
}
console.log(result);
