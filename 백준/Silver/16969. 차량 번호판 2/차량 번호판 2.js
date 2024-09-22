const fs = require("fs");
//const formation = fs.readFileSync("input.txt").toString().trim().split("");
const formation = fs.readFileSync("/dev/stdin").toString().trim().split("");
let cases = BigInt(1);
let flag = 0;

formation.forEach((one) => {
  if (one === "d") {
    let able = 10;
    if (flag === 1) {
      able--;
    }
    flag = 1;
    cases *= BigInt(able);
  } else if (one === "c") {
    let able = 26;
    if (flag === 2) {
      able--;
    }
    flag = 2;
    cases *= BigInt(able);
  }
  cases %= BigInt(1000000009);
});
console.log(cases.toString());
