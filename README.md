# 事件（Application Event） #

Srping的事件，为Bean与Bean之间的消息通信提供了支持。当一个Bean处理完一个任务之后，希望另外一个Bean知道并能做相应的处理，这时我们就需要让另外一个Bean监听当前Bean所发送的事件。
Spring的之间西药遵循如下流程

1. 自定义事件，继承 ApplicationEvent
2. 自定义事件监听器，实现ApplicationListener<E extends ApplicationEvent> 接口，容器监听到有自定义事件后，会调用onApplicationEvent方法推送事件到此方法
3. 使用容器发布事件（调用容器监管的类，使用applicationContext.publishEvent发送自定义事件，事件监听器会接收到事件）