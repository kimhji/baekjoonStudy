const fs = require('fs');
//let input = fs.readFileSync('./input.txt').toString().split('\n');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
var N = parseInt(input[0]);
var result = new Array(N).fill(0);
var inList = input[1].toString().split(' ');
for(let i=0;i<N;i++){
    num = parseInt(inList[i]);
    var idx = 0;
    while (idx < N && num != 0){
        if(result[idx] == 0){
            num -= 1;
        }
        idx+=1;
    }
    while(result[idx]!=0){
        idx+=1;
    }
    result[idx] = i+1;
}
console.log(result.join(' '));