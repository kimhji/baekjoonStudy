function check(pre, value, count) {
  if (count >= N) {
    if (!visit[value]) {
      result++;
    }
    visit[value] = true;
    return;
  }
  if (pre <= 1) check(1, value + 1, count + 1);
  if (pre <= 5) check(5, value + 5, count + 1);
  if (pre <= 10) check(10, value + 10, count + 1);
  if (pre <= 50) check(50, value + 50, count + 1);
}

const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
const visit = new Array(50 * 20 + 1).fill(false);
let result = 0;
check(1, 0, 0);

console.log(result);
