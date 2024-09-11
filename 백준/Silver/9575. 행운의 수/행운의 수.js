function solution(A, B, C) {
  let result = new Set();

  A.forEach((item1) => {
    B.forEach((item2) => {
      C.forEach((item3) => {
        let num = item1 + item2 + item3;
        let numString = num.toString().split("");
        const not58 = numString.filter((value) => {
          return value !== "5" && value !== "8";
        });
        if (not58.length === 0) result.add(num);
      });
    });
  });
  return result;
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const T = parseInt(inp[0].trim());
let idx = 1;
for (let cycle = 0; cycle < T; cycle++) {
  const N = parseInt(inp[idx++].trim());
  const A = inp[idx++].trim().split(" ").map(Number);
  const M = parseInt(inp[idx++].trim());
  const B = inp[idx++].trim().split(" ").map(Number);
  const K = parseInt(inp[idx++].trim());
  const C = inp[idx++].trim().split(" ").map(Number);
  console.log(solution(A, B, C).size);
}
