package cn.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Admin;
import cn.bean.DormManager;
import cn.bean.Student;
import cn.dao.AdminDao;
import cn.dao.DormManagerDao;
import cn.dao.StuDao;

public class LoginAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String type;
	private ArrayList<Student> list1;
	private ArrayList<DormManager> list2;
	private ArrayList<Admin> list3;
	private String sign;
	private Map<String, Object> session = ServletActionContext.getContext().getSession();

	public String login() {
		if ("0".equals(type)) {
			StuDao stuDao = new StuDao();
			boolean flag = stuDao.confirm(id);
			if (flag) {
				list1 = stuDao.login(id, password);
				session.put("list", list1);
				session.put("type", type);
				stuDao.closeConn();
				if (list1 != null) {
					return SUCCESS;
				}else{
					sign = "用户名或密码错误";
					return INPUT;
				}
			} else {
				sign = "用户名或密码错误！";
				return INPUT;
			}
		} else if ("1".equals(type)) {
			DormManagerDao dormManagerDao = new DormManagerDao();
			boolean flag = dormManagerDao.confirm(id);
			if (flag) {
				list2 = dormManagerDao.login(id, password);
				session.put("list", list2);
				session.put("type", type);
				dormManagerDao.closeConn();
				if(list2 != null) {
					return SUCCESS;
				}else{
					sign = "用户名或密码错误";
					return INPUT;
				}
			} else {
				sign = "用户名或密码错误！";
				return INPUT;
			}
		} else if ("2".equals(type)) {
			AdminDao adminDao = new AdminDao();
			boolean flag = adminDao.confirm(id);
			if(flag) {
				list3 = adminDao.login(id, password);
				session.put("list", list3);
				session.put("type", type);
				adminDao.closeConn();
				if(list3 != null) {
					return SUCCESS;
				}else{
					sign = "用户名或密码错误";
					return INPUT;
				}
			}else {
				sign = "用户名或密码错误";
				return INPUT;
			}
		}
		return NONE;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<Student> getList1() {
		return list1;
	}

	public void setList1(ArrayList<Student> list1) {
		this.list1 = list1;
	}

	public ArrayList<DormManager> getList2() {
		return list2;
	}

	public void setList2(ArrayList<DormManager> list2) {
		this.list2 = list2;
	}

	public ArrayList<Admin> getList3() {
		return list3;
	}

	public void setList3(ArrayList<Admin> list3) {
		this.list3 = list3;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
