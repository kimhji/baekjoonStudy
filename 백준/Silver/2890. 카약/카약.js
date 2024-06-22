const fs = require('fs');
//let input = fs.readFileSync('./input.txt').toString().split('\n');
let input = fs.readFileSync('/dev/stdin').toString().split('\n');
var sp = input[0].split(' ');
let R = parseInt(sp[0]);
let C = parseInt(sp[1]);
let ranks = [0,0,0,0,0,0,0,0,0,0];
var currank = 1;
for(let i = C-2;i>1;i--){
    var teamExist = false;
    for(let j = 1; j<=R;j++){
        if (input[j][i] != '.'){
            let teamId = parseInt(input[j][i]);
            if(ranks[teamId] != 0) continue;
            ranks[teamId] = currank;
            teamExist = true;
        }
    }
    if(teamExist){
        currank += 1;
    }
}
for(let i = 1;i<10;i++){
    if(ranks[i] == 0) continue;
    console.log(ranks[i]);
}
