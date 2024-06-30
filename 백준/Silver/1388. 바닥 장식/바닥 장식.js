let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest/input.txt").toString().split('\n');
let inp = fs.readFileSync("/dev/stdin").toString().split('\n');
var [r,c] = inp[0].split(' ').map(Number);

var beforeHo = false;
var beforeVer = new Array(c).fill(false);
let num = 0;
for(let i = 1; i<=r;i++){
    for(let j = 0;j<c;j++){
        if(inp[i][j] == "-"){
            beforeVer[j] = false;
            if(!beforeHo){
                num += 1;
                beforeHo = true;
            }
        }
        else{
            beforeHo = false;
            if(!beforeVer[j]){
                num += 1;
                beforeVer[j] = true;
            }
        }
    }
    beforeHo = false;
}
console.log(num);