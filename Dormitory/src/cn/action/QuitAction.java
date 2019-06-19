package cn.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class QuitAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	public String quit() {
		Map<String, Object> session = ServletActionContext.getContext().getSession();
		Object list = session.remove("list");
		if(list != null) {
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
}
