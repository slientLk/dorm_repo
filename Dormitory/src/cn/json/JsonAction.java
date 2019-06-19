package cn.json;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import cn.dao.AdminDao;
import cn.dao.DormManagerDao;
import cn.dao.StuDao;
import net.sf.json.JSONObject;

public class JsonAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private String id;
	private String password;
	private String type;
	private JSONObject json;

	public String confirm() {
		Map<String, Object> map = new HashMap<String, Object>();
		if ("0".equals(type)) {
			StuDao stuDao = new StuDao();
			boolean flag = stuDao.confirm(id);
			if (flag) {
				map.put("msg", "���û������ڣ��������¼!");
			} else {
				map.put("msg", "���û��������ڣ�");
			}
			json = JSONObject.fromObject(map);// ��map����ת����json��������
		} else if ("1".equals(type)) {
			DormManagerDao dormManagerDao = new DormManagerDao();
			boolean flag = dormManagerDao.confirm(id);
			if (flag) {
				map.put("msg", "���û������ڣ��������¼!");
			} else {
				map.put("msg", "���û��������ڣ�");
			}
			json = JSONObject.fromObject(map);// ��map����ת����json��������
		} else if ("2".equals(type)) {
			AdminDao adminDao = new AdminDao();
			boolean flag = adminDao.confirm(id);
			if (flag) {
				map.put("msg", "���û������ڣ��������¼!");
			} else {
				map.put("msg", "���û��������ڣ�");
			}
			json = JSONObject.fromObject(map);// ��map����ת����json��������
		}
		return SUCCESS;
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

	public JSONObject getJson() {
		return json;
	}

	public void setJson(JSONObject json) {
		this.json = json;
	}

}
