package aco.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
/**
 * 用于描述方法的业务操作 在拦截器OperationInterceptor中获取value
 * 
 * @author lilpilot
 *
 */
public @interface MethodDescription {
  String value() default "";

  String opeartion() default "";
}
