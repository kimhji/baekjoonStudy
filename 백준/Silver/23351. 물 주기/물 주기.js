const fs = require("fs");
//let [N,K,A,B] = fs.readFileSync("input.txt").toString().trim().split(" ").map(Number);
let [N,K,A,B] = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);
let plants = new Array(N).fill(K);
let result = 0;
let curIdx = 0;
while(plants.indexOf(0) ==-1){
    result++;
    for(let cycle = 0;cycle<A;cycle++){
        plants[cycle+curIdx] += B;
    }
    curIdx += A;
    curIdx %= N;
    for(let idx = 0;idx<N;idx++){
        plants[idx]--;
    }

}

console.log(result);