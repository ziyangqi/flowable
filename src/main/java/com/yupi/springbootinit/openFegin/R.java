package com.yupi.springbootinit.openFegin;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 */
public class R extends HashMap<String, Object> {
    public static final int SC_UNAUTHORIZED = 401;
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R formLibraryIsEmpty() {
        return error(200, "打印模板为空,无法使用打印功能");
    }

    public static R error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static R parametersMissing() {
        return error(500, "必要参数缺失");
    }

    public static R taskIsNotEmpty() {
        return error(500, "任务ID为空");
    }

    public static R modelIsDeleted() {
        return error(500, "模型被删除");
    }

    public static R taskIsNotPrint() {
        return error(200, "当前节点没有配置模板,无法使用打印功能");
    }

    public static R processInstanceIsEmpty() {
        return error(500, "流程实例为空");
    }

    public static R processInstanceIsNotEmpty() {
        return error(500, "实例id不能为空");
    }

    public static R processInstanceFinished() {
        return error(500, "实例已经完成不能进行迁移操作");
    }

    public static R processInstanceIsSuspended() {
        return error(500, "实例已经已经挂起,不能进行迁移操作");
    }

    public static R processDefinitionNotExist() {
        return error(500, "流程定义不存在");
    }

    public static R modelrError() {
        return error(500, "模型不是标准的BPM");
    }

    public static R processDefinitionIsMaxVersion() {
        return error(500, "当前流程是最新的版本，无需操作");
    }

    public static R processInstanceIsMuli() {
        return error(500, "业务键不能重复");
    }

    public static R nodeInfoIsNotEmpty() {
        return error(500, "节点没有配置处理人信息");
    }

    public static R error(String msg) {
        return error(500, msg);
    }

    public static R unauthorized(String msg) {
        return error(SC_UNAUTHORIZED, msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }


    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
