function checkTest(puzzle){
    var pre = -1;
    if(puzzle[0] != "1")
        return false;
    if(puzzle[puzzle.length-1] != "2")
        return false;
    for(var i = 0;i<puzzle.length;i++){
        switch(puzzle[i]){
            case "1":
                if(i!=0) return false
                break;
            case "2":
            case "3":
                if(pre != "4" && pre != "6")
                    return false;
                break;
            case "4":
            case "5":
                if(pre != "1" && pre != "3")
                    return false;
                break;
            case "6":
            case "7":
                if(pre != "8"){
                    return false;
                }
                break;
            case "8":
                if(pre != "5" && pre != "7"){
                    return false;
                }
                break;
            default:
                return false;
        }
        pre = puzzle[i];
    }
    return true;
}

const fs = require("fs");
//let inp = fs.readFileSync("input.txt").toString().trim().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let idx = 1;
inp.forEach(line =>{
    var styledString = line.trim();
    if(styledString != "0"){
        if(checkTest(styledString.split(""))){
            console.log(idx+". VALID");
        }
        else{
            console.log(idx+". NOT");
        }
        idx+=1;
    }
})