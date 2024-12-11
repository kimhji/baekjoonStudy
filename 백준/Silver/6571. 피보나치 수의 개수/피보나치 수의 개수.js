const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let idx = 0;
let [A, B] = inp[idx++]
  .trim()
  .split(" ")
  .map((data) => BigInt(data));
const fibo = [1n, 1n];
let fiboLength = 1;
while (A !== 0n || B !== 0n) {
  let minIdx = 1;
  let maxIdx = 1;
  while (fibo[minIdx] < A && A !== 0) {
    if (fiboLength <= minIdx) {
      fibo.push(fibo[fiboLength] + fibo[fiboLength - 1]);
      fiboLength++;
    }
    minIdx++;
  }
  maxIdx = minIdx;
  while (fibo[maxIdx] <= B) {
    if (fiboLength <= maxIdx) {
      fibo.push(fibo[fiboLength] + fibo[fiboLength - 1]);
      fiboLength++;
    }
    maxIdx++;
  }
  const result = maxIdx - minIdx < 0 ? 0 : maxIdx - minIdx;
  console.log(result);
  [A, B] = inp[idx++]
    .trim()
    .split(" ")
    .map((data) => BigInt(data));
}
