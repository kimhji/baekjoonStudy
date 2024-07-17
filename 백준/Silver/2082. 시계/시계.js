function ableNum(r,c){
    if(r==0 && c == 0)
        return [0,2,3,4,5,6,7,8,9];
    else if (r == 1&& c==0)
        return [0,4,5,6,8,9];
    else if (r==2&&c==0)
        return [0,2,3,4,5,6,8,9];
    else if (r==3&&c==0)
        return [0,2,6,8];
    else if (r==4&&c==0)
        return [0,2,3,5,6,8,9];
    else if (r==0&&c==1)
        return [0,2,3,5,6,7,8,9];
    else if (r==2&&c==1)
        return [2,3,4,5,6,8,9];
    else if (r==4&&c==1)
        return [0,2,3,5,6,8,9];
    else if (r==0&&c==2)
        return [0,1,2,3,4,5,6,7,8,9];
    else if(r==1&&c==2)
        return [0,1,2,3,4,7,8,9];
    else if (r==2&&c==2)
        return [0,1,2,3,4,5,6,7,8,9];
    else if (r==3&&c==2)
        return [0,1,3,4,5,6,7,8,9];
    else if (r==4&&c==2)
        return [0,1,2,3,4,5,6,7,8,9];
    else
        return [];
    
}

function checkNum(inp, r, c){
    var tnsArr = [];
    var arr = [0,1,2,3,4,5,6,7,8,9];
    for(let i = 0;i<3;i++){
        for(let j = 0;j<5;j++){
            if(inp[r+j][c+i]=="#"){
                tnsArr = ableNum(j,i);
                var tA = arr.concat([]);
                arr = [];
                tA.forEach(item=>{
                    if(tnsArr.indexOf(item)!=-1){
                        arr.push(item);
                    }
                })
            }
        }
    }
    if(arr.length>0) return arr[0];
    else return undefined;
}



const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
result = [];
result.push(checkNum(inp,0,0));
result.push(checkNum(inp,0,4));
result.push(checkNum(inp,0,8));

result.push(checkNum(inp,0,12));
console.log(result[0].toString()+result[1].toString()+":"+result[2].toString()+result[3].toString());

