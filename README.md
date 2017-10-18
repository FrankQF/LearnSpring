# SpringMVC #

## 常用注解 ##


- @Controller，注解在类上，表明这个类是Spring MVC里的Controller，将其声明为Spring的一个Bean，Dispatcher Servlet会自动扫描注解了此注解的类，并将web请求映射到注解了@RequestMapping的方法上，在Spring MVC声明控制器的时候，只能用
- @RequestMapping 是用来映射 Web请求，处理类和方法的，可放在类或者方法上，注解在方法上的@RequestMapping路径会继承注册在类上的路径，@RequestMapping支持Servlet的request和response作为参数，也支持对request和response媒体类进行配置
- @ResponseBody支持返回值放在Response体内，而不是返回一个页面。此方法可以放在返回值或者方法上。
- @RequestBody允许request的参数在request体内，而不是 在直接连接在地址后面。此注解放置在参数前
- @PathVariable用来接收路径参数，如/api/001 ,可接收001
- @RestController是一个组合注解，组合了@Controller和@ResponseBody，做纯后台无前台时使用此注解。若无此注解，若想实现上述功能，需在代码中加@Controller和@ResponseBody两个注解，返回json要引用fastxml的jackson

##拦截器##
继承HandlerInterceptorAdapter类来实现自定义拦截器，实现自定义拦截器后要在配置中注入
继承HandlerInterceptorAdapter类后，通过重写preHandler和postHandler来加入前置和后置拦截请求。之后在配置类中通过	

    //重写addInterceptors方法，注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	registry.addInterceptor(demoInterceptor());
    }

##ControllerAdvice##
可以将对于控制器的全局配置放在同一个位置，注解了@Controller的类可以使用 @ExcpetionHandler，@InitBinder、@ModelAttribute注解到 方法上，这对所有注解了@RequestMapping的控制器内的方法有效

- @ExcpetionHandler全局处理控制器异常
- @InitBinder用来设置WebDataBinder，WebDataBinder用来自动绑定前台请求参数到Model中
- @ModelAttribute：@modelAttribute本来的作用是绑定键值对到Model里，此处是让全局的@RequestMapping都能获得在此处设置的键值对。

##快捷ViewController##

可以通过在配置中 重写addViewControllers来简化配置


##上传文件##
SpringMVC通过MultipartResolve来上传文件
在Spring的控制器中，通过Multipart来接收文件，通过MultipartFile[] files接收多个文件上传。

在配置Class中配置：

	//配置接收文件
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(1000000);
		return multipartResolver;
	}
**Controller**

	@RequestMapping(value = "/upload",method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartFile file) {//1
			try {
				FileUtils.writeByteArrayToFile(new File("e:/upload/"+file.getOriginalFilename()),
						file.getBytes()); //2
				return "ok";
			} catch (IOException e) {
				e.printStackTrace();
				return "wrong";
			}
	}