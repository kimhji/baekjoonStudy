const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const T = parseInt(inp[0].trim());

for (let cycle = 1; cycle <= T; cycle++) {
  let [B, X, Y] = inp[cycle].trim().split(" ").map(Number);
  let X_B = [];
  let XN = 0;
  let Y_B = [];
  let YN = 0;
  while (X >= B) {
    X_B.push(X % B);
    X = Math.floor(X / B);
    XN++;
  }
  X_B.push(X);
  XN++;
  while (Y >= B) {
    Y_B.push(Y % B);
    Y = Math.floor(Y / B);
    YN++;
  }
  Y_B.push(Y);
  YN++;
  result = 0;
  while (YN > 0 || XN > 0) {
    result *= B;
    if (YN > XN) {
      YN--;
      result += Y_B.pop();
    } else if (XN > YN) {
      XN--;
      result += X_B.pop();
    } else {
      XN--;
      YN--;
      result += (Y_B.pop() + X_B.pop()) % B;
    }
  }
  console.log(result);
}
