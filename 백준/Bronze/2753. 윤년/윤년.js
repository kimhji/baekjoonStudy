const fs = require("fs");
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());
if(N%400===0){
    console.log(1);
}
else if(N%100===0){
    console.log(0);
}
else if(N%4===0){
    console.log(1);
}
else{
    console.log(0);
}