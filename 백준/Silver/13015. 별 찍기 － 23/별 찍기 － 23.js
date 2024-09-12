const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

for (let upper = 0; upper < N - 1; upper++) {
  let result = "";
  if (upper === 0)
    result = "*".repeat(N) + " ".repeat((N - 1) * 2 - 1) + "*".repeat(N);
  else
    result =
      " ".repeat(upper) +
      "*" +
      " ".repeat(N - 2) +
      "*" +
      " ".repeat((N - upper - 1) * 2 - 1) +
      "*" +
      " ".repeat(N - 2) +
      "*";
  console.log(result);
}

const middle =
  " ".repeat(N - 1) + "*" + " ".repeat(N - 2) + "*" + " ".repeat(N - 2) + "*";
console.log(middle);

for (let upper = N - 2; upper >= 0; upper--) {
  let result = "";
  if (upper === 0)
    result = "*".repeat(N) + " ".repeat((N - 1) * 2 - 1) + "*".repeat(N);
  else
    result =
      " ".repeat(upper) +
      "*" +
      " ".repeat(N - 2) +
      "*" +
      " ".repeat((N - upper - 1) * 2 - 1) +
      "*" +
      " ".repeat(N - 2) +
      "*";
  console.log(result);
}
