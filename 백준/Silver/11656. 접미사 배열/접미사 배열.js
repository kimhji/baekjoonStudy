const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim();
let inp = fs.readFileSync("/dev/stdin").toString().trim();
let SubString = [];
for(let cycle = 0;cycle<inp.length;cycle++){
    SubString.push(inp.substring(cycle));
}
SubString.sort();
console.log(SubString.join("\n"));