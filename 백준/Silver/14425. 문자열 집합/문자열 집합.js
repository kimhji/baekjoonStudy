const fs = require("fs");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
var [N, M] = inp[0].split(" ").map(Number);
var S = new Set();
for(let i=1;i<=N;i++){
    S.add(inp[i]);
}
var result=0;
for(let i=N+1;i<=M+N;i++){
    
    if(S.has(inp[i])){
        result++;
    }
}
console.log(result);