const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
let [xArr, yArr] = [[], []];
for (let i = 1; i <= N; i++) {
  const [x, y] = inp[i].trim().split(" ").map(Number);
  xArr.push(x);
  yArr.push(y);
}
xArr.sort((a, b) => {
  return a - b;
});
yArr.sort((a, b) => {
  return a - b;
});

const loc = [xArr[Math.floor(N / 2)], yArr[Math.floor(N / 2)]];
let result = 0;
for (let i = 1; i <= N; i++) {
  const [x, y] = inp[i].trim().split(" ").map(Number);
  result += Math.abs(x - loc[0]) + Math.abs(y - loc[1]);
}
console.log(result);
