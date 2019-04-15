package com.sy.demo.dao.zsm;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Integralrecord;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Refund;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zsm.OrdersVo;
import com.sy.demo.vo.zsm.servoceVo;

public interface zsmOrdersDao {

	//查询某用户所有订单。
	 List<OrdersVo>SelectOrdes(@Param("userID") Integer userID,@Param("orderStatus") Integer orderStatus,@Param("orderID") String orderID,@Param("commentstatus") Integer commentstatus);

	// 查询个个订单数量
	int findByInt(@Param("orderStatus") Integer orderStatus, @Param("commentstatus")Integer commentstatus,@Param("userID") Integer userID);
    //查询订单详情
	 OrdersVo SelectOrdersVoOne(@Param("orderID") String orderID);
	//个人中心窗体加载
	 User SelectByuser(@Param("userID") Integer userID);
	//个人中心最新预定
	 List<OrdersVo> Selectcrzxzuixing(@Param("userID") Integer userID );
	//签到操作
	 Date SelectqdTime(@Param("userID") Integer userID);
	//签到加积分
	 void updateUserjf(@Param("userID") Integer userID);
	//新增一条为何加积分数据
	 void insertIntegralrecord(@Param("Integralrecord") Integralrecord Integralrecord);
	 //取消订单,修改各种订单状态
	 void updateOrders(@Param("orderStatus") Integer orderStatus,@Param("commentstatus") Integer commentstatus,@Param("refundstatus") Integer refundstatus,@Param("orderID") String orderID);
	//查询订单ID
	 Orders selectByuserOr(@Param("orderID") String orderID);
	 //购买商品扣除用户金币
	 void updateUserMoney(@Param("userID")Integer userID,@Param("userMoney") String userMoney);
	 //记录购买商品付款时间
	 void insertGoldnotes(@Param("userID") Integer userID,@Param("recordDescribe") String recordDescribe,@Param("recordInAndOut") String recordInAndOut);
     //修改订单状态，记录当前付款时间
	 void updateOredrsBymoney(@Param("orderID")String orderID);
	 //评论查询商品
	 void insertEvaluationService(@Param("serviceID") Integer serviceID,@Param("userID") Integer userID,@Param("serviceAppraiseContent") String serviceAppraiseContent,@Param("serviceAppraiseLevel") Integer serviceAppraiseLevel);
	 //修改评论状态
	 void updatepinglun(@Param("orderID") String orderID);
	 //退款查询商品详情
	 Orders selectTuikuanxq(@Param("orderID") String orderID);
	 //根据订单编号查看退款信息
	 Refund selectRefund(@Param("orderID") String orderID);
	 //查退款用户
	 User SelectTkuser(@Param("userID") Integer userID);
	 //根据服务编号查商家
	 User SelectTkshangjia(@Param("userID") Integer userID);
	 //退款查服务表
	 Services SelectTkService(@Param("serviceID") Integer serviceID);
     //新增退款
	 void insertRefund(@Param("point") Integer point,@Param("orderID") String orderID,@Param("userID") Integer userID,@Param("refundReason")String refundReason,@Param("refundExplain")String refundExplain,@Param("refundImg") String refundImg,@Param("applyRefundMoney") Integer applyRefundMoney,@Param("auditStatus") Integer auditStatus);
	 //新增退款查看
	 servoceVo SelectServoceVo(@Param("orderID") String orderID);
	 
}
