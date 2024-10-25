const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const str = inp[1].trim().split("");

const map = new Map();
for (let idx = 0; idx < N / 2; idx++) {
  if (map.get(str[idx])) {
    map.set(str[idx], map.get(str[idx]) + 1);
  } else {
    map.set(str[idx], 1);
  }

  if (map.get(str[N - idx - 1])) {
    map.set(str[N - idx - 1], map.get(str[N - idx - 1]) + 1);
  } else {
    map.set(str[N - idx - 1], 1);
  }
}
const value = map.values();
let check = value.next();
let result = true;
while (!check.done) {
  if (check.value % 2) {
    result = false;
  }
  check = value.next();
}

console.log(result ? "Yes" : "No");
