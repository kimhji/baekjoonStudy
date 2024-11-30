const fs = require("fs");
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
let result = 1;
for(let i=1;i<=N;i++){
    result*=i;
}
console.log(result);