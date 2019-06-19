package cn.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import cn.action.LoginAction;
import cn.action.RegisterAction;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> session = invocation.getInvocationContext().getSession();
		Object list = session.get("list");
		if(list != null) {
			invocation.invoke();
		}else {
			ActionSupport action = (ActionSupport) invocation.getAction();
			if(action != null && (action instanceof LoginAction || action instanceof RegisterAction)) {
				invocation.invoke();
			}else {
				return "login";
			}
		}
		return null;
		
	}

}
