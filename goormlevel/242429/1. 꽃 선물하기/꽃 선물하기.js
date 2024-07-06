// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let count = 1;
	let N = 0;
	for await (const line of rl) {
		if(count == 1){
			N = parseInt(line.toString());
		}
		else{
			[a,b] = line.toString().split(" ").map(Number);
			if(a<b){
				console.log("Sunflower");
			}
			else if(a==b){
				console.log("Tulip");
			}
			else{
				console.log("Rose");
			}
		}
		if(count==N){
			rl.close();
		}
		count++;
	}
	
	process.exit();
})();
