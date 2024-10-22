const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const N = 20;
let totalScore = 0;
let totalWeight = 0;
for (let inpC = 0; inpC < N; inpC++) {
  const [name, weightString, score] = inp[inpC].trim().split(" ");
  const weight = parseInt(weightString);
  switch (score) {
    case "A+":
      totalScore += weight * 4.5;
      totalWeight += weight;
      break;
    case "A0":
      totalScore += weight * 4.0;
      totalWeight += weight;
      break;
    case "B+":
      totalScore += weight * 3.5;
      totalWeight += weight;
      break;
    case "B0":
      totalScore += weight * 3.0;
      totalWeight += weight;
      break;
    case "C+":
      totalScore += weight * 2.5;
      totalWeight += weight;
      break;
    case "C0":
      totalScore += weight * 2.0;
      totalWeight += weight;
      break;
    case "D+":
      totalScore += weight * 1.5;
      totalWeight += weight;
      break;
    case "D0":
      totalScore += weight * 1;
      totalWeight += weight;
      break;
    case "F":
      totalScore += weight * 0;
      totalWeight += weight;
      break;
  }
}
console.log(totalScore / totalWeight);
