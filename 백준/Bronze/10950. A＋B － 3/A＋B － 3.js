const fs= require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
for(let i = 1;i<=N;i++){
    const [A, B] = inp[i].trim().split(" ").map(Number);
    console.log(A+B);
}