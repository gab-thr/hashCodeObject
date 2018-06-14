package hashCodeObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class hashCodeObject {

	private static final String PATH = "C://Users/gabriell.thurnher/Desktop/Stage/Jour 4/hashCode/";
	private static List<Paint> cmd;
	
	public static void main(String[] args) {
		cmd = new ArrayList<Paint>();
		char[][] tab = ReadInput(PATH + "logo.in");
		
		char[][] tabTest = new char[14][80];
				
		for(int i = 0; i < tabTest.length; i++) {
			for (int j = 0; j < 80; j++) {
				tabTest[i][j] = Paint.BLANK;
			}
		}
		
		printTab(tab);
		System.out.println();
		
		
//		// Paints G (max 15)
		//cmd.add(new Line(0,8,0,12));
		//cmd.add(new Line(1,4,1,15));
//		cmd.add(new Line(tabTest,2,2,2,5));
//		cmd.add(new Line(tabTest,2,14,2,15));
//		cmd.add(new Square(tabTest,4,2,1));
		//cmd.add(new Square(5,1,1));	
//		cmd.add(new Erase(tabTest,5,3));
//		cmd.add(new Line(tabTest,7,1,7,3));
//		cmd.add(new Line(tabTest,8,2,8,5));
//		cmd.add(new Line(tabTest,9,4,9,16));
//		cmd.add(new Line(tabTest,8,14,8,17));
//		cmd.add(new Line(tabTest,5,10,5,15));
//		cmd.add(new Square(tabTest,6,17,1));
//		cmd.add(new Line(tabTest,5,19,6,19));
//		//Paints o (max 10)
//		cmd.add(new Line(tabTest,4,24,4,30));
//		cmd.add(new Line(tabTest,5,22,5,25));
//		cmd.add(new Line(tabTest,5,29,5,32));
//		cmd.add(new Square(tabTest,7,22,1));
//		cmd.add(new Square(tabTest,8,24,0));
//		cmd.add(new Line(tabTest,9,22,9,31));
//		cmd.add(new Line(tabTest,8,30,8,32));
//		cmd.add(new Line(tabTest,7,31,7,33));
//		cmd.add(new Line(tabTest,6,30,6,33));
//		//Paints o (max 10)
//		cmd.add(new Line(tabTest,4,38,4,44));
//		cmd.add(new Line(tabTest,5,36,5,39));
//		cmd.add(new Line(tabTest,5,43,5,46));
//		cmd.add(new Square(tabTest,7,46,1));
//		cmd.add(new Square(tabTest,8,44,0));
//		cmd.add(new Line(tabTest,9,37,9,46));
//		cmd.add(new Line(tabTest,8,36,8,38));
//		cmd.add(new Line(tabTest,7,35,7,37));
//		cmd.add(new Line(tabTest,6,35,6,38));
//		//Paints g (max 15)
//		cmd.add(new Line(tabTest,4,52,4,61));
//		cmd.add(new Line(tabTest,5,51,5,54));
//		cmd.add(new Line(tabTest,5,57,5,61));
//		cmd.add(new Square(tabTest,7,60,1));
//		cmd.add(new Square(tabTest,10,60,1));
//		cmd.add(new Square(tabTest,7,51,1));
//		cmd.add(new Erase(tabTest,7,52));
//		cmd.add(new Line(tabTest,9,51,9,58));
//		cmd.add(new Square(tabTest,11,58,0));
//		cmd.add(new Line(tabTest,11,50,11,52));
//		cmd.add(new Line(tabTest,12,51,12,59));
//		cmd.add(new Line(tabTest,13,54,13,56));
//		//Paints l (max 9)
//		cmd.add(new Line(tabTest,1,64,9,64));
//		cmd.add(new Line(tabTest,1,65,9,65));
//		cmd.add(new Line(tabTest,1,66,9,66));
//		//Paints e (max 9)
//		cmd.add(new Line(tabTest,4,71,4,76));
//		cmd.add(new Line(tabTest,5,69,5,72));
//		cmd.add(new Line(tabTest,5,75,5,78));
//		cmd.add(new Line(tabTest,6,68,6,70));
//		cmd.add(new Line(tabTest,6,74,6,79));
//		cmd.add(new Line(tabTest,7,68,7,74));
//		cmd.add(new Line(tabTest,8,68,8,71));
//		cmd.add(new Square(tabTest,8,77,0));
//		cmd.add(new Line(tabTest,9,70,9,78));
		
		
//		findSolutionLine(tab,cmd);
		findSolutionColumn(tab,cmd);
		
		paintTab(tabTest, cmd);		
		
		System.out.println();
		System.out.println("Nombre de coups: " + cmd.size());
		System.out.println();
		
		if (compare(tab, tabTest)==true) {
			System.out.println("Vrai");
		}
		else  {
			System.out.println("Faux");
		}
	}
	
	public static void paintTab(char[][] tab, List<Paint> cmds) {
		for(Paint p: cmds) {
			p.paint(tab);
		}
		
		printTab(tab);
	}
	
    private static char[][] ReadInput(String fileName)
    {     
          char[][] res=null;
         
          try
          {     
                 InputStream ips=new FileInputStream(fileName);
                 InputStreamReader ipsr=new InputStreamReader(ips);
                 BufferedReader br=new BufferedReader(ipsr);
                 String ligne;
                 ligne=br.readLine();
                 if(ligne != null)
                 {
                        String[] xy = ligne.split(" ");
                        int nbLigne = Integer.parseInt(xy[0]);
                        int nbColonne = Integer.parseInt(xy[1]);
                        res = new char[nbLigne][nbColonne];
                       
                        int m = 0;
                        while ((ligne=br.readLine())!=null){
                               for(int i=0 ; i<nbColonne ; i++)
                               {
                                     res[m][i] = ligne.charAt(i);
                               }
                               m++;
                        }
                 }

                 br.close();
          }            
          catch (Exception e){
                 System.out.println(e.toString());
          }
         
          return res;
    }
    
    private static void printTab(char[][] tabs) {
    	for (int i =0; i<tabs.length;i++) {
    		System.out.println(tabs[i]);
    	}

    }
    
    private static boolean compare(char[][] tab, char[][]tab2) {
    	for (int i=0; i<tab.length;i++) {
    		for (int j=0; j<tab[0].length;j++) {
    			if (tab[i][j]!=tab2[i][j]) {
    				System.out.println("Erreur à:" + i + "|"+ j);
    				return false;
    			}
    		}
    	}
		return true;
    }
    
	public static void findSolutionLine(char[][] tab, List<Paint> cmds) {
		for (int row = 0; row<tab.length;row++) {
			findSolutionOneLine(tab[row], row, cmds);
		}
	}
	
	public static void findSolutionOneLine(char[] line, int numLine, List<Paint> cmds) {
		int i=0;
		boolean block = false;
		int startBlock = 0;
		int lenBlock =0;
		
		while(i<line.length) {
			if(line[i]==Paint.PAINT) {
				if(block == false) {
					block=true;
					startBlock = i;
					lenBlock=0;
				}
				else {
					lenBlock++;
				}
			}else {
				if(block == true) {
					cmds.add(new Line(numLine, startBlock, numLine, startBlock + lenBlock));
					block = false;
				}
			}
			
			i++;			
		}
		
		// Si un bloc touche la fin de la line
		if(block == true) {
			cmds.add(new Line(numLine, startBlock, numLine, startBlock + lenBlock));
		}
	}
	
	public static void findSolutionColumn(char[][] tab, List<Paint> cmds) {
		for (int column = 0; column<tab[0].length;column++) {
			findSolutionOneColumn(tab, column, cmds);
		}
	}

	private static void findSolutionOneColumn(char[][] tab, int numColumn, List<Paint> cmds) {
		int i = 0;
		boolean block = false;
		int startBlock = 0;
		int lenBlock=0;
		
		while (i<tab.length) {
			if (tab[i][numColumn] == Paint.PAINT) {
				if (block == false) {
					block = true;
					startBlock = i;
					lenBlock = 0;
				}
				else {
					lenBlock++;
				}
			} 
			else {
				if(block == true) {
					cmds.add(new Line(startBlock, numColumn, startBlock + lenBlock,numColumn));
					block = false;
				}
			}
			
			i++;
		}
		
		// Si un bloc touche la fin de la colonne
		if(block == true) { 
			cmds.add(new Line(startBlock, numColumn, startBlock + lenBlock,numColumn));
		}
	}
	
//	public static void findSolutionSquare(char[][] tab, List<Paint> cmds) {
//		int squareSize = 1;
//		for (int row = 0; row<tab[0].length;row++) {
//			findSolutionOneSquare(tab, squareSize, cmds);
//		}
//		int squareSize = 0;
//		findSolutionOneSquare(tab, squareSize, cmds);
//		
//		for ()
//		
//	}
//
//	private static void findSolutionOneSquare(char[][] tab, int squareSize, List<Paint> cmds) {
//		int i = 0;
//		int sizeMax =0;
//		
//	}
      
}
