let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest/input.txt").toString().split(" ");
let inp = fs.readFileSync("/dev/stdin").toString().split(" ");

var [N, M] = inp.map(Number);
let board = Array.from({length : N}, ()=>new Array(M).fill(0));
board[0][0] = 1;
var loc = [0,0];
var dir = 0;
var isEnd = false;
var turn = 0;
while(!isEnd){
    if(dir == 1){
        if(loc[1]+1 < M && board[loc[0]][[loc[1]+1]] == 0){
            loc[1] += 1;
            board[loc[0]][loc[1]] = 1;
            trun = 0;
        }
        else{
            dir += 1;
            turn += 1;
        }
    }
    else if(dir == 2){
        if(loc[0] > 0 && board[loc[0]-1][[loc[1]]] == 0){
            loc[0] -= 1;
            board[loc[0]][loc[1]] = 1;
            turn = 0;
        }
        else{
            dir += 1;
            turn += 1;
        }
    }
    else if(dir == 3){
        if(loc[1] > 0 && board[loc[0]][loc[1]-1] == 0){
            loc[1] -= 1;
            board[loc[0]][loc[1]] = 1;
            turn = 0;
        }
        else{
            dir = 0;
            turn += 1;
        }
    }
    else if(dir == 0){
        if(loc[0]+1 < N && board[loc[0]+1][[loc[1]]] == 0){
            loc[0] += 1;
            board[loc[0]][loc[1]] = 1;
            turn = 0;
        }
        else{
            dir += 1;
            turn += 1;
        }
    }
    if(turn == 4){
        isEnd = true;
    }
}
console.log(loc.join(" "));