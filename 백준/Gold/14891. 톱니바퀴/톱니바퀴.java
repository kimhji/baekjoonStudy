import java.util.*;
import java.io.*;

class Tobni{
	boolean[] isN = new boolean[8];
	int idx_12 = 0;
	Tobni leftTobni = null;
	Tobni rightTobni = null;
	boolean checked = false;
	
	void init(String str) {
		int i = 0;
		for(char one: str.trim().toCharArray()) {
			if(one == '1') {
				this.isN[i++] = false;
			}
			else {
				this.isN[i++] = true;
			}
		}
	}
	
	void turn(int dir) {
		this.checked = true;
		if(this.leftTobni != null && !this.leftTobni.checked && (this.leftTobni.getRightSideIsN()^this.getLeftSideIsN())) {
			this.leftTobni.turn(dir*(-1));				
		}
		if(this.rightTobni != null && !this.rightTobni.checked && (this.rightTobni.getLeftSideIsN()^this.getRightSideIsN())) {
			this.rightTobni.turn(dir*(-1));				
		}
		if(dir == -1) {
			this.idx_12++;
			this.idx_12 %= 8;
		}
		else {
			this.idx_12 += 7;
			this.idx_12 %= 8;
		}
	}
	
	boolean getLeftSideIsN() {
		int i = this.idx_12 +6;
		i %= 8;
		
		return this.isN[i];
	}
	boolean getRightSideIsN() {
		int i = this.idx_12 +2;
		i %= 8;
		
		return this.isN[i];
	}
}

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Tobni[] tobnis = new Tobni[4];
        for(int i = 0;i<4;i++) {
        	tobnis[i] = new Tobni();
        	tobnis[i].init(br.readLine());
        	
        	if(i>0) {
        		tobnis[i].leftTobni = tobnis[i-1];
        		tobnis[i-1].rightTobni = tobnis[i];
        	}
        }
        int N = Integer.parseInt(br.readLine().trim());
        for(int cycle = 0;cycle<N;cycle++) {
        	String[] line = br.readLine().trim().split(" ");
        	int idx = Integer.parseInt(line[0])-1;
        	int dir = Integer.parseInt(line[1]);
        	
        	tobnis[idx].turn(dir);
        	for(int init = 0;init<4;init++) {
        		tobnis[init].checked = false;
        	}
        }
        int result = 0;
        for(int x = 0;x<4;x++) {
        	if(!tobnis[x].isN[tobnis[x].idx_12])
        		result += Math.pow(2, x);
        }
        System.out.println(result);
    }
}