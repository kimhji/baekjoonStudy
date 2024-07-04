class molecule{
    constructor(str){
        this.C = 0;
        this.H = 0;
        this.O = 0;
        var strTns = str.trim().split("");
        var idx = -1;
        strTns.forEach(item=>{
            if(item>="2"&&item<="9"){
                if(idx>0){
                    switch(idx){
                        case 1:
                            this.C += parseInt(item)-1;
                            idx = -1;
                            break;
                        case 2:
                            this.H += parseInt(item)-1;
                            idx = -1;
                            break;
                        case 3:
                            this.O += parseInt(item)-1;
                            idx = -1;
                            break;
                        default:
                            idx = -1;
                            break;
                    }
                }
            }
            else{
                switch(item){
                    case "C":
                        this.C += 1;
                        idx = 1;
                        break;
                    case "H":
                        this.H += 1;
                        idx = 2;
                        break;
                    case "O":
                        this.O += 1;
                        idx = 3;
                        break;
                    default:
                        idx = -1;
                        break;
                }
            }
        })
    }
}
let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest/input.txt").toString().trim().split('=');
let inp = fs.readFileSync("/dev/stdin").toString().trim().split('=');
let left = inp[0].split("+");
let right = inp[1].split("-");

let leftList = [];
let rightList = [];

left.forEach(item=>{
    leftList.push(new molecule(item))
})
right.forEach(item=>{
    rightList.push(new molecule(item))
})

let leftSum={
    C:0,
    H:0,
    O:0
};
let rightSum={
    C:0,
    H:0,
    O:0
};
let result = [0,0,0];
let isfound = false;
for(var i = 1;i<=10;i++){
    for(var j = 1;j<=10;j++){
        for(var k = 1;k<=10;k++){
            leftSum.C = leftList[0].C*i+leftList[1].C*j;
            leftSum.H = leftList[0].H*i+leftList[1].H*j;
            leftSum.O = leftList[0].O*i+leftList[1].O*j;

            rightSum.C = rightList[0].C*k;
            rightSum.H = rightList[0].H*k;
            rightSum.O = rightList[0].O*k;
            if(leftSum.C < rightSum.C || leftSum.H < rightSum.H || leftSum.O < rightSum.O){
                break;
            }
            if(leftSum.C == rightSum.C && leftSum.H == rightSum.H && leftSum.O == rightSum.O){
                result[0] = i;
                result[1] = j;
                result[2] = k;
                isfound = true;
                break;
            }
        }
        if(isfound) break;
    }
    if(isfound) break;
}

console.log(result.join(" "));