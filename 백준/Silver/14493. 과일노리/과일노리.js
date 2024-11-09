const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
let time = 0;
for (let idx = 1; idx <= N; idx++) {
  const [A, B] = inp[idx].trim().split(" ").map(Number);
  const checkT = time % (A + B);
  if (checkT <= B) {
    time += B - checkT;
  }
  time++;
}
console.log(time);
