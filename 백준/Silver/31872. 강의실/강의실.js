const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let [N, K] = inp[0].trim().split(" ").map(Number);
let numb = inp[1].trim().split(" ").map(Number);
numb.sort((a, b) => {
  return a - b;
});
let diff = [];
for (let check = 0; check < N; check++) {
  if (check == 0) {
    diff.push([check, numb[check]]);
    continue;
  }
  diff.push([check, numb[check] - numb[check - 1]]);
}
diff.sort((a, b) => {
  return a[1] - b[1];
});
let result = 0;
for (let s = 0; s < N - K; s++) {
  result += diff[s][1];
}
console.log(result);
