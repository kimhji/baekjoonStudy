const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, K] = inp[0].trim().split(" ").map(Number);
const diffList = [];
for (let idx = 1; idx <= N; idx++) {
  const [curV, maxV] = inp[idx].trim().split(" ").map(Number);
  diffList.push(maxV - curV);
}
diffList.sort((a, b) => {
  return a - b;
});

console.log(diffList[K - 1] < 0 ? 0 : diffList[K - 1]);
