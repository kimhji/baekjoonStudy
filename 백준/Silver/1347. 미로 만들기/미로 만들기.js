const fs = require('fs');
//let input = fs.readFileSync('./input.txt').toString().split('\n');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
var N = parseInt(input[0]);
var path = input[1].split('');
var board = Array.from({ length: 101 }, () => new Array(101).fill('#'));
var maxLoc = [50,50];
var minLoc = [50,50];
var curLoc = [50,50];
board[50][50] = '.';
var dir = 0;
for(var i = 0;i<N;i++){
    if (path[i] == 'F'){
        if(dir == 0){
            curLoc[1] += 1;
            board[curLoc[0]][curLoc[1]] = '.';
            if (maxLoc[1] < curLoc[1]){
                maxLoc[1] = curLoc[1];
            }
        }
        else if(dir == 1){
            curLoc[0] -= 1;
            board[curLoc[0]][curLoc[1]] = '.';
            if (minLoc[0] > curLoc[0]){
                minLoc[0] = curLoc[0];
            }
        }
        else if(dir == 2){
            curLoc[1] -= 1;
            board[curLoc[0]][curLoc[1]] = '.';
            if (minLoc[1] > curLoc[1]){
                minLoc[1] = curLoc[1];
            }
        }
        else if(dir == 3){
            curLoc[0] += 1;
            board[curLoc[0]][curLoc[1]] = '.';
            if (maxLoc[0] < curLoc[0]){
                maxLoc[0] = curLoc[0];
            }
        }
    }
    else if(path[i] == 'R'){
        dir += 1;
        if(dir > 3){
            dir -= 4;
        }
    }
    else if (path[i] == 'L'){
        dir -= 1;
        if(dir<0){
            dir += 4;
        }
    }
}
for(let i = minLoc[1];i<=maxLoc[1];i++){
    var list = [];
    for(let j = minLoc[0];j<=maxLoc[0];j++){
        list.push(board[j][i]);
    }
    console.log(list.join(''));
}