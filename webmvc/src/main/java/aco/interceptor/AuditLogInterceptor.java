package aco.interceptor;

import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.aco.model.User;

public class AuditLogInterceptor extends HandlerInterceptorAdapter {

	private static final Logger log = LogManager.getLogger(AuditLogInterceptor.class);
	ThreadLocal<Long> time = new ThreadLocal<>();


	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String username = user.getUsername();
		MDC.put("user", username);
		MDC.put("userId","111");
		MDC.put("ip", request.getRemoteAddr());
		MDC.put("path", request.getServletPath());
		HandlerMethod handlerMethod = null;
		MethodDescription annotation = null;
		if (handler instanceof HandlerMethod) {
			handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			annotation = method.getAnnotation(MethodDescription.class);
		}

		String flag = annotation != null ? annotation.opeartion() : "未知标签";
		String value = annotation != null ? annotation.value() : "未知方法";
		Map<String, String> conditionMap = getConditions(request, flag);
		MDC.put("conditions", conditionMap.get("conditions"));
		MDC.put("operation", value);
		MDC.put("modular", conditionMap.get("flag"));
		String loginName = username;
		try {
			log.debug("操作人员：{}, 操作：{}, 访问IP：{}", loginName, value, request.getRemoteAddr());
		} catch (Exception ex) {
			log.info("日志写入异常");
		}
		MDC.clear();
		time.set(System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {

		log.info("ip:{},操作人员：{}, 操作：{}, 访问路径：{}, 操作时间：{}ms", request.getRemoteAddr(), MDC.get("user"),
				MDC.get("operation"), MDC.get("path"), Long.toString(System.currentTimeMillis() - time.get()));
	}

	/**
	 * 根据标记进行操作条件存储
	 * 
	 * @param request
	 * @param flag
	 * @return conditions
	 */
	public Map<String, String> getConditions(HttpServletRequest request, String flag) {
		Map<String, String> result = new HashMap<>();
		String conditions = "";

		switch (flag) {
		case "login":// 登录时条件滞空
			result.put("flag", "0");
			result.put("conditions", "");
			break;
		case "add":// 根据条件添加
			conditions = devideConditions(request);
			result.put("flag", "2");
			result.put("conditions", conditions);
			break;
		case "addById":
			conditions = getIdCondition(request);
			result.put("flag", "2");
			result.put("conditions", conditions);
			break;
		case "edit":// 根据条件修改
			conditions = devideConditions(request);
			result.put("flag", "3");
			result.put("conditions", conditions);
			break;
		case "delete":// 根据条件删除
			conditions = devideConditions(request);
			result.put("flag", "4");
			result.put("conditions", conditions);
			break;
		case "deleteById":// 根据id删除
			conditions = getIdCondition(request);
			result.put("flag", "4");
			result.put("conditions", conditions);
			break;
		case "searchById":// 根据id查找
			conditions = getIdCondition(request);
			result.put("flag", "1");
			result.put("conditions", conditions);
			break;
		case "search":// 根据给予条件查找
			conditions = devideConditions(request);
			result.put("flag", "1");
			result.put("conditions", conditions);
			break;
		default:
			result.put("flag", "-1");
			result.put("conditions", conditions);
			break;
		}

		return result;
	}

	public String devideConditions(HttpServletRequest request) {
		String conditions = "";
		List<String> Strings = new LinkedList<>();
		Enumeration paramNames = request.getParameterNames();
		while ((paramNames != null) && paramNames.hasMoreElements()) {
			String paraName = (String) paramNames.nextElement();
			if (paraName.contains("columns")) {
				continue;
			}
			Strings.add(paraName + "=" + request.getParameter(paraName));

		}
		conditions = String.join(",", Strings);
		return conditions;
	}

	public String getIdCondition(HttpServletRequest request) {
		String id = "";
		List<String> Strings = new LinkedList<>();
		Map deletePathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Set<Map.Entry<String, String>> set = deletePathVariables.entrySet();
		for (Map.Entry entry : set) {
			Strings.add(entry.getKey() + "=" + entry.getValue());
		}
		id = String.join(",", Strings);
		return id;
	}


	public String randomTime() {
		// java.text.SimpleDateFormat sdf = new
		// java.text.SimpleDateFormat("ddHHmmssSSS");
		// String date = sdf.format(new Date());
		int num = ThreadLocalRandom.current().nextInt();
		int n2 = (int) (Math.random() * 99);
		return String.valueOf(num) + String.valueOf(n2);
	}
}
