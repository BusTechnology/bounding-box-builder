package model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ZipFileReader;

public class Application {
	public static Double northeastLatitude = Double.parseDouble(String.valueOf(Integer.MIN_VALUE));
	public static Double northeastLongitude = Double.parseDouble(String.valueOf(Integer.MIN_VALUE));
	public static Double southwestLatitude = Double.MAX_VALUE;
	public static Double southwestLongitude = Double.MAX_VALUE;

	public static void main(String[] args) throws IOException {

		List<String> fileNames = new ArrayList<String>();

		if (args.length != 1){
			System.out.println("Usage: boundingboxbuilder.jar [path of gtfs]");
			System.exit(0);
		}
		
		String path = args[0]; 
		
		fileNames = ZipFileReader.getFileName(path);
		if (fileNames.size() == 0){
			System.err.println("No files found in path " + path.toString());
			System.exit(-1);
		}

		ZipFileReader zipFileReader = new ZipFileReader();

		for(int i=0; i<fileNames.size(); i++){
			if(fileNames.get(i).endsWith(".zip")){
				File file = new File(path+fileNames.get(i));
				ZipFileReader.getZipFileContent(file, "shapes.txt");
			}
		}
		System.out.println("northeastLatitude : " + northeastLatitude);
		System.out.println("northeastLongitude : " + northeastLongitude);
		System.out.println("southwestLatitude : " + southwestLatitude);
		System.out.println("southwestLongitude : " + southwestLongitude);
	}
}
