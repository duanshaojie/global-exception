---
title: 全局异常处理类
tags: java
categories: java
---

上一篇我讲了《[Dubbo异常处理类&&自定义返回]("http://blog.duanshaojie.cn/2019/12/05/%E4%B8%AD%E9%97%B4%E4%BB%B6/Dubbo%E5%BC%82%E5%B8%B8%E5%A4%84%E7%90%86%E7%B1%BB&&%E8%87%AA%E5%AE%9A%E4%B9%89%E8%BF%94%E5%9B%9E/#more")》，
而在我们开发过程中，还有一个spring-boot的全局异常处理类，也是非常的好用，这里也记录下怎么使用吧

<!-- more -->

#   全局异常处理
*   首先我们来定义一个用户对象
```java
public class User {

    private long id;

    private String name;

    private Integer age;

    public long getId() {
        return id;
    }

    public User setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}
```
*   再来定义一个统一的返回对象
```java
public class ReturnResult {

    private Boolean result;

    private String msg;

    private Object data;

    private ReturnResult(boolean result, Object data, String message) {
        this.result = result;
        this.msg = message;
        this.data = data;
    }

    public static ReturnResult instance(boolean result, Object data, String message) {
        return new ReturnResult(result, data, message);
    }

    public Boolean getResult() {
        return result;
    }

    public ReturnResult setResult(Boolean result) {
        this.result = result;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public ReturnResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public ReturnResult setData(Object data) {
        this.data = data;
        return this;
    }
}
```
*   然后为对象编写service层的代码
```java
public interface UserService {

    User findById(Long id);
}
```
```java
@Service
public class UserServiceImpl implements UserService {

    private static final String USERID_NULL = "查询ID不能为空";
    private static final String USER_NAME = "edison";

    @Override
    public User findById(Long id) {
        if (null == id) {
            throw new BusinessException(USERID_NULL);
        }
        return new User().setId(id).setName(USER_NAME);
    }
}
```
*   再来一个controller层
```java
@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("getUser")
    public ReturnResult getUser(Long id){
        User user = userService.findById(id);
        return ReturnResult.instance(true, user, null);
    }
}
```
*   异常处理类,下面的message，throwable名字最好就这样，不然可能就无法默认打印了
```java
public class BusinessException extends RuntimeException {

    private Throwable throwable;

    private String message;

    private Integer errorCode;

    public BusinessException(String message) {
        this.message = message;
    }

    public BusinessException(String message, Integer errorCode) {
        this.message = message;
        this.errorCode = errorCode;
    }

    public BusinessException(String message, Integer errorCode, Throwable throwable) {
        this.message = message;
        this.errorCode = errorCode;
        this.throwable = throwable;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public BusinessException setThrowable(Throwable throwable) {
        this.throwable = throwable;
        return this;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public BusinessException setMessage(String message) {
        this.message = message;
        return this;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public BusinessException setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }
}

```
*   到此为止，我们已经完成了一个简单请求的项目了。如果我们请求时参数不传，客户端会因为异常而500。
返回如下:
```json
{
    "timestamp": "2019-12-05T13:07:12.888+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "查询ID不能为空",
    "path": "/user/getUser"
}
```
这个时候我们来编写一个Spring-boot的全局异常处理类，如下：
```java
@ControllerAdvice
public class GlobalException {

    private final static Logger logger = LoggerFactory.getLogger(GlobalException.class);

    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ReturnResult handleBusinessException(BusinessException e) {
        logger.error("========== SyncPrescriptionController sync BusinessException error={} ==========", e.getMessage());
        return ReturnResult.instance(false, null, e.getMessage());
    }
}
```
这里可以根据你不同的异常捕获，并进行处理，然后我们再用无参请求下这个接口：
```text
127.0.0.1:8080/user/getUser
```
结果就变成了
```json
{
    "result": false,
    "msg": "查询ID不能为空",
    "data": null
}
```

*   需要完成代码的可[点击这里]("https://github.com/duanshaojie/global-exception")

##  其他方式捕获异常
同样你也可以通过@Aspect自定义一个Around,然后catch这个过程进行异常捕获哦~~



