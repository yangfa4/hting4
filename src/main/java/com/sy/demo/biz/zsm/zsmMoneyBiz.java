package com.sy.demo.biz.zsm;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.demo.dao.zsm.zsmMoneyDao;
import com.sy.demo.pojo.Banktype;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.moneyVo;

@Service
public class zsmMoneyBiz {

	@Autowired
	private zsmMoneyDao dao;
	
	/**
	 * 查询金币交易记录进行分页查询
	 * @param userID
	 * @param acquisitionMode
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	public PageInfo<moneyVo>SelectMoney(Integer userID,Integer acquisitionMode,Integer pageSize,Integer pageNum){
	PageHelper.startPage(pageNum, pageSize);
	return new PageInfo<moneyVo>(dao.SelectMoneyAll(userID, acquisitionMode));
	}
	/**
	 * 查询用户现有金币
	 * @param userID
	 * @return
	 */
	public User SelectUser(Integer userID) {
	return dao.selectUser(userID);	
	}
	/**
	 * 查询所有银行
	 * @return
	 */
	public List<Banktype>SelectByBank(){
		return dao.SelectByBank();
	}
	/**
	 * 新增金币交易记录
	 * @param userID
	 * @param recordDescribe
	 * @param recordInAndOut
	 */
	public void insertGoldnotes(Integer userID,String recordDescribe,String recordInAndOut) {
		dao.insertGoldnotes(userID, recordDescribe, recordInAndOut);
	}
	/**
	 * 新增一条提现记录
	 * @param userID
	 * @param putName
	 * @param bankID
	 * @param bankAccount
	 * @param openBankName
	 * @param money
	 */
	public void insertPutforward(Integer userID,String putName,Integer bankID,String bankAccount,String openBankName,Integer money) {
		dao.insertPutforward(userID, putName, bankID, bankAccount, openBankName, money);
	}
	  /**
     * 新增一条提现记录表
     * @param userID
     * @param bankAccount
     * @param bankID
     * @param money
     */
	public void insertPutforwardRecord(Integer userID,String bankAccount,Integer bankID,Integer money) {
		dao.insertPutforwardRecord(userID, bankAccount, bankID, money);
	}
}
