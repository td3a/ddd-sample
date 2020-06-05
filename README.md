# Getting Started

### Reference Documentation
由于一直采用传统分层架构模式进行开发工作，过程中也遇到过一些问题，在此引入DDD。
1. 传统应用架构分层  
   由于结构简单，思维简单，新人容易上手，传统应用以经典三层架构为主：Controller，service，dao。
   在此模式下，大多业务代码会放在了service, 以贫血模型为最佳实践。如某块业务逻辑有一定的复杂性，那么此业务的代码会过于臃肿，
   随业务迭代，一个方法上百行，一个类几千行，更改业务会倍加小心，甚至于不敢去轻易修改某个方法，在漫长的迭代过程中，
   缺少有效的治理维护方法，会严重影响系统稳定性，以至于发展成危楼。  
      
2. 领域驱动设计, DDD: 结合了整洁架构，六边形架构   
   以业务模型做为关注点，建立业务部门与IT部门都能理解的通用模型，以此模型来进行转化为实现。领域模型实现多以贫血模型或充血模型。
   把领域模型做为核心，保证核心内容稳定。在核心之上，建立应用服务层，之上为infrastructure(展现层)，
   与原有思维相反的是把数据库实现放一并归到了infrastructure。     
   逻辑归类可参考：   
   （1）事务控制不要放在领域模型的对象中实现，可以放在App Service中完成。   
   （2）领域模型对象中只保留该模型驱动的一般方法，对于业务特征明显的特异场景方法调用放在App Service中完成。
   
   

 ### Guides
此项目是基于领域驱动设计的一份实现，亦战术实现部分，在此不作战略部分说明, 包含以下子模块。

* 客户反馈 (feedback) 
* 知识库 (kbs)
* 安全生产 (safety)  
    
```
    core(共用部分)
    feedback(客户反馈)
        application(app service层)
        domain(领域层）
        gateway(网关层==infrastracture)
            acl(北向网关, 提供数据库持久化)
            ohs(南向网关，提供rest,rpc服务)
    kbs(知识库)
        application(app service层)
        domain(领域层）
        gateway(网关层==infrastracture)
            acl(北向网关, 提供数据库持久化)
            ohs(南向网关，提供rest,rpc服务)
    safety(安全知识)
        application(app service层)
        domain(领域层）
        gateway(网关层==infrastracture)
            acl(北向网关, 提供数据库持久化)
            ohs(南向网关，提供rest,rpc服务)
    start-app (项目启动类，聚合了其他项目)        
        StartApplication(SpringBoot启动类)


```

### 说明
    在实际项目过程中如有其他想法，再做其他具体说明更新


    
    










