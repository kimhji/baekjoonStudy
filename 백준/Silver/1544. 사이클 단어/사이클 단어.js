let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest\\input.txt").toString().split('\n');
let inp = fs.readFileSync("/dev/stdin").toString().split('\n');

var n = parseInt(inp[0]);
var stringList = [];
for(var i=0;i<n;i++){
    stringList.push(inp[1+i].trim());
}

var result = 0;
var resultBag = [];

stringList.forEach(stringItem=>{
    var isNew = true;
    var checkBag = [];
    for(var j = 0;j<stringItem.length;j++){
        var c = stringItem.substring(0, j);
        checkBag.push(stringItem.substring(j)+c);
    }
    resultBag.forEach(bagItem =>{
        if(checkBag.includes(bagItem)){
            isNew = false;
        }
    })
    if(isNew){
        result += 1;
        resultBag.push(stringItem);
    }
})

console.log(result);