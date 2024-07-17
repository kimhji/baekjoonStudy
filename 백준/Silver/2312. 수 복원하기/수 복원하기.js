const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let N = parseInt(inp[0]);
for(let cycle = 1;cycle<=N;cycle++){
    var number = parseInt(inp[cycle]);
    var dict = {};
    var div = 2;
    while (div <= number && number > 1){
        if(number%div==0){
            if(div in dict){
                dict[div] +=1;
            }
            else{
                dict[div] = 1;
            }
            number /= div;
            div = 2;
        }
        else{
            div += 1;
        }
    }
    arr = Object.entries(dict);
    arr.sort((a,b)=>{
        return a[0]-b[0];
    })
    arr.forEach(item=>{
        console.log(item.join(" "));
    })
}