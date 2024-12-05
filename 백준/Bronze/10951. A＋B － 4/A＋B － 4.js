const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
inp.forEach(line=>{
    const [A,B] = line.trim().split(' ').map(Number);
    console.log(A+B);
})