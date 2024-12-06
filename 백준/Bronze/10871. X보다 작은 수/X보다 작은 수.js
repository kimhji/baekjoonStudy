const fs = require("fs");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");

// 입력 데이터가 부족한 경우 처리
if (inp.length < 2) {
    console.error("Invalid input");
    process.exit(1);
}

const [N, X] = inp[0].trim().split(" ").map(Number);
if (isNaN(N) || isNaN(X)) {
    console.error("Invalid N or X");
    process.exit(1);
}

const numbers = inp[1]?.trim().split(" ").map(Number) || [];
if (numbers.length !== N) {
    console.error("Numbers length does not match N");
    process.exit(1);
}

// X보다 작은 수 필터링
const result = numbers.filter((one) => one < X);
console.log(result.join(" "));
