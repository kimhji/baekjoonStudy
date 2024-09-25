const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const money = [];
for (let i = 1; i <= N; i++) {
  const [val, cost] = inp[i].trim().split(" ").map(Number);
  money.push([val, cost]);
}
let maxV = 0;
let resultV = 0;
money.forEach((item) => {
  const curV = item[0];
  let tmpV = 0;
  money.forEach((check) => {
    if (check[0] >= curV) {
      const cmpV = curV - check[1];
      if (cmpV > 0) tmpV += cmpV;
    }
  });
  if (tmpV > maxV || (tmpV === maxV && curV < resultV)) {
    maxV = tmpV;
    resultV = curV;
  }
});

console.log(resultV);
