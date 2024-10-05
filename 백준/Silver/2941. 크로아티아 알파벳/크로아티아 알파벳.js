const fs = require("fs");
//let data = fs.readFileSync("input.txt").toString().trim();
let data = fs.readFileSync("/dev/stdin").toString().trim();
let result = 0;
const splitData = ["c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="];
splitData.forEach((dataOne) => {
  let nextArr = data.split(dataOne);
  result += nextArr.length - 1;
  data = nextArr.join(" ");
});
console.log(
  result +
    data.split("").filter((word) => {
      return word !== " ";
    }).length
);
