let fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split('');
let inp = fs.readFileSync("/dev/stdin").toString().trim().split('');

var sumArray = [0];
var tns = 0;
inp.forEach(word =>{
    tns += parseInt(word)
    sumArray.push(tns)
});
let result = 0;
for(let i = inp.length;i>0;i--){
    if(i%2 != 0){
        continue;
    }
    jCount = inp.length - i;
    let isFound = false;
    for(let j = 0;j<=jCount;j++){
        if(sumArray[i+j]-sumArray[parseInt((i/2).toFixed())+j] == sumArray[parseInt((i/2).toFixed())+j] - sumArray[j]){
            isFound = true;
            break;
        }
    }
    if(isFound){
        result = i;
        break;
    }
}
console.log(result);