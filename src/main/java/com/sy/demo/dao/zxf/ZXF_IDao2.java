package com.sy.demo.dao.zxf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sy.demo.pojo.Appraisalapply;
import com.sy.demo.pojo.Bond;
import com.sy.demo.pojo.Evaluationservice;
import com.sy.demo.pojo.Orders;
import com.sy.demo.pojo.Services;
import com.sy.demo.pojo.User;
import com.sy.demo.vo.zxf.EvaluationServiceVo;
import com.sy.demo.vo.zxf.Ordersvo1;
import com.sy.demo.vo.zxf.RefundListVo;
import com.sy.demo.vo.zxf.ReturnEvaluation;

public interface ZXF_IDao2 {

	/**
	 * 商家入驻申请（34列+1（交保证金 -**））
	 * 
	 * @methodName: sjrz
	 * @param us
	 * @return
	 *
	 */
	Integer sjrz(@Param("us") User us);

	/**
	 * 新增保证金记录(3)
	 * 
	 * @methodName: addBand
	 * @param bd
	 * @return
	 *
	 */
	Integer addBand(@Param("bd") Bond bd);

	/**
	 * 服务信息查询
	 * 
	 * @methodName: queryServices
	 * @param uid
	 * @param name
	 * @param auditStatus
	 * @return
	 *
	 */
	List<Services> queryServices(@Param("uid") Integer uid, @Param("serviceTitle") String serviceTitle,
			@Param("auditStatus") Integer auditStatus);

	/**
	 * 查询商家订单
	 * 
	 * @methodName: queryOrders
	 * @param uid
	 * @return
	 *
	 */
	List<Ordersvo1> queryOrders(@Param("uid") Integer uid, @Param("oid") String oid, @Param("oids") String oids,
			@Param("stat") Integer stat);

	/**
	 * 修改订单状态
	 * 
	 * @methodName: ordersStatupdate
	 * @param orderID
	 * @param stat
	 * @return
	 *
	 */
	Integer ordersStatupdate(@Param("orderID") String orderID, @Param("stat") Integer stat);

	/**
	 * 订单退款状态修改
	 * 
	 * @methodName: ordersrefundstatusupdate
	 * @param orderID
	 * @param refundstatus
	 * @return
	 *
	 */
	Integer ordersrefundstatusupdate(@Param("orderID") String orderID, @Param("refundstatus") Integer refundstatus);

	/**
	 * 商家审核状态修改
	 * 
	 * @methodName: refundrefundstatusupdate
	 * @param refundID
	 * @param auditStatus
	 * @return
	 *
	 */
	Integer refundrefundstatusupdate(@Param("refundID") Integer refundID, @Param("auditStatus") Integer auditStatus,
			@Param("businessRemarks") String businessRemarks);

	/**
	 * 金币修改
	 * 
	 * @methodName: usermoneyupdate
	 * @param uid
	 * @param money
	 * @param jiajian
	 *            1/加 , 2/减
	 * @return
	 *
	 */
	Integer usermoneyupdate(@Param("uid") Integer uid, @Param("money") Float money, @Param("jiajian") Integer jiajian);

	/**
	 * 发布服务
	 * 
	 * @methodName: addservices
	 * @param services
	 * @return
	 *
	 */
	Integer addservices(@Param("services") Services services);

	/**
	 * 商家收到的退款查询
	 * 
	 * @methodName: queryrefund
	 * @param uid
	 * @return
	 *
	 */
	List<RefundListVo> queryrefund(@Param("uid") Integer uid);

	/**
	 * 查询退款详情
	 * 
	 * @methodName: queryrefundbyid
	 * @param id
	 * @return
	 *
	 */
	RefundListVo queryrefundbyid(@Param("id") Integer id);

	/**
	 * 新增服务鉴定
	 * 
	 * @methodName: addAppraisalapply
	 * @param ap
	 * @return
	 *
	 */
	int addAppraisalapply(@Param("ap") Appraisalapply ap);

	/**
	 * 商家查评价
	 * 
	 * @methodName: queryEvaluation
	 * @param uid
	 * @return
	 *
	 */
	List<EvaluationServiceVo> queryEvaluation(@Param("uid") Integer uid, @Param("statid") Integer statid);

	/**
	 * 商家回复
	 * 
	 * @methodName: addEvaluation
	 * @param ev
	 * @return
	 *
	 */
	int addEvaluation(@Param("ev") Evaluationservice ev);

	/**
	 * 根据主键id查询服务
	 * 
	 * @methodName: querybyser
	 * @param serviceID
	 * @return
	 *
	 */
	Services querybyser(@Param("serviceID") Integer serviceID);
}
