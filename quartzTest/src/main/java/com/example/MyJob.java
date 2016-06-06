package com.example;

import java.io.Serializable;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.service.IService;

@Component("service")
@DisallowConcurrentExecution
public class MyJob extends QuartzJobBean implements Serializable{

	private IService service;
	
	public void setMetier(IService service) {
		this.service = service;
	}
	
	private String someParam;
    private int someParam2;

    public void setSomeParam(String someParam) {
        this.someParam = someParam;
    }

    public void setSomeParam2(int someParam2) {
        this.someParam2 = someParam2;
    }


	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
		 service.sayHello();
		System.out.println("My job is running with "+someParam+' '+someParam2);
	}
}
