package com.xlk.inter;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xlk.entity.Student;

@FeignClient(name = "microservice-provider-user",fallback=StudentFeignClientImp.class)//服务名
public interface StudentFeignClient {

	@RequestMapping(value = "/query" ,method = RequestMethod.GET)
	public Student queryById(@RequestParam(value = "id")Long  id);
}
