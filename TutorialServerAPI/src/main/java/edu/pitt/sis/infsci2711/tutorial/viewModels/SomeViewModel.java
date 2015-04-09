package edu.pitt.sis.infsci2711.tutorial.viewModels;

public class SomeViewModel {
	private int id;
	
	public SomeViewModel() {
		
	}
	
	public SomeViewModel(final int id) {
		this.setId(id);
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}
}
