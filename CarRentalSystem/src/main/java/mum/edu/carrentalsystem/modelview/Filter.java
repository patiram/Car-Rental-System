package mum.edu.carrentalsystem.modelview;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class Filter {

	@NotNull(message = "Select a filter:")
	private String id;
	private String filter;
	
	@NotBlank(message = "Search term:")
	private String text;
	
	public Filter(String id, String filter, String text) {
		this.id = id;
		this.filter = filter;
		this.text = text;
	}
	
	public Filter(){
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFilter() {
		return filter;
	}
	public void setFilter(String filter) {
		this.filter = filter;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

/*	@Override
	public String toString() {
		return "Filter [id=" + id + ", filter=" + filter + ", text=" + text + "]";
	}*/
	
}
