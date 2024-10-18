const fs = require("fs");

const input = fs.readFileSync("/dev/stdin").toString().trim().split(" ");
let bottles = parseInt(input[0], 10);
let moving_bottles_limit = parseInt(input[1], 10);
let result = 0;
const LENGTH = 24; // 비트 길이
let bit_count = 0;

// 비트 카운트
for (let bit_index = LENGTH - 1; bit_index >= 0; --bit_index) {
    if ((bottles & (1 << bit_index)) > 0) {
        bit_count++;
    }
}

// 물병의 수가 한계보다 많을 경우
if (bit_count > moving_bottles_limit) {
    bit_count = moving_bottles_limit;
    let bit_index = LENGTH - 1;

    // 비트를 줄여나가기
    while (bit_count > 0) {
        if ((bottles & (1 << bit_index--)) > 0) {
            bit_count--;
        }
    }
    bit_index++; // 마지막 비트 인덱스 복원

    // 결과 계산
    while (bit_index >= 0) {
        result |= (1 << bit_index--);
    }

    result = (~bottles & result) + 1; // 필요한 물병 수 계산
}

console.log(result);
