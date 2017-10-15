# Profile #

profile 为在不同环境下使用不同的配置提供支持，

- 通过设定Environment的ActiveProfiles来设定当前context需要使用的配置环境。在开发中使用@Profile注解类或方法，达到不同情况下实例化不同的Bean
- 通过蛇精jvm的spring.profiles.active参数来设置配置环境
- Web项目设置在Servlet的context parameter中
	- servlet2.5
	- <init-param>
		<param-name>spring.profiles.active</param-name><param-value>production</param-value></init-param>