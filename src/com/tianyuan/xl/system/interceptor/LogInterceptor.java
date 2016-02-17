package com.tianyuan.xl.system.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.tianyuan.xl.common.mapper.JsonMapper;
import com.tianyuan.xl.common.utils.DateUtils;
import com.tianyuan.xl.common.utils.Global;
import com.tianyuan.xl.system.entity.Log;
import com.tianyuan.xl.system.entity.User;
import com.tianyuan.xl.system.service.LogService;
import com.tianyuan.xl.system.service.UserService;
import com.tianyuan.xl.system.utils.IPUtil;
import com.tianyuan.xl.system.utils.UserUtil;
import eu.bitwalker.useragentutils.UserAgent;

/**
 * 日志拦截器
 * @author ty
 * @date 2015年1月14日
 */
public class LogInterceptor implements HandlerInterceptor {

	@Autowired
	private LogService logService;
	
	@Autowired
	private UserService userService;
	
	private Long beginTime;// 1、开始时间
	private Long endTime;// 2、结束时间
	
	private List<String> excludeUrls;// 不需要拦截的资源


	public List<String> getExcludeUrls() {
		return excludeUrls;
	}

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludeUrls = excludeUrls;
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		beginTime = System.currentTimeMillis();//计时
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String url = requestUri.substring(contextPath.length());
		User userSessionInfo = (User) request.getSession().getAttribute(Global.getConfig("userSessionInfo"));
//		//判断是否包含在菜单权限里

		if (excludeUrls.contains(url)) {// 如果要访问的资源是不需要验证的
			return true;
		}
		
		if ((userSessionInfo == null) || (userSessionInfo.getId() == null)) {// 如果没有登录或登录超时
			request.setAttribute("msg", "您还没有登录或登录已超时，请重新登录，然后再刷新本功能！");
			request.getRequestDispatcher("/WEB-INF/views/error/noSession.jsp").forward(request, response);
			return false;
		}
		return true;
	}

	public void postHandle(HttpServletRequest request,HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		endTime = System.currentTimeMillis();
		String requestRri = request.getRequestURI();
		String uriPrefix = request.getContextPath();
		String operationCode=StringUtils.substringAfter(requestRri,uriPrefix);	//操作编码
		
		String requestParam=(new JsonMapper()).toJson(request.getParameterMap());	//请求参数
		
		//如果是GET请求，请求编码包含create，update(添加修改页)不记录日志
		if(request.getMethod().equals("GET")){
			if(operationCode.contains("create")||operationCode.contains("update")){
				return;
			}
		}
		Long executeTime=endTime-beginTime;
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent")); 
		String os=userAgent.getOperatingSystem().getName();	//获取客户端操作系统
		String browser=userAgent.getBrowser().getName();	//获取客户端浏览器
		
		Log log=new Log();
		log.setOs(os);
		log.setBrowser(browser);
		log.setIp(IPUtil.getIpAddress(request));
		log.setOperationCode(operationCode);
		log.setExecuteTime(Integer.valueOf(executeTime.toString()));
		log.setCreater(UserUtil.getCurrentUser().getName());
		log.setCreateDate(DateUtils.getSysTimestamp());
		//log.setDescription(LogCodeUtil.matchingOperationCode(operationCode));
		log.setRequestParam(requestParam);
		
		//放到一公共变量里，定时提交
		//logService.save(log);
	}

}
