const fs = require('fs');
const input = fs.readFileSync('/dev/stdin').toString().trim().split('\n');

const [N, M, V] = input[0].split(' ').map(Number);

let edges = [];
for (let i = 1; i <= M; i++) {
    const [a, b] = input[i].split(' ').map(Number);
    edges.push([a, b]);
    edges.push([b, a]);
}

edges.sort((a, b) => a[0] - b[0] || a[1] - b[1]);

const graph = Array.from(Array(N + 1), () => []);

for (const [a, b] of edges) {
    graph[a].push(b);
    graph[b].push(a);
}

graph.forEach(adj => adj.sort((a, b) => a - b));

let result1 = [];
let result2 = [];

function dfs(node, visited) {
    if (visited[node]) return;
    visited[node] = true;
    result1.push(node);
    for (const next of graph[node]) {
        if (!visited[next]) dfs(next, visited);
    }
}

function bfs(start) {
    const queue = [start];
    const visited = Array(N + 1).fill(false);
    visited[start] = true;
    while (queue.length) {
        const node = queue.shift();
        result2.push(node);
        for (const next of graph[node]) {
            if (!visited[next]) {
                visited[next] = true;
                queue.push(next);
            }
        }
    }
}

dfs(V, Array(N + 1).fill(false));
bfs(V);

console.log(result1.join(' '));
console.log(result2.join(' '));
