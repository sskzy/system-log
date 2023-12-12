#### 系统日志 

- ##### @SysLog

  相关接口添加@SysLog注解

  ```java
  @RestController
  public class MsgController {
  
      @SysLog(remark = "remark")
      @RequestMapping("/login")
      public void login(String msg) {
  
      }
  }
  ```

- ##### 日志打印

  ```
  打印一下日志吧! (~^v^)~: SysLogBo(ip=127.0.0.1, classPath=com.example.demo.controller.MsgController, method=login, params=["Hello World"], exec=0, remark=remark, logDateTime=2023-12-12 17:28:13)
  ```

- ##### 日志保存

  添加更换相关服务注入并调用相关保存方法

  ```java
  @Slf4j
  @Aspect
  @Component
  public class SysLogAspect {
  
      // 相关服务注入(保存日志)
  //    @Autowired
  //    SysLogService sysLogService;
  
      @Pointcut("@annotation(com.example.demo.annotation.SysLog)")
      public void pointcut() {
      }
  
      @Around("pointcut()")
      public Object around(ProceedingJoinPoint point) throws Throwable {
          long start = System.currentTimeMillis();
          Object result = point.proceed();
          long end = System.currentTimeMillis();
  
          SysLogBo sysLogBo = analysisLog(point, end - start);
          // 保存日志
          log.info("打印一下日志吧! (~^v^)~: {}", sysLogBo);
          return result;
      }
  }
  
  ```

  
