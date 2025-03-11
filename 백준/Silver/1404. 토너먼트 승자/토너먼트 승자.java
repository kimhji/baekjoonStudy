import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().trim().split(" ");
		double[][] winPer = new double[8][8];
		int no = 0;
		int count = 1;
		
		for(int i =0;i<28;i++) {
			double tnsPer = Double.parseDouble(line[i]);
			winPer[no][count] = tnsPer/100;
			winPer[count][no] = 1-tnsPer/100;
			count++;
			if (count>=8) {
				no++;
				count = no+1;
			}
		}
		
		double[] ranks = new double[8];
		for(int round = 1;round<=3;round++) {
			switch (round) {
			case 1:
				for(int cycle = 0;cycle<4;cycle++) {
					ranks[2*cycle] = winPer[2*cycle][2*cycle+1];
					ranks[2*cycle+1] = winPer[2*cycle+1][2*cycle];
				}
				break;
			case 2:
				double[] tnsRanks1 = new double[8];
				tnsRanks1[0] = ranks[0]*(ranks[2]*winPer[0][2]+ranks[3]*winPer[0][3]);
				tnsRanks1[1] = ranks[1]*(ranks[2]*winPer[1][2]+ranks[3]*winPer[1][3]);
				tnsRanks1[2] = ranks[2]*(ranks[0]*winPer[2][0]+ranks[1]*winPer[2][1]);
				tnsRanks1[3] = ranks[3]*(ranks[0]*winPer[3][0]+ranks[1]*winPer[3][1]);
				tnsRanks1[4] = ranks[4]*(ranks[6]*winPer[4][6]+ranks[7]*winPer[4][7]);
				tnsRanks1[5] = ranks[5]*(ranks[6]*winPer[5][6]+ranks[7]*winPer[5][7]);
				tnsRanks1[6] = ranks[6]*(ranks[4]*winPer[6][4]+ranks[5]*winPer[6][5]);
				tnsRanks1[7] = ranks[7]*(ranks[4]*winPer[7][4]+ranks[5]*winPer[7][5]);
				
				ranks = tnsRanks1;

				break;
			case 3:
				double[] tnsRanks = new double[8];
				tnsRanks[0] = ranks[0]*(ranks[4]*winPer[0][4]+ranks[5]*winPer[0][5]+ranks[6]*winPer[0][6]+ranks[7]*winPer[0][7]);
				tnsRanks[1] = ranks[1]*(ranks[4]*winPer[1][4]+ranks[5]*winPer[1][5]+ranks[6]*winPer[1][6]+ranks[7]*winPer[1][7]);
				tnsRanks[2] = ranks[2]*(ranks[4]*winPer[2][4]+ranks[5]*winPer[2][5]+ranks[6]*winPer[2][6]+ranks[7]*winPer[2][7]);
				tnsRanks[3] = ranks[3]*(ranks[4]*winPer[3][4]+ranks[5]*winPer[3][5]+ranks[6]*winPer[3][6]+ranks[7]*winPer[3][7]);
				tnsRanks[4] = ranks[4]*(ranks[0]*winPer[4][0]+ranks[1]*winPer[4][1]+ranks[2]*winPer[4][2]+ranks[3]*winPer[4][3]);
				tnsRanks[5] = ranks[5]*(ranks[0]*winPer[5][0]+ranks[1]*winPer[5][1]+ranks[2]*winPer[5][2]+ranks[3]*winPer[5][3]);
				tnsRanks[6] = ranks[6]*(ranks[0]*winPer[6][0]+ranks[1]*winPer[6][1]+ranks[2]*winPer[6][2]+ranks[3]*winPer[6][3]);
				tnsRanks[7] = ranks[7]*(ranks[0]*winPer[7][0]+ranks[1]*winPer[7][1]+ranks[2]*winPer[7][2]+ranks[3]*winPer[7][3]);
				
				ranks = tnsRanks;
				break;
			}
		}
		for(int cycle = 0;cycle<8;cycle++) {
			System.out.print(ranks[cycle]);
			if(cycle<7) {
				System.out.print(" ");
			}
		}
	}
}