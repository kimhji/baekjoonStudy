const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().split("\n");
const N = parseInt(inp[0].trim());
let guitars = [];
for (let input = 1; input <= N; input++) {
  let name = inp[input].trim();
  let len = name.length;
  let sumOfNumber = 0;
  name.split("").forEach((word) => {
    if (word >= "0" && word <= "9") {
      sumOfNumber += parseInt(word);
    }
  });
  guitars.push([name, len, sumOfNumber]);
}
guitars.sort((a, b) => {
  if (a[1] !== b[1]) {
    return a[1] - b[1];
  } else if (a[2] !== b[2]) {
    return a[2] - b[2];
  } else {
    if (a[0] <= b[0]) return -1;
    else return 1;
  }
});
guitars.forEach((guitar) => {
  console.log(guitar[0]);
});
