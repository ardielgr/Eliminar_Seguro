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
    static ArrayList<String> buffer = new ArrayList<String>();
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
		String line;
		line = fichero_.readLine();
		while( line != null )
		{
			System.out.println(line);
			System.out.println("----------");
			buffer.add(line);
			line = fichero_.readLine();
		}
	}
	
	public void Change() throws IOException{
		int line_value;
		String line, line2;
		String cadena = new String();
		fichero_.seek(0);
		try{
			int numero = buffer.size();
			System.out.println(numero + "el numero de filas que tiene el buffer");
			for (int j = 0 ; j < buffer.size() ; j++){ 
				line = buffer.get(j);
			line_value = line.length();
			System.out.println(line_value);
			for( int i = 0 ; i < line_value ; i++ )
				cadena += getRandomChar();
				line2 = System.getProperty("line.separator");
				cadena += line2;
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
		for (int i = 0 ; i <7 ; i++){
		Sec_Eraser Eraser = new Sec_Eraser(args[0]);
		try{
			
			//Eraser.OpenFile();
				System.out.println("el valor de i ->"+i);
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
}
