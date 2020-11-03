import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LeerEscribir {
	public static void main(String[] args) {

		File file = new File("./ejemploFlujoCaracteres.txt");
		BufferedWriter buffWriter = null;
		BufferedReader buffReader = null;
		try {
			buffWriter = new BufferedWriter(new FileWriter(file));
			buffReader = new BufferedReader(new FileReader(file)); // file,true modo append
			for (int i = 1; i <= 100; i++) {
				// escribimos líneas
				buffWriter.write("Fila " + i);
				buffWriter.newLine();
			}
			// esto ocupará 2 bytes (en utf-8, la ñ es C3B1 en hexadecimal: ojo, hay que
			// asegurarse codif. en UTF-8)
			buffWriter.write("ñ");
			buffWriter.close();
			String linea;

			while ((linea = buffReader.readLine()) != null) {
				System.out.println(linea);
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (buffWriter != null)
					buffWriter.close();
				if (buffReader != null)
					buffReader.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}
