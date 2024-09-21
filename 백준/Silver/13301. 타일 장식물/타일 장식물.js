const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
let curIdx = 1;
let arround = BigInt(4);
const numberList = [BigInt(0), BigInt(1)];
while (curIdx < N) {
  const nextR = numberList[curIdx] + numberList[curIdx - 1];
  numberList.push(nextR);
  curIdx++;
  arround += nextR * BigInt(2);
}
console.log(arround.toString());
