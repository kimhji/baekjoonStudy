const fs = require("fs");
const numbers = fs.readFileSync("/dev/stdin").toString().trim().split(" ").map(Number);
let result = 0;
numbers.forEach((number) => {
    result+=number;
})
console.log(result);