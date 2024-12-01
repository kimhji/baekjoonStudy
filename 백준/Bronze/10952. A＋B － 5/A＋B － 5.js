const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let idx = 0;
let [A, B] = inp[idx++].trim().split(" ").map(Number);
while(A || B){
    console.log(A+B);
    [A, B] = inp[idx++].trim().split(" ").map(Number);
}