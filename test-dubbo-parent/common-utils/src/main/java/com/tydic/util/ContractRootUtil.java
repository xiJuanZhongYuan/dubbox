package com.tydic.util;

import common.Constants;
import vo.ContractRootVO;
import vo.ContractVO;
import vo.ProdInstVO;
import vo.SvcContVO;
import vo.TcpContVO;

public class ContractRootUtil {

	
	/**
	 * 获得调用各中心的对象类型的请求报文
	 * @param svcCode
	 * @param apiCode
	 * @param sign
	 * @param svcVO
	 * @return
	 */
	public static ContractRootVO getContractRootVO (String svcCode,
			String apiCode,String sign,SvcContVO svcContVO) {
		
		ContractVO contractVO = new ContractVO();
		TcpContVO tcpContVO = new TcpContVO();
		tcpContVO.setSvcCode(svcCode);
		tcpContVO.setApiCode(apiCode);
		tcpContVO.setTransactionID(DateTool.getCurrentTimeHasMillisecond());
		tcpContVO.setReqTime(DateTool.getCurrentTimeHasMillisecond());
		tcpContVO.setSign(sign);
		tcpContVO.setVersion(Constants.version_1);
		
		contractVO.setTcpContVO(tcpContVO);
		contractVO.setSvcContVO(svcContVO);
		ContractRootVO contractRootVO = new ContractRootVO();
		contractRootVO.setContractVO(contractVO);
		System.out.println(GsonUtil.toJsonStr(contractRootVO));
		return contractRootVO;
	}
	
	/**
	 * 获得调用个中心的字符串类型的请求报文
	 * @param svcCode
	 * @param apiCode
	 * @param sign
	 * @param svcContent
	 * @return
	 */
	public String getContractRootStr(String svcCode,
			String apiCode,String sign,String svcContent) {
		
		StringBuffer sBuffer = new StringBuffer();
			sBuffer.append(	"{\n" )
					.append("  \"contractRoot\":{\n")
					.append("    \"svcCont\":{\n" + svcContent)
					.append("    },\n" )
					.append("    \"tcpCont\":{\n" )
					.append("      \"apiCode\":\"" + apiCode +"\",\n")
					.append("      \"reqTime\":\""+ DateTool.getCurrentTimeHasMillisecond()+"\",\n")
					.append("      \"sign\":\"" + sign +"\",\n")
					.append("      \"svcCode\":\""+ svcCode +"\",\n" ) 
					.append("      \"transactionID\":\""+DateTool.getCurrentTimeHasMillisecond()+"\",\n" ) 
					.append("      \"version\":\"1.0\"\n" ) 
					.append("    }\n")
					.append("  }\n")
					.append("}");
			
		return sBuffer.toString();

	}
	
	public static void main(String[] args) {
		ProdInstVO prodInstVO = new ProdInstVO();
		prodInstVO.setProdInstId(1L);
		prodInstVO.setProdInstName("测试");
		ContractRootVO ContractRootVO = getContractRootVO("svcCode","apiCode","sign",prodInstVO);
	}

}
