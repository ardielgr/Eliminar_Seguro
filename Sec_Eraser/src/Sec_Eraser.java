import java.io.*;
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
		String linea;
		Random rnd = new Random(System.currentTimeMillis());
		int ary;
		try{
			do{
				linea = fichero_.readLine();
				valor_linea = linea.length();
				for (int i = 0; i<valor_linea; i++){
				//	linea[i] = "a";
				//	linea[i] = (char) rnd.nextInt();
				}
				fichero_.seek(index);
				fichero_.writeChars("linea");
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
		//	System.out.println("Lala");
			Borrado.OpenFile();
			Borrado.Change();
		//	System.out.println("Lele");
			//fichero_ = new RandomAccessFile(args[0], "rw");
			
//			fichero_ = new RandomAccessFile(args[0], "rw");
		//	fichero_.seek(0);
			//System.out.println(fichero_.readLine());
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
		 
/*		
		try {
			Apertura A = new Apertura(args);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}

class Apertura {
	
	public Apertura(RandomAccessFile fichero) throws IOException{
        fichero.seek(0);
        while ((fichero.readLine()) !=null)
        	System.out.println(fichero.readLine());    
	}
	
}
}



