package com.zking.ssm.util;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class PageAspect {

    @Around("execution(* *..*Service.*Pager(..))")
    public Object invoke(ProceedingJoinPoint args) throws Throwable {

        Object[] params=args.getArgs();
        PageBean pageBean=null;

        for (Object p:params
             ) {
            if (p instanceof PageBean){
                pageBean=(PageBean)p;
                break;
            }
        }

        if (null!=pageBean && pageBean.isPagination()){
            PageHelper.startPage(pageBean.getPage(),pageBean.getRows());
        }

        Object proceed = args.proceed(params);

        if (null!=pageBean && pageBean.isPagination()){
            List lst= (List) proceed;
            PageInfo pageInfo=new PageInfo(lst);
            pageBean.setTotal(pageInfo.getTotal()+"");
            System.out.println("当前页码："+pageInfo.getPageNum());
            System.out.println("总数："+pageInfo.getTotal());
            System.out.println("每页显示："+pageInfo.getPageSize());
        }

        return proceed;
    }
}
