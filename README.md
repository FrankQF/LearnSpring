# AOP #

##aop有几个术语##
切面，建言（advice），切点，连接点
---

AOP存在的目的是为了解耦，aop可以让一组类共享相同的行为，在oop中之恩能够通过继承和实现接口，来使代码的耦合度增强，且继承只能为单继承，阻碍更多行为天交道一组类上，aop满足oop的不足

Spring支持AspectJ的注解式切面编程

- 使用@Aspect声明是一个**切面**
- 使用@After，@Before，@Around定义**建言**（advice），可直接将拦截规则（**切点**）作为参数。
- 其中@After，@Before，@Around参数的拦截规则作为切点（PointCut），为了使切点复用，可以使用@PointCut专门定义拦截规则，然后在@After，@Before@Around的参数中调用。
- 其中符合条件的每一个拦截处作为**连接点**（JointPoint）

---
说白了的意思为：在一个类上用@Aspect注解，定义一个切面；在里面的方法上添加@After，@Before，@Around注解（建言），并在注解上添加参数，作为一个个切点，在这些注解后面添加拦截规则；方法的入参为PointCut。Spring管理的类符合这些拦截规则，则执行这些方法，可以通过入参使用反射获得执行方法的信息。