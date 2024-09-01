const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(inp[0].trim());
let mini = [];
for (let inpC = 1; inpC <= N; inpC++) {
  mini.push(inp[inpC].trim().split(" ").map(Number));
}
mini.sort((a, b) => {
  if (a[0] !== b[0]) {
    return b[0] - a[0];
  }
  return a[1] - b[1];
});

console.log(mini[0].join(" "), mini[1].join(" "));
mini.sort((a, b) => {
  if (a[1] !== b[1]) {
    return a[1] - b[1];
  }
  return b[0] - a[0];
});

console.log(mini[0].join(" "), mini[1].join(" "));
