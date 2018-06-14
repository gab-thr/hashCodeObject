package hashCodeObject;

public class Line extends Paint {

	protected int x2;
	protected int y2;
	
	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void paint(char[][] tab) {
    	
    	for(int i= x1 ; i<=x2 ; i++) {
    		for(int j=y1 ; j<=y2 ; j++) {
    			tab[i][j] = PAINT;
    		}
    	}
    	
	}
	
	public void P_LINE(int a, int b, int c, int d) {
		System.out.println("LINE " + a + " " + b + " " + c + " " + d);
	}
	
	
}
