import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Random;


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
	
	public void RandomChange() throws IOException{
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
	
	/*
	 * Cambia las columnas del fichero de forma aleatoria
	 */
	public void RowChange() throws IOException{
		int min_aux = 0;
		int max_aux;
		int ran_num = 0;
		String line, line2;
		fichero_.seek(0);
		try{
			max_aux = buffer.size();
			line2 = System.getProperty("line.separator");
			int j = 0;
			while (j != buffer.size()){
				ran_num = Random(min_aux, max_aux-1);
				line = buffer.get(ran_num);
				line += line2;
				fichero_.writeBytes(line);						
				j++;
			}
			fichero_.close();
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}
	
	/*
	 * Intercambia las columnas y las letras entre las columnas de forma aleatoria
	 */
	public void RowColChange() throws IOException{
		String line, line2;
		char interchange;
		fichero_.seek(0);
		try{
			//int max_aux = buffer.size();
			int j = 0;
			while( j != buffer.size()){
				line = buffer.get(j);
				int ran_num = Random(0, buffer.size()-1);
				line2 = buffer.get(ran_num);
				int size_line = line.length();
				int size_line2 = line2.length();
				int min = Math.min(size_line, size_line2);
				int ran_col = Random(0,min);
				//interchange = line(ran_col);
				
				
				
				
			}
			fichero_.close();
		}
		catch(IOException e){
			System.out.println("RowColChange Error");
			return;
		}
		
	}
	
	
	
	
	public static void main( String[] args ) throws FileNotFoundException {
		String argue;
		argue = args[0];
		for (int i = 0 ; i <7 ; i++){
			Sec_Eraser Eraser = new Sec_Eraser(args[0]);
			try{
		//		System.out.println("el valor de i ->"+i);
				Eraser.FileDump();
				Eraser.RandomChange();
				
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
		File file = new File(argue);  
		file.delete();  
	}
}
