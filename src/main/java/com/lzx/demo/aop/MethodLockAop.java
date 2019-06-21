package com.lzx.demo.aop;

import com.lzx.demo.annotation.LzxLockDistributed;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.integration.redis.util.RedisLockRegistry;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * 描述:添加了 LzxLockDistributed 注解 的Aop
 *
 * @Auther: lzx
 * @Date: 2019/6/18 10:56
 */
@Component
@Aspect
@Slf4j
public class MethodLockAop {

    private WebApplicationContext webApplicationContext;

    public MethodLockAop(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    @Pointcut("@annotation(com.lzx.demo.annotation.LzxLockDistributed)")
    private void apiAop(){

    }

    @Around("apiAop()")
    public Object aroundApi(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        LzxLockDistributed lzxLockDistributed = method.getAnnotation(LzxLockDistributed.class);
        String localRegistry = lzxLockDistributed.value();
        if(StringUtils.isBlank(localRegistry)){
            throw new RuntimeException("获取 Registry beann 失败");
        }

        RedisLockRegistry redisLockRegistry = (RedisLockRegistry) webApplicationContext.getBean(lzxLockDistributed.value());

        Lock lock = redisLockRegistry.obtain(signature.getName());
        boolean b = false;
        for(int i =0 ; i<3;i++){
            b = lock.tryLock(lzxLockDistributed.time(), TimeUnit.SECONDS);
            if(b){
                break;
            }else {
                continue;
            }
        }
        log.info("获取锁====="+b);
        Object proceed = null;
        try{
            proceed = point.proceed();
        }catch (Exception e){
            throw e;
        }finally {
            try{
                lock.unlock();
            }catch (Exception e){
                log.error(e.getMessage(),e);
            }
        }


        return proceed;

    }

}
