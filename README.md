# XMvp
## 一个精简的Android MVP框架，采用分层设计，分为2个module：mvpBase及mvpDomain

**mvpBase**：mvp框架接口及基类，高内聚低耦合，无其他业务；与网上流行不同的是，p层的实现放在了activity，domain的调用也放在activity，view层操作p层，这样业务可以专注生命周期的处理。

**mvpDomain**：mvp框架继承mvpbase，基类中实现了Dagger2的用法，包含usecase的基类；

**demo**：实现了mvp+Dagger2+domain的用法；

## 依赖方式
```java  
mvpbase:  compile 'com.github.ximencx:xmvp:0.1'
 
allprojects {
    repositories {
        maven { url 'https://jitpack.io' }
    }
}
```