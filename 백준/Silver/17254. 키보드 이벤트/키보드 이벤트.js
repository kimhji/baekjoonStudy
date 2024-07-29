const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let [N, M] = inp[0].split(" ").map(Number);
let inpSort = [];
for(let i=1;i<=M;i++){
    let tns=inp[i].trim().split(" ");
    inpSort.push([parseInt(tns[0]),parseInt(tns[1]),tns[2]]);
}
inpSort.sort((a,b)=>{
    if(a[1]!=b[1]) return a[1]-b[1];
    else{
        return a[0]-b[0];
    }
})
let result = "";
inpSort.forEach(item=>{
    result+=item[2];
})
console.log(result);