import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;



class Sec_Eraser {
	
	String variable_;
	static RandomAccessFile fichero_;
    static String[][] buffer;
	public Sec_Eraser(String arg) throws FileNotFoundException {
		variable_ = arg;
		fichero_ = new RandomAccessFile(variable_, "rw");
	}
	
	public void OpenFile() throws IOException{
		fichero_.seek(0);
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
	
	public static int NumLineas()throws IOException{
		int num_linea = 0;
		try{
			fichero_.seek(0);
			do{
				fichero_.readLine();
				num_linea++;
			} while (fichero_.readLine() != null);
		}
		catch (IOException e){
			System.out.println("Error con el fichero");
			return -1;
		}
		return num_linea;
	}
	
	public static void FileDump() throws IOException{
		String linea;
		int num_lineas = NumLineas();
		fichero_.seek(0);
		long cont = 0;
		try{
			do{
				linea = fichero_.readLine();
				buffer[(int) cont][0] = linea;
				//Pasar de int a string y luego de string a int?
				//buffer[(int) cont][1] = num_lineas;
				cont++;
			}while ((fichero_.readLine()) != null);
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}
	
	public void Change() throws IOException{
		int MAX = 122;
		int MIN = 48;
		int aux_random;
		int valor_linea;
		int num_linea = 0;
		String linea, linea2;
		int index = 0;
		//Random rnd = new Random(System.currentTimeMillis());
		String cadena = new String();
		num_linea = NumLineas();
		System.out.println("el numero de lineas es "+num_linea);
		fichero_.seek(0);
		try{
			do{
				
				linea = fichero_.readLine();
				valor_linea = linea.length();
				System.out.println(valor_linea);
				//For donde altero uno a uno los valores del string de forma aleatoria
				for (int i = 0; i<valor_linea; i++){
					aux_random = Random (MIN,MAX);
					cadena = cadena + (char)aux_random;
				}
				linea = cadena.toString();
				System.out.println(linea);
				//En teoria se deberia poder hacer con la misma variable
				//linea2 = linea.replace(" ", "");
				fichero_.seek(index);
				fichero_.write(linea.getBytes());
				linea2 = System.setProperty( "line.separator", "\n" );
				fichero_.write(linea2.getBytes());
				//fichero_.write("hola".getBytes());
			    //fichero_.write('\r');
				//fichero_.writeChars("\n\r");
				index = linea.length();
			} while ((fichero_.readLine()) != null);
		}
		catch(IOException e){
			System.out.println("Error con el fichero");
			return;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		
		Sec_Eraser Borrado = new Sec_Eraser(args[0]);
		try{
			Borrado.OpenFile();
			Borrado.Change();
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
