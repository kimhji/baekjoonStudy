const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim();
let inp = fs.readFileSync("/dev/stdin").toString().trim();
let num = parseInt(inp);
if(num%2==1){
    console.log("SK");
}
else{
    console.log("CY");
}