# mybatis version 1.0
## 1.TestMapper为什么设计成接口？
TestMappper设计成接口，是面向接口编程的需要，使框架显得直观规范
## 2.org.apache.ibatis.executor.BaseExecutor#queryFromDatabase 322行这行代码的意义?
为这个key占位，防止在大量并发请求下出现问题
## 3.MyBatis的plugin实现机制
以拦截器链依次执行的形式
## 4.lazy loading 是怎么做到的？
```
if (propertyMapping.isLazy()) {
  lazyLoader.addLoader(property, metaResultObject, resultLoader);
  value = DEFERED;
} else {
  value = resultLoader.loadResult();
}
```
