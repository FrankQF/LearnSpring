package com.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledtaskService {
	private static final SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
	
	@Scheduled(fixedRate = 5000)//fixedRate为每隔五秒执行一次
	public void reportCurrentTime() {
		System.out.println("每隔五秒执行一次："+sdf.format(new Date()));
	}
	//cron为指定时间执行，
	//本例为每天17点53分执行
	@Scheduled(cron= "0 02 18 ? * *")
	public void fixTimeExecution() {
		System.out.println("在指定时间 执行 ："+ sdf.format(new Date()));
	}
}
