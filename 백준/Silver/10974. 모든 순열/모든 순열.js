function cases(bag, N, count) {
  if (count <= 0) {
    console.log(bag.join(" "));
    return;
  }

  for (let cycle = 1; cycle <= N; cycle++) {
    if (bag.indexOf(cycle) != -1) continue;
    bag.push(cycle);
    cases(bag, N, count - 1);
    bag.pop();
  }
}

const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
cases([], N, N);
