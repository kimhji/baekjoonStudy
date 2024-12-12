const fs = require("fs");
const inp = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n")
  .map(Number);
const N = inp[0];
for (let i = 1; i <= N; i++) {
  const arr = new Array(10).fill(false);
  const number = inp[i];
  let times = 1;
  let insomnia = 0;
  while (insomnia !== -1 && times < 111) {
    let curNum = (number * times++).toString().split("").map(Number);
    curNum.forEach((one) => {
      if (!arr[one]) {
        arr[one] = true;
      }
    });
    insomnia = arr.indexOf(false);
  }
  if (insomnia === -1) {
    console.log(`Case #${i}: ${number * (times - 1)}`);
  } else {
    console.log(`Case #${i}: INSOMNIA`);
  }
}
