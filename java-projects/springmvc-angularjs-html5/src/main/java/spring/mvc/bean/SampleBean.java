package spring.mvc.bean;

public class SampleBean {

	private int sampleId;
	private String sampleText;
	
	public SampleBean(){}
	
	public SampleBean(int sampleId, String sampleText){
		this.sampleId = sampleId;
		this.sampleText = sampleText;
	}
	
	public int getSampleId() {
		return sampleId;
	}
	public void setSampleId(int sampleId) {
		this.sampleId = sampleId;
	}
	public String getSampleText() {
		return sampleText;
	}
	public void setSampleText(String sampleText) {
		this.sampleText = sampleText;
	}
	
	
}
