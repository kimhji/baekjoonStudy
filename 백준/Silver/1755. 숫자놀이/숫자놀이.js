function Number2String(number){
    const result = [];
    number = number.toString();
    while(number !== ""){
        const tns = number[0];
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

const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
const start = parseInt(inp[0]);
const end = parseInt(inp[1]);
const resultList = [];

for(let i = start; i <= end; i++){
    resultList.push([Number2String(i), i]);
}

resultList.sort((a, b) => a[0].localeCompare(b[0]));

const printList = resultList.map(row => row[1]);
let line = [];
for(let i = 0; i < printList.length; i++){
    line.push(printList[i]);
    if(i % 10 === 9){
        console.log(line.join(" "));
        line = [];
    }
}
if(line.length > 0){
    console.log(line.join(" "));
}
