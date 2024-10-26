const fs = require("fs");
// const inp = fs.readFileSync("input.txt").toString().trim().split("\n");
const inp = fs.readFileSync("/dev/stdin").toString().trim().split("\n");
const T = parseInt(inp[0].trim());

for (let i = 1; i <= T; i++) {
    const N = inp[i].trim(); // N을 문자열로 입력받음

    let median = N.split(''); // 문자열을 배열로 변환
    median[0] = '5'; // 첫 번째 자리수를 '5'로 설정
    for (let j = 1; j < median.length; j++) {
        median[j] = '0'; // 나머지 자리는 '0'으로 설정
    }

    const medianValue = BigInt(median.join('')); // median을 문자열로 합쳐 BigInt로 변환

    if (BigInt(N) > medianValue) {
        let temp = median.map(char => String.fromCharCode(57 - char.charCodeAt(0) + 48)); // 비트 반전
        const tempValue = BigInt(temp.join('')); // temp를 문자열로 합쳐 BigInt로 변환
        console.log((medianValue * tempValue).toString()); // 결과 출력
    } else {
        let temp = N.split('').map(char => String.fromCharCode(57 - char.charCodeAt(0) + 48)); // 비트 반전
        const tempValue = BigInt(temp.join('')); // temp를 문자열로 합쳐 BigInt로 변환
        console.log((BigInt(N) * tempValue).toString()); // 결과 출력
    }
}
