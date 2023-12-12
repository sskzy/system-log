package com.example.demo.aspect;

import com.alibaba.fastjson2.JSONObject;
import com.example.demo.annotation.SysLog;
import com.example.demo.domain.SysLogBo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : songtc
 * @since : 2023/12/12 16:23
 */
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

    /**
     * 分析获取日志数据
     *
     * @param point    切点信息
     * @param interval 执行时间
     * @return 日志数据
     */
    private SysLogBo analysisLog(ProceedingJoinPoint point, Long interval) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();

        SysLogBo sysLogBo = new SysLogBo();
        sysLogBo.setExec(interval);
        sysLogBo.setLogDateTime(LocalDateTime.now());
        sysLogBo.setRemark(method.getAnnotation(SysLog.class).remark());
        sysLogBo.setClassPath(point.getTarget().getClass().getName());
        sysLogBo.setMethod(method.getName());
        sysLogBo.setParams(JSONObject.toJSONString(point.getArgs()));
        return sysLogBo;
    }

}
