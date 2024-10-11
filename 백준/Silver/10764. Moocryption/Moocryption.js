const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let n, m;
const board = [];
const dx = [0, -1, -1, -1, 0, 1, 1, 1];
const dy = [1, 1, 0, -1, -1, -1, 0, 1];

function recover(x, y) {
    const a = String.fromCharCode('A'.charCodeAt(0) + x);
    const b = String.fromCharCode('A'.charCodeAt(0) + y);
    let ret = 0;

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            if (board[i][j] === a) {
                for (let k = 0; k < 8; k++) {
                    let ok = true;
                    let nx = i;
                    let ny = j;

                    for (let q = 0; q < 2; q++) {
                        nx += dx[k];
                        ny += dy[k];
                        if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                            if (board[nx][ny] !== b) ok = false;
                        } else {
                            ok = false;
                        }
                    }

                    if (ok) ret++;
                }
            }
        }
    }
    return ret;
}

rl.on('line', (line) => {
    if (!n && !m) {
        const dimensions = line.split(' ').map(Number);
        n = dimensions[0];
        m = dimensions[1];
    } else {
        board.push(line.trim());
        if (board.length === n) {
            let ans = 0;
            for (let i = 0; i < 26; i++) {
                if (i === 'M'.charCodeAt(0) - 'A'.charCodeAt(0)) continue;
                for (let j = 0; j < 26; j++) {
                    if (i === j || j === 'O'.charCodeAt(0) - 'A'.charCodeAt(0)) continue;
                    ans = Math.max(ans, recover(i, j));
                }
            }
            console.log(ans);
            rl.close();
        }
    }
});
