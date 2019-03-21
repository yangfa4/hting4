package com.sy.demo.action.job;

import java.util.HashMap;
import java.util.Map;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.demo.quartz.job.MyJob;



@RestController
@RequestMapping("/qz")
public class MyJobAction {

	@Autowired
	private Scheduler scheduler;

	@PostMapping("add")
	public Map<String, String> addJob(String name, String group) {
		// 创建任务
		JobDetail jd = JobBuilder.newJob(MyJob.class).withIdentity(JobKey.jobKey(name, group)).build();
		// 2.
		CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(TriggerKey.triggerKey(name, group))
				.withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?")).build();
		Map<String, String> message = new HashMap<String, String>();
		try {
			scheduler.scheduleJob(jd, trigger);
			message.put("code", "200");
			message.put("msg", "ok");
		} catch (SchedulerException e) {
			message.put("code", "500");
			message.put("msg", e.getMessage());
		}
		return message;
	}
	
	
	@PutMapping("pause/{name}/{group}")
	public Map<String, String> pauseJob(@PathVariable String name,@PathVariable String group) {
		Map<String, String> message = new HashMap<String, String>();
		try {
			scheduler.pauseJob(JobKey.jobKey(name, group));
			message.put("code", "200");
			message.put("msg", "ok");
		} catch (SchedulerException e) {
			message.put("code", "500");
			message.put("msg", e.getMessage());
		}
		return message;
	}
	
	
	@PutMapping("resume/{name}/{group}")
	public Map<String, String> resumeJob(@PathVariable String name,@PathVariable String group) {
		Map<String, String> message = new HashMap<String, String>();
		try {
			scheduler.resumeJob(JobKey.jobKey(name, group));
			message.put("code", "200");
			message.put("msg", "ok");
		} catch (SchedulerException e) {
			message.put("code", "500");
			message.put("msg", e.getMessage());
		}
		return message;
	}
	
	@DeleteMapping("del/{name}/{group}")
	public Map<String, String> deleteJob(@PathVariable String name,@PathVariable String group) {
		Map<String, String> message = new HashMap<String, String>();
		try {
			scheduler.pauseJob(JobKey.jobKey(name, group));
			scheduler.deleteJob(JobKey.jobKey(name, group));
			message.put("code", "200");
			message.put("msg", "ok");
		} catch (SchedulerException e) {
			message.put("code", "500");
			message.put("msg", e.getMessage());
		}
		return message;
	}

}
