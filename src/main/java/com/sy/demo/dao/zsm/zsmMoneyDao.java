package com.sy.demo.dao.zsm;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.sy.demo.pojo.Banktype;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.moneyVo;

public interface zsmMoneyDao {

	/**
	 * 查询金币交易记录
	 * @param userID
	 * @param acquisitionMode
	 * @return
	 */
	List<moneyVo>SelectMoneyAll(@Param("userID") Integer userID,@Param("acquisitionMode") Integer acquisitionMode);
	
	/**
	 * 查询用户金币
	 * @param userID
	 * @return
	 */
	User selectUser(@Param("userID") Integer userID);
	
	/**
	 * 查询银行
	 * @return
	 */
	List<Banktype> SelectByBank();
	/**
	 * 提现新增金币流向操作表
	 * @param userID
	 * @param recordDescribe
	 * @param recordInAndOut
	 */
	void insertGoldnotes(@Param("userID")Integer userID,@Param("recordDescribe") String recordDescribe,@Param("recordInAndOut") String recordInAndOut);
    
	/**
	 * 新增一条提现记录
	 * @param userID
	 * @param putName
	 * @param bankID
	 * @param bankAccount
	 * @param openBankName
	 * @param money
	 */
	void insertPutforward(@Param("userID")Integer userID,@Param("putName")String putName,@Param("bankID")Integer bankID,@Param("bankAccount") String bankAccount,@Param("openBankName") String openBankName,@Param("money") Integer money);
    /**
     * 新增一条提现记录表
     * @param userID
     * @param bankAccount
     * @param bankID
     * @param money
     */
	void insertPutforwardRecord(@Param("userID") Integer userID,@Param("bankAccount") String bankAccount,@Param("bankID") Integer bankID,@Param("money") Integer money);

}
