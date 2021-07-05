package it.esedra.corso.esercitazioneB.matteocirri;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Esercizio {

	public static void main(String[] args) {

	}

	public static void cat(File file) {
		RandomAccessFile input = null;
		String line = null;
		try {
			input = new RandomAccessFile(file, "r");
			while ((line = input.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				} 
			} catch (IOException e) {
					e.printStackTrace();
			}
		}
	}
}
