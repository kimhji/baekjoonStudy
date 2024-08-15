function findOk(bag, status, count) {
  if (count === N) {
    result++;
    return;
  }
  for (let cycle = 0; cycle < N - count; cycle++) {
    if (status - K + bag[cycle] < 500) continue;
    let nextBag = bag.filter((number, idx) => {
      return idx !== cycle;
    });
    findOk(nextBag, status - K + bag[cycle], count + 1);
  }
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
var [N, K] = inp[0].split(" ").map(Number);
let inpBag = inp[1].split(" ").map(Number);
var result = 0;
findOk(inpBag, 500, 0);
console.log(result);
