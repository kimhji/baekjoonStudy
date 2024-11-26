const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

let input = [];

rl.on('line', (line) => {
  input.push(Number(line));
}).on('close', () => {
  const [X, Y] = input;

  if (X > 0 && Y > 0) console.log(1);
  else if (X < 0 && Y > 0) console.log(2);
  else if (X < 0 && Y < 0) console.log(3);
  else if (X > 0 && Y < 0) console.log(4);

  process.exit();
});
