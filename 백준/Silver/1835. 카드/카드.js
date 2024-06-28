let fs = require("fs");
//let inp = parseInt(fs.readFileSync("javascriptTest\\input.txt").toString());
let inp = parseInt(fs.readFileSync("/dev/stdin").toString());

var cards = new Array(inp);
for(var i = 0;i<inp;i++){
    cards[i] = i;
}
var num = 1;
var onTable = [];
while(cards.length != 0){
    for(var j = 0;j<num;j++){
        var c = cards.shift();
        cards.push(c);
    }
    onTable.push(cards.shift());
    num += 1;
}
var result = new Array(inp).fill(0);
var idx = 1;
onTable.forEach(item =>{
    result[item] = idx
    idx += 1
})

console.log(result.join(' '));