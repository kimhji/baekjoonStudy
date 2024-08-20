const fs = require("fs");
//let number = parseInt(fs.readFileSync("input.txt").toString().trim());
let number = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
if(number!==1) console.log(1);
else console.log(2);