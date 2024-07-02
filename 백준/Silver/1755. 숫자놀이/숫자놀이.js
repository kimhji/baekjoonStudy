function Number2String(number){
    var result = [];
    number = number.toString();
    while(number != ""){
        tns = number[0];
        switch(tns){
            case "0":
                result.push("zero");
                break;
            case "1":
                result.push("one");
                break;
            case "2":
                result.push("two");
                break;
            case "3":
                result.push("three");
                break;
            case "4":
                result.push("four");
                break;
            case "5":
                result.push("five");
                break;
            case "6":
                result.push("six");
                break;
            case "7":
                result.push("seven");
                break;
            case "8":
                result.push("eight");
                break;
            case "9":
                result.push("nine");
                break;
            default:
                break;
        }
        number = number.substring(1);
    }
    return result.join(" ");
}


let fs = require("fs");
//let inp = fs.readFileSync("javascriptTest/input.txt").toString().split(" ");
let inp = fs.readFileSync("/dev/stdin").toString().split(" ");
resultList = [];
for(var i =parseInt(inp[0]);i<=parseInt(inp[1]);i++){
    resultList.push([Number2String(i),i]);
}
resultList.sort((a, b) => a[0].localeCompare(b[0]));
printList = resultList.map(row=>row[1]);
var line = [];
for(var i = 0;i<printList.length;i++){
    line.push(printList[i]);
    if(i%10 == 9){
        console.log(line.join(" "));
        line = [];
    }
}
if(line.length > 0){
    console.log(line.join(" "));
    line = [];
}