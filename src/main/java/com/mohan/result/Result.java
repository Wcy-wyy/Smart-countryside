package com.mohan.result;



/**
 * 返回对象结构 <br/>
 */
public class Result {

    /**
     * 成功状态码
     */
    public static final String CODE_SUCCESS = "200";
    /**
     * 会话过期状态码
     */
    public static final String CODE_SESSION_EXPIRED = "201";
    /**
     * Controller层入参校验失败状态码
     */
    public static final String CODE_PARAM_FAILURE = "400";
    /**
     * 接口降级、熔断状态码
     */
    public static final String CODE_REQUEST_DEMOTE = "502";
    /**
     * 数据库操作异常，比较严重
     */
    public static final String CODE_SQL_FAILURE = "503";
    /**
     * 运行时异常，比较严重
     */
    public static final String CODE_RUNTIME_EXP_FAILURE = "504";
    /**
     * 默认结果值
     */
    public static final String DATA_DEFAULT = null;

    /**
     * 返回状态码，统一值说明：
     * 0：本次请求成功
     * 1：会话过期
     * 2：入参校验失败
     * 3：系统降级返回值
     * n：其它系统业务状态码
     */
    private String code;
    /**
     * 状态码中文信息，主要用于友好提示UI端用户
     */
    private String message;
    /**
     * 结果集对象
     */
    private Object data;

    private String sign;

    private Long reqTime;

    private Long resTime;

    public Result() {
    }

    public Result(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.resTime = System.currentTimeMillis();
    }

    public Result(String code, String message, Object data, String sign) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
        this.sign = sign;
        this.resTime = System.currentTimeMillis();
    }

    /**
     * @Title: success
     * @Description: 接口成功
     * @param: @return
     * @return: Result
     */
    public static Result success() {
        return success(DATA_DEFAULT);
    }

    /**
     * @Title: success
     * @Description: 接口成功，返回结果集
     * @param: @param data
     * @param: @return
     * @return: Result
     */
    public static Result success(Object data) {
        return success("操作成功", data);
    }

    public static Result success(Object data, String sign) {
        Result res = success(data);
        res.setSign(sign);
        return res;
    }

    /**
     * @throws
     * @Title: success
     * @Description: 接口成功，返回消息及结果集
     * @param: @param message
     * @param: @param data
     * @param: @return
     * @return: Result
     */
    public static Result success(String message, Object data) {
        return success(CODE_SUCCESS, message, data);
    }


    /**
     * 成功返回list类型增加rows
     *
     * @param code
     * @param message
     * @param data
     * @return
     */
    public static Result success(String code, String message, Object data) {
        return new Result(code, message, data);
    }


    /**
     * @throws
     * @Title: failure
     * @Description:返回错误的状态码和错误消息
     * @param: @param code
     * @param: @param message
     * @param: @return
     * @return: Result
     */
    public static Result failure(String code, String message) {
        return failure(code, message, DATA_DEFAULT);
    }

    public static Result failure() {
        return failure("400", "系统内部错误", DATA_DEFAULT);
    }
    public static Result failure(String message) {
        return failure("400", message, DATA_DEFAULT);
    }

    /**
     * @throws
     * @Title: failure
     * @Description:返回错误的状态码、错误消息和结果集
     * @param: @param code
     * @param: @param message
     * @param: @param data
     * @param: @return
     * @return: Result
     */
    public static Result failure(String code, String message,
                                       Object data) {
        return new Result(code, message, data);
    }

    /**
     * @throws
     * @Title: failureVaildation
     * @Description:入参校验失败，返回错误消息
     * @param: @param message
     * @param: @return
     * @return: Result
     */
    public static Result failureVaildation(String message) {
        return failure(CODE_PARAM_FAILURE, message);
    }

    /**
     * @throws
     * @Title: failureSession
     * @Description:会话过期，返回错误消息
     * @param: @param message
     * @param: @return
     * @return: Result
     */
    public static Result failureSession(String message) {
        return failure(CODE_SESSION_EXPIRED, message);
    }

    /**
     * @throws
     * @Title: failureHystrix
     * @Description:接口降级，断路器返回错误消息
     * @param: @param message
     * @param: @return
     * @return: Result
     */
    public static Result failureHystrix(String message) {
        return failure(CODE_REQUEST_DEMOTE, message);
    }

    /**
     * @throws
     * @Title: failureSql
     * @Description:数据库操作异常，返回错误消息
     * @param: @param message
     * @param: @return
     * @return: Result
     */
    public static Result failureSql(String message) {
        return failure(CODE_SQL_FAILURE, message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public Long getReqTime() {
        return reqTime;
    }

    public void setReqTime(Long reqTime) {
        this.reqTime = reqTime;
    }

    public Long getResTime() {
        return resTime;
    }

    public void setResTime(Long resTime) {
        this.resTime = resTime;
    }

}