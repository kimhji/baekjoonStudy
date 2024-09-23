const fs = require("fs");
//const N = parseInt(fs.readFileSync("input.txt").toString().trim());
const N = parseInt(fs.readFileSync("/dev/stdin").toString().trim());

let count = 1;
const bag = [BigInt(0), BigInt(1)];
while (count < N) {
  const curV = (bag[count] + bag[count - 1]) % BigInt(1000000007);
  bag.push(curV);
  count += 1;
}

let result = bag.pop();
console.log(N === 0 ? 0 : result.toString());
