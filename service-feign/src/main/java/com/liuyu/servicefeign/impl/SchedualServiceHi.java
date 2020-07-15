package com.liuyu.servicefeign.impl;

import com.liuyu.servicefeign.controller.SchedualServiceHiHystric;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//feign中自带短路器，和负载均衡
@FeignClient(value = "service-hi",/*开启feign中断路器*/fallback = SchedualServiceHiHystric.class)

//@FeignClient(value = "service-hi",fallback = SchedualServiceHiHystric.class)
public interface SchedualServiceHi {
    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFromClientOne(@RequestParam(value = "name") String name);
}
