const fs = require("fs");
const input = fs.readFileSync("/dev/stdin").toString().split("\n");
let answer = "";
for(let i = 1; i <= input[0]; i++) {
    tmp = input[i].trim().split(' ').map(Number);
    answer += tmp[0]+tmp[1]+"\n";
}
console.log(answer);