const fs = require("fs");
// let inp = fs.readFileSync("input.txt").toString().split("\n");
let inp = fs.readFileSync("/dev/stdin").toString().split("\n");
let idx = 0;

while (true) {
    let num = inp[idx].split(" ").map(Number);
    idx++;
    if (num[0] === 0 && num[1] === 0) break;

    let dict = new Map();
    
    for (let i = 0; i < num[0]; i++) {
        let partici = inp[idx].split(" ").map(Number);
        idx++;
        partici.forEach(person => {
            if (dict.has(person)) {
                dict.set(person, dict.get(person) + 1);
            } else {
                dict.set(person, 1);
            }
        });
    }

    let result = Array.from(dict.entries());
    result.sort((a, b) => b[1] - a[1]);

    let maxV = result[0][1];
    let second = result.filter(item => item[1] != maxV);

    if (second.length > 0) {
        let secondMaxV = second[0][1];
        let consoleResult = second.filter(item => item[1] === secondMaxV).map(a => a[0]);
        consoleResult.sort((a, b) => a - b);
        console.log(consoleResult.join(" "));
    } else {
        console.log("");
    }
}
