const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");

let n = parseInt(inp[0].trim());
let idx = 1;
let senario = 1;

while(n!=0){
    let nameList = [];
    let nameSet = {};
    for(let cycle = 0;cycle<n;cycle++){
        nameList.push(inp[idx].trim());
        idx++;
    }
    for(let cycle = 0;cycle<2*n-1;cycle++){
        let curNum = parseInt(inp[idx].trim().split(" ")[0]);
        if(curNum in nameSet)
            nameSet[curNum]++;
        else nameSet[curNum] = 1;
        idx++;
    }
    let valid = Object.entries(nameSet).filter(data=>{return data[1]<2}).map(data=>data[0]);
    valid.forEach(item=>{
        console.log(senario,nameList[parseInt(item)-1]);
    })
    n = parseInt(inp[idx].trim());
    idx++;
    senario++;
}