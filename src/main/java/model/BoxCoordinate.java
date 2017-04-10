package model;

public class BoxCoordinate {

	private Double latitude = null;
	private Double longitude = null;
	private Double northeastLatitude = null;
	private Double northeastLongitude = null;
	private Double southwestLatitude = null;
	private Double southwestLongitude = null;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getNortheastLatitude() {
		return northeastLatitude;
	}

	public void setNortheastLatitude(Double northeastLatitude) {
		this.northeastLatitude = northeastLatitude;
	}

	public Double getNortheastLongitude() {
		return northeastLongitude;
	}

	public void setNortheastLongitude(Double northeastLongitude) {
		this.northeastLongitude = northeastLongitude;
	}

	public Double getSouthwestLatitude() {
		return southwestLatitude;
	}

	public void setSouthwestLatitude(Double southwestLatitude) {
		this.southwestLatitude = southwestLatitude;
	}

	public Double getSouthwestLongitude() {
		return southwestLongitude;
	}

	public void setSouthwestLongitude(Double southwestLongitude) {
		this.southwestLongitude = southwestLongitude;
	}
	
	public BoxCoordinate(Double latitude, Double longitude) {

		this.latitude = latitude;
		this.longitude = longitude;
		// code courtesy StackOverflow: http://stackoverflow.com/questions/12448629/create-a-bounding-box-around-the-geo-point

		Double longitudeD = (Math.asin(1000 / (6378000 * Math.cos(Math.PI*latitude/180))))*180/Math.PI;
		Double latitudeD = (Math.asin((double)1000 / (double)6378000))*180/Math.PI;

		this.northeastLatitude = latitude+(latitudeD);
		this.northeastLongitude = longitude+(longitudeD);

		this.southwestLatitude = latitude-(latitudeD);
		this.southwestLongitude= longitude-(longitudeD);
	}
}
