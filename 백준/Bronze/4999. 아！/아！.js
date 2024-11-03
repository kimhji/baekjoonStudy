const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const state = inp[0].trim().length;
const req = inp[1].trim().length;
if(state >= req){
    console.log("go");
}
else{
    console.log("no");
}