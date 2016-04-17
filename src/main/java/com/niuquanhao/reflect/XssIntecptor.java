package com.niuquanhao.reflect;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by quanhao.nqh on 2016/4/17.
 */
public class XssIntecptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        Map<String, Object> model = modelAndView.getModel();
        for (Map.Entry<String, Object> entry : model.entrySet()) {
            Object modelValue = entry.getValue();
            if (modelValue != null){
                if (modelValue.getClass().equals(String.class)){  //如果对我输出的是string，则进行转码后输出
                    entry.setValue( StringEscapeUtils.escapeHtml((String) modelValue));
                }else {//  因为我们需要过滤的是string，则其他model中可能含有sring
                    filter(modelValue);
                }
            }
        }
        super.postHandle(request, response, handler, modelAndView);
    }

    public static void filter(Object object) throws Exception {
        if (object == null){
            return;
        }
        //
        if (object instanceof List) {
            List list = (List) object;
            for (int i = 0; i <list.size() ; i++) {
                Object listElement = list.get(i);
                if (listElement.getClass().equals(String.class)){
                    list.set(i , "dddd");
                }else {
                    filter(listElement);
                }
            }
        } else if (object instanceof Map) {
            Map map = (Map) object;
            Collection values = map.values();
            Object[] objects = values.toArray();
            filterArr(objects);
        } else if (object.getClass().isArray()) {
            Object[] objects = (Object[]) object;
            filterArr(objects);
        } else if (!isJavaClass(object.getClass())) {//如果是用户自己定义的业务类。
            Field[] declaredFields = object.getClass().getDeclaredFields();
            for (Field declaredField : declaredFields) {
                /*
                 * 如果是静态的成员，则不进行过滤，因为静态成员不会是从db读取的
                 * 如果是final类型变量，也不进行过滤
                 */
                if (Modifier.isStatic(declaredField.getModifiers()) || Modifier.isFinal(declaredField.getModifiers())) {
                    return;
                }
                if (declaredField.getType().equals(String.class)) {//  如果属性是string则进行设置
                    declaredField.setAccessible(true);
                    String oldValue = (String) declaredField.get(object);
                    declaredField.set(object, StringEscapeUtils.escapeHtml(oldValue));
                } else {
                    filter(declaredField.get(object));
                }

            }

        }
    }

    public static boolean isJavaClass(Class<?> clz) {
        return clz != null && clz.getClassLoader() == null;
    }
    private static void filterArr(Object[] objectArr)throws Exception{
        for (int i = 0; i < objectArr.length; i++) {
            Object arrElem = objectArr[i];
            if (arrElem.getClass().equals(String.class)) {
                objectArr[i] = "替换后的";
            } else {
                filter(arrElem);
            }
        }

    }

}
