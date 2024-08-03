//import { readFileSync } from "fs";
const fs = require("fs");
//let inp = readFileSync("input.txt").toString().trim().split("");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("");
let need_Open = 0;
let need_Close = 0;
let L = inp.length;
let stack = 0;
for(let cycle = 0;cycle<L;cycle++){
    if(inp[cycle]==="(") stack++;
    else if(stack>0)stack--;
    else need_Open++;
}
stack = 0;
for(let cycle = L-1;cycle>=0;cycle--){
    if(inp[cycle]===")") stack++;
    else if(stack>0){stack--;}
    else need_Close++;
}
console.log(need_Close+need_Open);