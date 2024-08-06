//import { readFileSync } from "fs";
const fs = require("fs");
//let inp = readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let [N, C] = inp[0].trim().split(" ").map(Number);
let numb = inp[1].trim().split(" ").map(Number);
let numDict = {};
for(let i = 0;i<N;i++){
    if(numb[i] in numDict)
        numDict[numb[i]][0] += 1;
    else
        numDict[numb[i]] = [1, i];
}

numb.sort((a,b)=>{
    if(numDict[b][0] !== numDict[a][0])
        return numDict[b][0] - numDict[a][0];
    return numDict[a][1] - numDict[b][1];
})
console.log(numb.join(" "));