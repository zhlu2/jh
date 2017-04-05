package aco.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.subject.Subject;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.aco.model.User;


public class OperationInterceptor implements HandlerInterceptor {

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    System.out.println("preHandle");
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {
    System.out.println("postHandle");
    HttpSession session = request.getSession();
    User user =  (User) session.getAttribute("user");
    String username = user.getUsername();
    System.out.println("ip : " + request.getRemoteAddr());
    System.out.println("username : " + username);
    System.out.println("request path : " + request.getServletPath());

    // 拦截@MethodDescription注解 获取业务操作描述
    HandlerMethod handlerMethod = (HandlerMethod) handler;
    Method method = handlerMethod.getMethod();
    MethodDescription annotation = method.getAnnotation(MethodDescription.class);
    if (annotation != null) {
      System.out.println("method decription : " + annotation.value());
    }
  }

  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
      Object handler, Exception ex) throws Exception {
    System.out.println("afterCompletion");
  }

}
