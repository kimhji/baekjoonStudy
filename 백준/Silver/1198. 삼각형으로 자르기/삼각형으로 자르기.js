function Bigger(a, b){
    return a>b?a:b;
}
const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let N = parseInt(inp[0].trim());
let maxResult = 0;
let dots = [];
for(let check = 1;check<=N;check++){
    dots.push(inp[check].trim().split(" ").map(Number));
}
let tnsS = 0;
for(let check = 0;check<N;check++){
    for(let preDot = 0;preDot<check;preDot++){
        for(let pre2Dot=0;pre2Dot<preDot;pre2Dot++){
            tnsS = Math.abs(dots[check][0]*dots[preDot][1]+dots[preDot][0]*dots[pre2Dot][1]+dots[pre2Dot][0]*dots[check][1]-(dots[check][0]*dots[pre2Dot][1]+dots[pre2Dot][0]*dots[preDot][1]+dots[preDot][0]*dots[check][1]));
            maxResult = Bigger(maxResult, tnsS/2);
        }
    }
}
console.log(`${maxResult.toFixed(1)}`);