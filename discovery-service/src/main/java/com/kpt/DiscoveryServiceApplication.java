package com.kpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.context.event.EventListener;

import com.netflix.appinfo.InstanceInfo;

@EnableEurekaServer
@SpringBootApplication
public class DiscoveryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServiceApplication.class, args);
	}
	
	@EventListener
	public void registerEvent(EurekaInstanceRegisteredEvent eurekaInstanceRegisteredEvent) {
		
		InstanceInfo instanceInfo = eurekaInstanceRegisteredEvent.getInstanceInfo();
		System.out.println("REGISTRATION INFO===> "+instanceInfo.getAppName());
	}
	
	//@EventListener
	public void registerEvent(EurekaInstanceCanceledEvent  eurekaInstanceCanceledEvent) {
		
		System.out.println("CANCELLATION INFO===> "+eurekaInstanceCanceledEvent.getAppName());
	}

}
