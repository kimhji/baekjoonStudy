function check(numberList, checkList, count, n) {
  if (count === n) {
    let result = true;
    checkList.forEach((number) => {
      if (!numberList[number]) result = false;
    });
    return result ? 1 : 0;
  }
  let value = 0;
  for (let cycle = 0; cycle <= 9; cycle++) {
    numberList[cycle]++;
    value += check(numberList, checkList, count + 1, n);
    numberList[cycle]--;
  }
  return value;
}

const fs = require("fs");
const inp = fs
  //.readFileSync("input.txt")
  .readFileSync("/dev/stdin")
  .toString()
  .trim()
  .split("\n");

const [N, M] = inp[0].trim().split(" ").map(Number);

const includeNumber = M ? inp[1].trim().split(" ").map(Number) : [];
console.log(check(new Array(10).fill(0), includeNumber, 0, N));
