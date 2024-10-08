const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = parseInt(inp[0].trim());
const pizzaObj = { "1/2": 0, "1/4": 0, "3/4": 0 };
for (let check = 1; check <= N; check++) {
  pizzaObj[inp[check].trim()]++;
}

let result = 0;

result += Math.floor(pizzaObj["1/2"] / 2);
pizzaObj["1/2"] %= 2;

const tnsQuaters = Math.min(pizzaObj["3/4"], pizzaObj["1/4"]);
result += tnsQuaters;
pizzaObj["1/4"] -= tnsQuaters;
pizzaObj["3/4"] -= tnsQuaters;

const tnsHalfAndQuater2 = Math.min(
  pizzaObj["1/2"],
  Math.floor(pizzaObj["1/4"] / 2)
);
pizzaObj["1/4"] -= tnsHalfAndQuater2 * 2;
pizzaObj["1/2"] -= tnsHalfAndQuater2;
result += tnsHalfAndQuater2;

result += Math.floor(pizzaObj["1/4"] / 4);
pizzaObj["1/4"] %= 4;

result += pizzaObj["1/4"] ? 1 : 0 + pizzaObj["3/4"] + pizzaObj["1/2"];
console.log(result);
