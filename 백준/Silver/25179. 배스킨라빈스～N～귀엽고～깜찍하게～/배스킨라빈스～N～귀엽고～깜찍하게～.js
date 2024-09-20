const fs = require("fs");
const [N, M] = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .split(" ")
  .map((data) => {
    return BigInt(data);
  });
if (N % (M + BigInt(1)) == BigInt(1)) console.log("Can't win");
else console.log("Can win");
