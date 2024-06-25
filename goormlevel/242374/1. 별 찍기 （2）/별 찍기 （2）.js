// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	for await (const line of rl) {
		var N = parseInt(line);
		for (let i = 0;i<N;i++){
			var p = new Array(N).fill('*');
			for (let j = i;j>0;j--){
				p.pop();
			}
			console.log(p.join(''));
		}
		rl.close();
	}
	
	process.exit();
})();
