package com.sy.demo.biz.zsm;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sy.demo.dao.zsm.zsmOrdersDao;
import com.sy.demo.pojo.Integralrecord;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Refund;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.OrdersVo;
import com.sy.demo.vo.zsm.servoceVo;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class zsmOrdersBiz {

	@Autowired
	private zsmOrdersDao dao;
	//查询某用户所有订单。
	public List<OrdersVo>SelectOrders(Integer userID,Integer orderStatus,String orderID,Integer commentstatus){
		
		return dao.SelectOrdes(userID, orderStatus, orderID,commentstatus);
	}
	//查询个个订单数量
	public int findByInt(Integer orderStatus,Integer commentstatus,Integer userID) {
		return dao.findByInt(orderStatus, commentstatus,userID);
	}
	//按照某个用户的订单详情
	public OrdersVo SelectOrdersOne(String orderID) {
		return dao.SelectOrdersVoOne(orderID);
	}
	//个人中心加载查询用户信息
	public User SelectByuser(Integer userID) {
		return dao.SelectByuser(userID);				
	}
	//查询个人中心最新预定
	public List<OrdersVo> Selectcrzxzuixing(Integer userID) {
		return dao.Selectcrzxzuixing(userID);
	}
	//签到操作
	public Date Selectqd(Integer userID) {
	 return dao.SelectqdTime(userID);
	}
	//签到加积分
	public void updateUserjf(Integer userID) {
		dao.updateUserjf(userID);
	}
	//签到新增一条签到记录
	public void insertIntegralrecord(Integralrecord Integralrecord) {
		dao.insertIntegralrecord(Integralrecord);
	}
	//取消服务
	public void updateOrders(Integer orderStatus,Integer commentstatus,Integer refundstatus,String orderID) {
		dao.updateOrders(orderStatus, commentstatus, refundstatus, orderID);
	}
	
	//支付订单查看订单金币
	public Orders selectByuserOr(String orderID) {
		return dao.selectByuserOr(orderID);
	}
	//支付订单新增一条支付记录
	public void insertGoldnotes(Integer userID,String recordDescribe,String recordInAndOut) {
		dao.insertGoldnotes(userID, recordDescribe, recordInAndOut);
	}
	//购买过后扣除用户金币
	public void updateUserMoney(Integer userID,String userMoney) {
		dao.updateUserMoney(userID, userMoney);
	}
	//购买过后修改订单状态记录当前付款时间
	public void updateOredrsBymoney(String orderID) {
		dao.updateOredrsBymoney(orderID);
	}
	//评价商品
	public void insertEvaluationService(Integer serviceID,Integer userID,String serviceAppraiseContent,Integer serviceAppraiseLevel) {
		dao.insertEvaluationService(serviceID, userID, serviceAppraiseContent,serviceAppraiseLevel);
	}
	//修改状态为已评论
	public void updatepinglun(String orderID) {
		dao.updatepinglun(orderID);
	}
	//查看退款的订单详情
	public Orders selectTuikuanxq(String orderID) {
		return dao.selectTuikuanxq(orderID);
	}
	//查看退款进度和详情
	public Refund selectRefund(String orderID) {
		return dao.selectRefund(orderID);
	}
	 //退款查用户
	public User SelectTkuser(Integer userID) {
		 return dao.SelectTkuser(userID);
	 }
	 //根据服务编号查商家
	public User SelectTkshangjia(Integer userID) {
		return dao.SelectTkshangjia(userID);
	}
	 //退款查服务表
	 public Services SelectTkService(Integer serviceID) {
		 return dao.SelectTkService(serviceID);
	 }
	 //新增退款
	 public void insertRefund(Integer point,String orderID,Integer userID,String refundReason,String refundExplain,String refundImg,Integer applyRefundMoney,Integer auditStatus) {
		 dao.insertRefund(point, orderID, userID, refundReason, refundExplain, refundImg, applyRefundMoney, auditStatus);
	 }
	 //新增退款查看
	 public servoceVo SelectServoceVo(String orderID) {
		 return dao.SelectServoceVo(orderID);
	 }
}
