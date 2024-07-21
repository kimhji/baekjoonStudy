const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim();
let inp = fs.readFileSync("/dev/stdin").toString().trim();
let numbers = inp.split("");
curNumber = 1;
var numberStr = curNumber.toString();
numbers.forEach(item=>{
    while(numberStr.indexOf(item) == -1){
        curNumber +=1;
        numberStr = curNumber.toString();
    }
    var curidx = numberStr.indexOf(item)+1;
    numberStr = numberStr.substring(curidx);
})
console.log(curNumber);
