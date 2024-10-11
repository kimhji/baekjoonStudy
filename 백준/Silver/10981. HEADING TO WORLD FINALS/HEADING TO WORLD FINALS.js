const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const [N, K] = inp[0].trim().split(" ").map(Number);
const universityMap = new Map();
for (let check = 1; check <= N; check++) {
  const [university, teamName, solved, penalty] = inp[check].trim().split(" ");
  const solvedInt = parseInt(solved);
  const penaltyInt = parseInt(penalty);
  const currentEntry = universityMap.get(university);
  if (
    !currentEntry ||
    currentEntry.solvedInt < solvedInt ||
    (currentEntry.solvedInt === solvedInt &&
      currentEntry.penaltyInt > penaltyInt)
  ) {
    universityMap.set(university, { teamName, solvedInt, penaltyInt });
  }
}
const dataArr = [];
const valueIterables = universityMap.values();
let nextValue = valueIterables.next().value;
while (nextValue) {
  dataArr.push(nextValue);
  nextValue = valueIterables.next().value;
}
dataArr.sort((a, b) => {
  if (a.solvedInt !== b.solvedInt) return b.solvedInt - a.solvedInt;
  return a.penaltyInt - b.penaltyInt;
});
for (let printData = 0; printData < K; printData++) {
  console.log(dataArr[printData].teamName);
}
