package it.esedra.corso.shoppinglist.helper;

import java.io.File;

public class GetFileResource {
	private static final String PATH = "src/resources/";
	private static final String S = System.getProperty("file.separator");
	
	/** 
	 * Retyurn a  file in reasources
	 * @param name
	 * @param path
	 * @return
	 */
	public static File get(String name, String path) {


		File file = new File(PATH + S + path + S + name);
//		String absolutePath = file.getAbsolutePath();
//
//		System.out.println(absolutePath);
//		
		return file;
	}
}
