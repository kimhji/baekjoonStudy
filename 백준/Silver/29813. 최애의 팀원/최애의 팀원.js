const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let N = parseInt(inp[0].trim());
let student = [];
for (let i = 1; i <= N; i++) {
  let [name, number] = inp[i].trim().split(" ");
  student.push([name, parseInt(number)]);
}
let turn = student.shift();
N--;
while (N !== 0) {
  for (let cycle = 0; cycle < (turn[1] - 1) % N; cycle++) {
    let st = student.shift();
    student.push(st);
  }
  student.shift();
  N--;
  turn = student.shift();
  N--;
}

console.log(turn[0]);
