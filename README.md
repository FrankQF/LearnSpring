# 计划任务 #

在配置类中注解@EnableScheduling来开启对计划任务的支持，然后在要执行的计划任务的方法上注解@Scheduled声明这是一个计划任务

Spring通过@Scheduled支持多种类型的计划任务，包括cron，fixDelay,fixRate等,在Bean类的方法中添加@Scheduled，则执行计划任务

- @Scheduled(fixedRate = 5000)//fixedRate为每隔五秒执行一次
- @Scheduled(cron= "0 53 17 ? * *")////cron为指定时间执行,本例为每天17点53分执行