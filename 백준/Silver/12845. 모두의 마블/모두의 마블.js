const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let max = -1;
let number = [];
inp[1]
  .split(" ")
  .map(Number)
  .forEach((num) => {
    if (max < num) {
      if (max !== -1) number.push(max);
      max = num;
    } else {
      number.push(num);
    }
  });
let result = 0;
number.forEach((one) => {
  result += one + max;
});
console.log(result);
