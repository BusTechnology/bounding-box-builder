package model;

public class ShapeModel {
	double shape_pt_lon;
	double shape_pt_lat;
	String shape_id;
	int shape_pt_sequence;
	double shape_dist_traveled;
	
	public double getShape_pt_lon() {
		return shape_pt_lon;
	}

	public double getShape_pt_lat() {
		return shape_pt_lat;
	}
	
	public ShapeModel(double shape_pt_lon, double shape_pt_lat, String shape_id, int shape_pt_sequence, double shape_dist_traveled) {
		super();
		this.shape_pt_lon = shape_pt_lon;
		this.shape_pt_lat = shape_pt_lat;
		this.shape_id = shape_id;
		this.shape_pt_sequence = shape_pt_sequence;
		this.shape_dist_traveled = shape_dist_traveled;
	}
	
	public ShapeModel(double shape_pt_lon, double shape_pt_lat, String shape_id, int shape_pt_sequence) {
		this(shape_pt_lon, shape_pt_lat, shape_id, shape_pt_sequence, 0.0);
	}
}
