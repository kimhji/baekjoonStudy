let fs = require("fs");
//let inpS = fs.readFileSync("coregistrationTest/input.txt").toString().trim();
let inpS = fs.readFileSync("/dev/stdin").toString().trim();
let inp = inpS.split("").map(Number);
// let x = 0;
// for(var c= 1;c<=parseInt(inpS);c++){
//     if(c.toString().split("").includes('4')){
//         continue;
//     }
//     x++;
// }
// console.log(x);
var result = 0;
for(var i = 0;i<inp.length;i++){
    result *= 9;
    if(inp[i]<4){
        result += inp[i];
    }
    else{
        result += inp[i]-1;
    }
}
console.log(result);