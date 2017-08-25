package vo;

import java.io.Serializable;

public class TcpContVO implements Serializable{

	private static final long serialVersionUID = -7984789371441191028L;
	
	private String svcCode;
	private String apiCode;
	private String transactionID;
	private String reqTime;
	private String sign;
	private String version;
	
	public String getSvcCode() {
		return svcCode;
	}
	public void setSvcCode(String svcCode) {
		this.svcCode = svcCode;
	}
	public String getApiCode() {
		return apiCode;
	}
	public void setApiCode(String apiCode) {
		this.apiCode = apiCode;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}

}
