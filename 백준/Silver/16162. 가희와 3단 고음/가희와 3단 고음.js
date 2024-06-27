let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest\\input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
if(inp<2) return;
var [N, A, D] = inp[0].split(' ').map(Number);
var nextNote = A;
var result = 0;
var partici = inp[1].split(' ').map(Number);
partici.forEach(item =>{
    if(item == nextNote){
        result += 1;
        nextNote += D;
    }
});
console.log(result);