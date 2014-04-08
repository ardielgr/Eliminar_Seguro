import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.ArrayList; 




class Sec_Eraser {
	
	final static int MAX = 122;
	final static int MIN = 48;
	
	String variable_;
	static RandomAccessFile fichero_;
    static String[][] buffer;
    static ArrayList<String> buffer2 = new ArrayList<String>();
	public Sec_Eraser(String arg) throws FileNotFoundException {
		variable_ = arg;
		fichero_ = new RandomAccessFile(variable_, "rw");
	}
	
	public void OpenFile() throws IOException{
		try{
			do {
				System.out.println(fichero_.readLine());
			}	while ((fichero_.readLine()) !=null);
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}
	
	public static int Random (int min, int max){
		Random rnd = new Random();
		int aux_rnd = rnd.nextInt((max -min) +1 ) + min;
		return aux_rnd;
	}
	
	public static char getRandomChar()
	{
		return (char)Random( MIN , MAX );
	}
	
	public static int LineNumber()throws IOException{
		int line_number = 0;
		try{
			fichero_.seek(0);
			do{
				fichero_.readLine();
				line_number++;
			} while (fichero_.readLine() != null);
		}
		catch (IOException e){
			System.out.println("Error con el fichero");
			return -1;
		}
		return line_number;
	}
	
	public void FileDump() throws IOException{
		String linea;
		linea = fichero_.readLine();
		while( linea != null )
		{
			System.out.println(linea);
			System.out.println("----------");
			buffer2.add(linea);
			linea = fichero_.readLine();
		}
	}
	
	public void Change() throws IOException{
		int valor_linea;
		String linea, linea2;
		String cadena = new String();
		fichero_.seek(0);
		try{
			int numero = buffer2.size();
			System.out.println(numero + "el numero de filas que tiene el buffer");
			for (int j = 0 ; j < buffer2.size() ; j++){ 
				linea = buffer2.get(j);
			valor_linea = linea.length();
			System.out.println(valor_linea);
			for( int i = 0 ; i < valor_linea ; i++ )
				cadena += getRandomChar();
				linea2 = System.getProperty("line.separator");
				cadena += linea2;
				cadena = cadena.toString();
				fichero_.writeBytes(cadena);
				cadena = "";
			}	 
			fichero_.close();
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}

	public static void main( String[] args ) throws FileNotFoundException {
		Sec_Eraser Eraser = new Sec_Eraser(args[0]);
		try{
			//Eraser.OpenFile();
			Eraser.FileDump();
			Eraser.Change();
		}
		catch (IOException e){
			System.out.println("Error con el fichero");
			return;
		}
		try{
			fichero_.close();
		}
		catch (IOException e){
			System.out.println("No se puede cerrar el fichero");
			return;
		}
	}
}
