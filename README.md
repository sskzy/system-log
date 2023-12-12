#### 系统日志 

- ##### @SysLog

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
