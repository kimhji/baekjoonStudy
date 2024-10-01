const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const numbers = inp[1].trim().split(" ").map(Number);

let dir = 0;
let maxCount = 0;
let count = 0;
let preNumber = numbers[0];
let sameNum = 0;

numbers.forEach((number) => {
  if (!dir) {
    if (preNumber < number) {
      dir = 1;
      sameNum = 1;
    } else if (preNumber > number) {
      dir = 2;
      sameNum = 1;
    } else {
      sameNum++;
    }
    count++;
    if (maxCount < count) maxCount = count;
  } else if (dir === 1) {
    if (preNumber <= number) {
      if (preNumber === number) {
        sameNum++;
      } else {
        sameNum = 1;
      }
      count++;
      if (maxCount < count) maxCount = count;
    } else {
      dir = 2;
      count = sameNum + 1;
      sameNum = 1;
    }
  } else if (dir === 2) {
    if (preNumber >= number) {
      if (preNumber === number) {
        sameNum++;
      } else {
        sameNum = 1;
      }
      count++;
      if (maxCount < count) maxCount = count;
    } else {
      dir = 1;
      count = sameNum + 1;
      sameNum = 1;
    }
  }
  preNumber = number;
});
console.log(maxCount);
