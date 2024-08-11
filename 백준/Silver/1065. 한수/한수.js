const fs = require("fs");
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
let result=0;
for(let cycle=1;cycle<=N;cycle++){
    let flag = true;
    let diff = null;
    let strNum= cycle.toString().split("");
    let L = strNum.length;
    for(let check=1;check<L;check++){
        if(diff===null){
            diff = parseInt(strNum[check])-parseInt(strNum[check-1]);
            continue;
        }
        if(parseInt(strNum[check])-parseInt(strNum[check-1]) !== diff){
            flag = false;
        }
    }
    if(flag) result++;
}
console.log(result);