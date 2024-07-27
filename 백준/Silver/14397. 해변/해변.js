const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let [r, c] = inp[0].trim().split(" ").map(Number);
let board = [];
for(let i = 1; i<=r;i++){
    let line = [];
    if(i%2==0){
        line.push("/");
    }
    board.push(line.concat(inp[i].trim().split("")));
}
let result = 0;
for(let check1 = 0;check1<r;check1++){
    let isPadding = (board[check1][0] == "/");
    let l = isPadding?c+1:c;
    for(let check2 = 0;check2<l;check2++){
        if(board[check1][check2] == "#"){
            if(check2 != 0 && board[check1][check2-1] == "."){
                result += 1;
            }
            if(check2 != l-1 && board[check1][check2+1] == "."){
                result += 1;
            }
            if(check1 != 0){
                if(isPadding){
                    if(board[check1-1][check2] == "."){
                        result += 1;
                    }
                    if(board[check1-1][check2-1] == "."){
                        result += 1;
                    }
                }
                else{
                    if(board[check1-1][check2] == "."){
                        result += 1;
                    }
                    if(board[check1-1][check2+1] == "."){
                        result += 1;
                    }
                }
            }
            if(check1 != r-1){
                if(isPadding){
                    if(board[check1+1][check2] == "."){
                        result += 1;
                    }
                    if(board[check1+1][check2-1] == "."){
                        result += 1;
                    }
                }
                else{
                    if(board[check1+1][check2] == "."){
                        result += 1;
                    }
                    if(board[check1+1][check2+1] == "."){
                        result += 1;
                    }
                }
            }
        }
    }
}
console.log(result);