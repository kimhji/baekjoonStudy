const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let [R, C] = inp[0].trim().split(" ").map(Number);
let board = [];
for(let i=0;i<R;i++){
    board.push(inp[i+1].trim().split(""));
}
var minV = 64;
for(let i=0;i<=R-8;i++){
    for(let j =0;j<=C-8;j++){
        var firstW = 0;
        var firstB = 0;
        for(let rCheck = 0;rCheck<8;rCheck++){
            for(let cCheck = 0;cCheck<8;cCheck++){
                if((rCheck+cCheck)%2 == 0){
                    if(board[i+rCheck][j+cCheck]=="W"){
                        firstB += 1;
                    }
                    else{
                        firstW += 1;
                    }
                }
                else{
                    if(board[i+rCheck][j+cCheck]=="B"){
                        firstB += 1;
                    }
                    else{
                        firstW += 1;
                    }
                }
            }
        }
        if(minV > firstB){
            minV = firstB;
        }
        if(minV > firstW){
            minV = firstW;
        }
    }
}
console.log(minV);