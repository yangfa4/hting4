package com.sy.demo.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;




public class Job1 implements Job {
	
	/*@Autowired
	private StockOrderBiz biz;*/
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		/*System.out.println("业务类:"+biz+"执行【数据库备份】任务");*/
	}

}
