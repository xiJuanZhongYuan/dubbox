package vo;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class ContractRootVO implements Serializable {

	private static final long serialVersionUID = 8709383248040541572L;
	
	@SerializedName("contractRoot")
	private ContractVO contractVO;

	public ContractVO getContractVO() {
		return contractVO;
	}

	public void setContractVO(ContractVO contractVO) {
		this.contractVO = contractVO;
	}
}
