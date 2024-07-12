const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("");
let dict = {}
var N = Math.floor(inp.length/2);
inp.forEach(word=>{
    if(word in dict){
        dict[word] += 1;
    }
    else{
        dict[word] = 1;
    }
})

let dictList = Object.entries(dict).sort((a,b)=>{ 
    if(a[0]>b[0]) return 1;
    else if (a[0]==b[0]) return 0;
    else return -1;
})
let oddCount = 0;
var oddIndex = 0;
for (let i = 0; i<dictList.length;i++){
    if(dictList[i][1]%2 == 1){
        oddCount += 1;
        if(oddCount > 1){
            break;
        }
        oddIndex = i;
    }
}
if(oddCount > 1){
    console.log("I'm Sorry Hansoo");
}
else{
    result = "";
    for(let i = 0;i<dictList.length;i++){
        for(let j = 0;j<Math.floor(dictList[i][1]/2);j++){
            result += dictList[i][0];
        }
    }
    if(oddCount==1){
        result += dictList[oddIndex][0];
    }
    for(let i = dictList.length-1;i>=0;i--){
        for(let j = 0;j<Math.floor(dictList[i][1]/2);j++){
            result += dictList[i][0];
        }
    }
    console.log(result);
}