// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	
	var N = parseInt(rl[0]);
	for(let i = 1;i<=N;i++){
		console.log('*'*i);
	}
	for await (const line of rl) {
		var N = parseInt(line);
		for(let i = 1;i<=N;i++){
			var p = "";
			for(let j = 0; j<i;j++){
				p += "*";
			}
			console.log(p);
		}
		rl.close();
	}
	
	process.exit();
})();
