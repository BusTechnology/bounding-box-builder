package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Application {
	static Double northeastLatitude = Double.parseDouble(String.valueOf(Integer.MIN_VALUE));
	static Double northeastLongitude = Double.parseDouble(String.valueOf(Integer.MIN_VALUE));
	static Double southwestLatitude = Double.MAX_VALUE;
	static Double southwestLongitude = Double.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		List<String> fileNames;

		if (args.length != 1){
			System.out.println("Usage: boundingboxbuilder.jar [path of gtfs]");
			System.exit(0);
		}
		
		String path = args[0]; 
		
		fileNames = ZipFileReader.getFileName(path);
		if (fileNames.size() == 0){
			System.err.println("No files found in path " + path);
			System.exit(-1);
		}

		for(int i=0; i<fileNames.size(); i++){
			if(fileNames.get(i).endsWith(".zip")){
				File file = new File(path+fileNames.get(i));
				System.out.println("Reading file " + file.getCanonicalFile());
				ZipFileReader.getZipFileContent(file, "shapes.txt");
			}
		}
		System.out.println("northeastLatitude : " + northeastLatitude);
		System.out.println("northeastLongitude : " + northeastLongitude);
		System.out.println("southwestLatitude : " + southwestLatitude);
		System.out.println("southwestLongitude : " + southwestLongitude);
	}
}
