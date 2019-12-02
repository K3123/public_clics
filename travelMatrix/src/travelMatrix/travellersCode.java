package travelMatrix;

import java.util.*;
import java.io.*;
import java.sql.*;
import java.net.*;

public class travellersCode {

	public static int travellersCoder( char[][] array, int x, int y, int largest) {
		int sizex = array.length;
		int sizey = array[0].length;
		if ( x < sizex && y < sizey) {
			System.out.println(x + " " + y);
			if(array[x][y] - 48 == 2) {
				if ( x - 1 >= 0 ) {
					System.out.println("Yes x - 1 = " + x +  "- 1 was called ");
					if(array[x-1][y] - 48 == 2) {
					 largest = Math.max(largest, travellersCoder(array,x-1,y,largest+=2));
					}else {
						return largest+=1;
					}
			    }
				if ( x + 1 < sizex ) {
					System.out.println("Yes x + 1 =  " + x +  " + 1 was called ");
					if(array[x+1][y] - 48 == 2) {
						largest = Math.max(largest,travellersCoder(array,x+=1,y,largest+=1));
					}else {
						return largest+=1;
					}
			    }

				if ( y - 1 >= 0 ) {
					System.out.println("Yes y - 1 = " + y +  " 1 was called ");
					if(array[x][y-1] - 48 == 2) {
						largest = Math.max(largest, travellersCoder(array,x,y-1,largest+=1));
					}else {
						return largest+=1;
					}
				}
				if ( y + 1 < sizey ) {
					System.out.println("Yes y + 1 = " + y +  "+ 1 was called ");
					if(array[x][y+1] - 48 == 2) {
					largest = Math.max(largest,travellersCoder(array,x,y+=1,largest+=1));
					}else {
					 return largest+=1;
			    }
		     }
			 if(array[x][y] - 48  == 1 ) {
			  return largest;	
			}
		 }
		}
		return Math.max(0, largest); 
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] values = new char[2];
		values = br.readLine().replace(" ", "").toCharArray();
		int xvalue = (int) values[0] - 48;
		int yvalue = (int) values[1] - 48;
		
		char[][] arrau1 = new char[xvalue][yvalue];
		
		
		for(int x = 0; x < xvalue; x++ ) {
		    arrau1[x] = br.readLine().replace(" ", "").toCharArray();
		}
		int largest = 0;
        for(int x = 0; x < xvalue; x++ ) {
        	for( int y = 0; y < yvalue; y++ ) {
        		largest = Math.max(largest,travellersCoder(arrau1,x,y,largest));
        	}
        }
        
        System.out.println( largest);
        
	}

}
