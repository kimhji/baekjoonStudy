//import { readFileSync } from "fs";
const fs = require("fs");
//let inp = readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let N = parseInt(inp[0]);
let result=0;
let Board = inp[1].trim().split("");
for(let cycle = 1;cycle<N;cycle++){
    if(Board[cycle] === "W"){
        if(Board[cycle-1]==="E") result++;
    }
}
console.log(result);
