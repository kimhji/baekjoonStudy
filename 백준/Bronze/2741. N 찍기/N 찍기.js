const fs =require("fs");
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
for(let i =1;i<=N;i++){
    console.log(i);
}