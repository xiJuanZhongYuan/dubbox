package vo;

import java.io.Serializable;
import java.util.Date;

public class ProdInstVO  extends SvcContVO implements Serializable{
	
	private static final long serialVersionUID = -455210312804128148L;
	
	private Long prodInstId;
	private String prodInstName;
	private Date date1;
	private String data2;
	
	public Long getProdInstId() {
		return prodInstId;
	}
	public void setProdInstId(Long prodInstId) {
		this.prodInstId = prodInstId;
	}
	public String getProdInstName() {
		return prodInstName;
	}
	public void setProdInstName(String prodInstName) {
		this.prodInstName = prodInstName;
	}
	public Date getDate1() {
		return date1;
	}
	public void setDate1(Date date1) {
		this.date1 = date1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	
}
