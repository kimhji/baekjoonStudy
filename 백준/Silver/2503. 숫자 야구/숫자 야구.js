let ableCase = [];

function find_baseball(num, strike, ball){
    var tnsAble = [];
    ableCase.forEach(item=>{
        if(check(item, num, strike, ball)){
            tnsAble.push(item);
        }
    })

    ableCase = tnsAble;
}

function check(orig, comp, strike, ball){
    var tnsStrike = 0;
    var tnsBall = 0;
    if(orig[0] == comp[0]){
        tnsStrike += 1;
    }
    else if(comp.indexOf(orig[0])!=-1){
        tnsBall += 1;
    }

    if(orig[1] == comp[1]){
        tnsStrike += 1;
    }
    else if(comp.indexOf(orig[1])!=-1){
        tnsBall += 1;
    }

    if(orig[2] == comp[2]){
        tnsStrike += 1;
    }
    else if(comp.indexOf(orig[2])!=-1){
        tnsBall += 1;
    }

    if(tnsBall == ball && tnsStrike == strike){
        return true;
    }
    return false;
}

function add(tns, count){
    if(count == 0){
        ableCase.push(tns);
        return;
    }
    for(var x = 1;x<10;x++){
        if(tns.indexOf(x.toString())!=-1) continue;
        var tnsCase = [].concat(tns);
        tnsCase.push(x.toString());
        add(tnsCase, count-1);
    }
}

function init(){
    ableCase = [];
    add([],3);
}


init();
const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
var N = parseInt(inp[0].trim());
for(let check = 1;check<=N;check++){
    var line = inp[check];
    var numbers = line.split(" ");
    find_baseball(numbers[0].split(""),parseInt(numbers[1]),parseInt(numbers[2]));
}
console.log(ableCase.length);