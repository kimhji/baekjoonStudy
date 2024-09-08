const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
let students = [];
for (let idx = 1; idx <= N; idx++) {
  let student = inp[idx].trim().split(" ");
  students.push([
    student[0],
    parseInt(student[1]),
    parseInt(student[2]),
    parseInt(student[3]),
  ]);
}

students.sort((a, b) => {
  if (b[1] !== a[1]) {
    return b[1] - a[1];
  }
  if (b[2] !== a[2]) {
    return a[2] - b[2];
  }
  if (b[3] !== a[3]) {
    return b[3] - a[3];
  }
  if (a[0] > b[0]) {
    return 1;
  }
  return -1;
});

students.forEach((student) => {
  console.log(student[0]);
});
