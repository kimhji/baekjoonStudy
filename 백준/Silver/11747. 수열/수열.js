const readline = require("readline");

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout,
});

const inp = [];
rl.on("line", (line) => {
  inp.push(line.trim());
});

rl.on("close", () => {
  const N = parseInt(inp[0]);
  let numbers = [];
  let idx = 1;
  while (idx < inp.length) {
    numbers.push(...inp[idx++].split(" ").map(Number));
  }

  let result = -1;
  let IsExist = true;
  while (IsExist) {
    result++;
    IsExist = false;
    const curNumber = result.toString();
    const count = curNumber.length;
    for (let cycle = count - 1; cycle < N; cycle++) {
      for (let check = count - 1; check >= 0; check--) {
        if (numbers[cycle - check] != curNumber[count - 1 - check]) {
          break;
        }
        if (check === 0) {
          IsExist = true;
        }
      }
      if (IsExist) break;
    }
  }

  console.log(result);
});
