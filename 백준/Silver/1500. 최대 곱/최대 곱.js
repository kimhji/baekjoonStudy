function solution(value, left, c, pre){
    if (c == 1){
        var curVal = value * left;
        if (maxV < curVal){
            maxV = curVal;
        }
        return;
    }
    
    for(var i = pre; i<= left/c;i++){
        solution(value*i, left-i, c-1, i);
    }
    return;
}

let fs = require("fs");
//let inp = fs.readFileSync('./input.txt').toString().split('\n');
let inp = fs.readFileSync('/dev/stdin').toString().split('\n');
var [S, K] = inp[0].split(' ').map(Number);
let maxV = 1;
solution(1, S, K, 1);
console.log(maxV.toString());