# Bean的初始化和销毁 #

在实际开发的时候，经常会遇到Bean在使用前或者使用后做些必要操作，Spring对Bean的生命周期操作提供了支持，有java配置方式和注解配置两种方式

 - Java配置：使用@Bean的initMethod和desotryMethod(相当于xml的init-method和destory-method)
 -  注解方式：利用@PostConstruct和@PreDestory

两种方式的两个操作都在初始化之后，销毁之前执行。