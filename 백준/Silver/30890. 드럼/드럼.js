const fs = require("fs");
const [L, R] = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);
let checkL=1;
let checkR=1;
let result = [];
while(checkL<=L&&checkR<=R){
    if(checkL>L){
        checkR++;
        result.push(2);
        continue;
    }
    if(checkR>R){
        checkL++;
        result.push(1);
        continue;
    }
    
    if(checkR/R===checkL/L){
        checkR++;
        checkL++;
        result.push(3);
    }
    else if(checkR/R>checkL/L){
        checkL++;
        result.push(1);
    }
    else{
        checkR++;
        result.push(2);
    }
}
console.log(result.join(""));