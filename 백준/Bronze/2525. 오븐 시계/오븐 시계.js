const fs = require("fs");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
var curT = inp[0].split(" ").map(Number);
var spend = parseInt(inp[1]);

curT[1]+=spend;
var h = Math.floor(curT[1]/60);
curT[1] %= 60;
curT[0] += h;
curT[0] %=24;
console.log(curT.join(" "));