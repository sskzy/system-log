#### 系统日志 

- ##### @SysLog

  相关接口添加@SysLog注解

  ```java
  @RestController
  @RequestMapping("msg")
  public class MsgController {
  
      @Autowired
      private MsgService msgService;
  
      @GetMapping("/select")
      @SysLog(value = "保存数据", remark = "备注", roleType = RoleType.DEFAULT, operateType = OperateType.SELECT)
      public ReturnData<Msg> select(@PathParam("msg") String msg) {
          return ReturnData.success("success", msgService.select(msg));
      }
  }
  ```

- ##### 日志打印

  ```
  打印一下日志吧! (~^v^)~: SysLogBo(value=保存数据, url=/msg/select, operateType=4, roleType=0, ip=172.25.96.1, classPath=com.example.demo.controller.MsgController, method=select, params=["hello wrold"], exec=7, remark=备注, logDateTime=2023-12-12 18:03:50)
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

  
