const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
inp.forEach((string) => {
  const tnsstring = string.trim().split("");
  let stack = [];
  let result = true;
  if (tnsstring.length !== 1 || string[0] !== ".") {
    tnsstring.forEach((word) => {
      if (word === "(" || word === "[") {
        stack.push(word);
      } else if (word === ")") {
        if (stack.length === 0 || stack.pop() !== "(") {
          result = false;
        }
      } else if (word === "]") {
        if (stack.length === 0 || stack.pop() !== "[") {
          result = false;
        }
      }
    });
    if (stack.length !== 0) result = false;
    console.log(result ? "yes" : "no");
  }
});
