import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;



class Sec_Eraser {
	
	String variable_;
	static RandomAccessFile fichero_;
    
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
	public void Change() throws IOException{
		int index = 0;
		fichero_.seek(index);
		int valor_linea;
		String linea, linea2;
		Random rnd = new Random(System.currentTimeMillis());
		String cadena = new String();
		
		int ary;
		try{
			do{
				linea = fichero_.readLine();
				valor_linea = linea.length();
				//For donde altero uno a uno los valores del string de forma aleatoria
				for (int i = 0; i<=valor_linea; i++){
					cadena = cadena +"a";
					//linea = cadena.toString();
				    
				    //System.out.println(linea);
				}
				linea = cadena.toString();
				//En teoria se deberia poder hacer con la misma variable
				linea2 = linea.replace(" ", "");
				fichero_.seek(index);
				fichero_.write(linea2.getBytes());
				//fichero_.writeChars("\n\r");
				index++;
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
