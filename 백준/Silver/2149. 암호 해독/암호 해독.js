const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let key = inp[0].trim().split("");
let keyAndIdx = [];
let idx = 0;
key.forEach(item=>{
    keyAndIdx.push([idx,item]);
    idx++;
})
keyAndIdx.sort((a,b)=>{
    if(a[1]>b[1]) return 1;
    else if(a[1]==b[1]) return 0;
    else return -1; 
})
idx = 0;
var len = Math.floor(inp[1].length/keyAndIdx.length);
var idx1 = 0
inp[1].split("").forEach(item=>{
    if(idx >= len){
        idx %= len;
        idx1++;
    }
    keyAndIdx[idx1].push(item);
    idx++;
})
keyAndIdx.sort((a,b)=>{
    return a[0]-b[0]
})
let result = "";

for(var i =2;i<keyAndIdx[0].length;i++){
    keyAndIdx.forEach(item=>{
        result += item[i];
    })
}

console.log(result);