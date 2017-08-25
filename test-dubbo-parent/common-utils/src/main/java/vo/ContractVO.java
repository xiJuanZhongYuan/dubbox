package vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ContractVO implements Serializable {

	private static final long serialVersionUID = -8460660157304242212L;
	@SerializedName("tcpCont")
	private TcpContVO tcpContVO;
	@SerializedName("svcCont")
	private SvcContVO svcContVO;
	
	
	public TcpContVO getTcpContVO() {
		return tcpContVO;
	}
	
	public void setTcpContVO(TcpContVO tcpContVO) {
		this.tcpContVO = tcpContVO;
	}
	public SvcContVO getSvcContVO() {
		return svcContVO;
	}
	
	public void setSvcContVO(SvcContVO svcContVO) {
		this.svcContVO = svcContVO;
	}
}
