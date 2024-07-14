const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let [N, L] = inp[0].split(" ").map(Number);
let number = inp[1].split(" ").map(Number);
number.sort((a,b)=>{
    return a-b;
})

let covered = -1;
let result = 0;
for(let i = 0; i < N;i++){
    if(covered == -1){
        result += 1;
        covered = number[i]+L-1;
    }
    else if(number[i] > covered){
        result += 1;
        covered = number[i]+L-1;
    }
}
console.log(result);