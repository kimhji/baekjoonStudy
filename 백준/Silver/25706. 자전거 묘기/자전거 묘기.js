const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let N = parseInt(inp[0]);
let numb = inp[1].trim().split(" ").map(Number);
let dict = [1];
numb.pop();
for (let check = 0; check < N - 1; check++) {
  let height = numb.pop();
  let loc = height + (N - check);
  if (loc > N) {
    dict.unshift(1);
    continue;
  }
  dict.unshift(dict[height] + 1);
}
console.log(dict.join(" "));
