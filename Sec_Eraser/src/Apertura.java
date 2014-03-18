import java.io.*;

public class Apertura {

	public Apertura() {
		// TODO Auto-generated constructor stub
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File();
			fr = new FileReader (archivo);
			br = new BufferedReader(fr);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nombre;
		System.out.println("Se procede a abrir el fichero");
		try {
            nombre = br.readLine();
        } 
		catch (IOException ex) {
            System.out.println("Error: Fichero no encontrado.");
            return;
        }
		Apertura (nombre);
        
        
	}

}
