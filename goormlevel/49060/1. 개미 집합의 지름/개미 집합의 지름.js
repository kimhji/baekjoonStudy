// Run by Node.js
const readline = require('readline');

(async () => {
	let rl = readline.createInterface({ input: process.stdin });
	let count = 0;
	for await (const line of rl) {
		if(count == 0){
			[N, D] = line.toString().trim().split(" ").map(Number);
			
		}
		else if(count == 1){
			let ents = line.toString().trim().split(" ").map(Number);
			ents = ents.sort((a,b)=>{
				return a-b;
			})
			let flag = false;
			let minV = 1000001;
			for(let i = 0;i<N;i++){
				for(let j = 0;j<N;j++){
					if(minV <= i+j) break;
					if(ents[N-1-i]-ents[j] <= D){
						minV = i+j;
					}
				}
			}
			console.log(minV);
			rl.close();
		}
		count++;
	}
	
	process.exit();
})();
