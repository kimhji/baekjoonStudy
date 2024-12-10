const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, M] = inp[0].trim().split(" ").map(Number);
const arr = [];
for(let i = 1;i<=N;i++){
    arr.push(inp[i].trim().split(" ").map(Number));
}
for(let i = 0;i<N;i++){
    const line = inp[i+N+1].trim().split(" ").map(Number);
    for(let j = 0;j<M;j++){
        arr[i][j] += line[j];
    }
    console.log(arr[i].join(" "));
}