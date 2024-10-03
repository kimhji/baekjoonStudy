function isInThePlanet(loc, planet) {
  return (loc[0] - planet[0]) ** 2 + (loc[1] - planet[1]) ** 2 < planet[2] ** 2;
}

const fs = require("fs");
//const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
let inpIdx = 0;
const T = parseInt(inp[inpIdx++].trim());
for (let cycle = 0; cycle < T; cycle++) {
  const [startX, startY, endX, endY] = inp[inpIdx++]
    .trim()
    .split(" ")
    .map(Number);
  const numOfPlanets = parseInt(inp[inpIdx++].trim());
  const startP = new Set();
  const endP = new Set();
  let count = 0;
  for (let planet = 0; planet < numOfPlanets; planet++) {
    const [x, y, r] = inp[inpIdx++].trim().split(" ").map(Number);
    if (isInThePlanet([startX, startY], [x, y, r])) {
      startP.add(planet);
    }
    if (isInThePlanet([endX, endY], [x, y, r])) {
      endP.add(planet);
    }
  }

  startP.forEach((planet) => {
    if (!endP.has(planet)) count++;
  });

  endP.forEach((planet) => {
    if (!startP.has(planet)) count++;
  });

  console.log(count);
}
