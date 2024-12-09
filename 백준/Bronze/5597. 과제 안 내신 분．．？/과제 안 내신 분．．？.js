const fs = require("fs");
const numbers = fs.readFileSync("/dev/stdin").toString().trim().split("\n").map(Number);
const arr = new Array(31).fill(false);
numbers.forEach(number=>{
    arr[number]=true;
});
for(let i = 1;i<=30;i++){
    if(!arr[i]){
        console.log(i);
    }
}