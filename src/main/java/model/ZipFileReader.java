package model;

import org.simpleflatmapper.csv.CsvParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class ZipFileReader {

	public static List<String> getFileName(String path) {
		List<String> result = new ArrayList<String>();

		File f = new File(path);
		if (!f.exists()) {
			System.out.println(path + " not exists");
			return null;
		}

		File fa[] = f.listFiles();
		for (int i = 0; i < fa.length; i++) {
			File fs = fa[i];
			if (fs.isDirectory()) {
				String subPath = path + "/" + fs.getName();
				result.addAll(getFileName(subPath));
			} else {
				result.add(fs.getName());
			}
		}
		return result;
	}

	public static void getZipFileContent(File zipFile, String readFileName) throws ZipException, IOException {  
		ZipFile zip = new ZipFile(zipFile);  
		@SuppressWarnings("unchecked")
		Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();  

		ZipEntry ze;  

		while (entries.hasMoreElements()) {  
			ze = entries.nextElement();  
			if (ze.getName().equals(readFileName)) {  
				InputStream is = zip.getInputStream(ze);

				CsvParser.mapTo(ShapeModel.class)
					.forEach(new InputStreamReader(is)
						, r -> {
							Double latitude = r.getShape_pt_lat();   
							Double longitude = r.getShape_pt_lon();

							BoxCoordinate coordinate = new BoxCoordinate(latitude, longitude);
							Double neLat = coordinate.getNortheastLatitude();
							Double neLon = coordinate.getNortheastLongitude();
							Double seLat = coordinate.getSouthwestLatitude();
							Double seLon = coordinate.getSouthwestLongitude();

							if(neLat > Application.northeastLatitude) Application.northeastLatitude	 = neLat;
							if(neLon > Application.northeastLongitude) Application.northeastLongitude = neLon;
							if(seLat < Application.southwestLatitude) Application.southwestLatitude = seLat;
							if(seLon < Application.southwestLongitude) Application.southwestLongitude = seLon;
						});
			}
		}  
		zip.close();    
	} 
}
