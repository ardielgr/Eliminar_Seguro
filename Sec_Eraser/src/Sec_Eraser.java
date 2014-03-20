import java.io.IOException;
import java.io.*;

/**
 * 
 */

/**
 * @author Dwarf
 *
 */
public class Sec_Eraser {

	/**
	 * 
	 */
	public Sec_Eraser() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String args) {
		// TODO Auto-generated method stub
				Apertura(args);
      

}

class Apertura extends Sec_Eraser {
	public Apertura(RandomAccessFile fichero) throws IOException{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        fichero.seek(0);
        while ((fichero.readLine()) !=null)
        	System.out.println(fichero.readLine());    
	}
	}
}

class Cambio extends Sec_Eraser {
	public Cambio() throws IOException{
		
	}
	
	public void Cambio1() throws IOException {
		
	}
}
