const fs = require("fs");
//const [A, B, D] = fs.readFileSync("input.txt").toString().trim().split(" ");
const [A, B, D] = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
let count = 0;
const A_Number = parseInt(A);
const B_Number = parseInt(B);
for (let curNumber = A_Number; curNumber <= B_Number; curNumber++) {
  const sqrt = Math.sqrt(curNumber);
  let flag = true;
  for (let check = 2; check <= sqrt; check++) {
    if (curNumber % check === 0) {
      flag = false;
      break;
    }
  }
  if (flag && curNumber.toString().includes(D)) {
    count++;
  }
}
console.log(count);
