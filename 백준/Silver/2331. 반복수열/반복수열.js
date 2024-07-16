const fs = require("fs");
//let inp = fs.readFileSync("Day1/input").toString().trim().split(" ");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
A = inp[0];
P = inp[1];

dict = {};
tns = A.toString();
idx = 0;
while(!(tns in dict)){
    dict[tns] = idx;
    s = 0;
    check = tns.split("");
    check.forEach(item =>{
        s += parseInt(item)**P;
    })
    tns = s.toString();
    idx += 1;
}
console.log(dict[tns]);
