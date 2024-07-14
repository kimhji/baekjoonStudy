const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let N = parseInt(inp[0]);
let M = parseInt(inp[1]);
let result = 0;
let req = inp[2].split(" ").map(Number);
for(let i = 0;i<N;i++){
    for(let j = 0;j<i;j++){
        if(req[i]+req[j] == M){
            result += 1;
        }
    }
}
console.log(result);