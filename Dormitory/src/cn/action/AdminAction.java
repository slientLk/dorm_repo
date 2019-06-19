package cn.action;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Admin;
import cn.dao.AdminDao;

public class AdminAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = new AdminDao();
	private ArrayList<Admin> list;
	private String id;
	private int page = 1; // 当前页
	private int pageSize = 8; // 每页最大记录数
	private int totalCnt; // 总记录数
	private int pageCnt; // 总页数
	private Admin admin;
	private String strKey;
	private String strType;

	public String select() {
		list = adminDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = adminDao.select(page, pageSize, pageCnt);
		adminDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String current2() {
		list = adminDao.selectById(id);
		adminDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String update2() {
		boolean flag = adminDao.update(admin);
		if (flag) {
			JOptionPane.showMessageDialog(null, "修改成功", "结果", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null, "修改失败", "结果", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String add2() {
		list = adminDao.selectById(admin.getUsername());
		if(list.size() == 0) {
			boolean flag = adminDao.add(admin.getUsername(), admin.getPassword(),admin.getStatus(),"upload/userImg.png");
			if(flag) {
				JOptionPane.showMessageDialog(null,"增加成功","结果",JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			}else {
				JOptionPane.showMessageDialog(null,"增加失败","结果",JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else{
			JOptionPane.showMessageDialog(null,"该管理员已存在！","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		}
	}
	
	public String delete2() {
		boolean flag = adminDao.delete(id);
		if (flag) {
			JOptionPane.showMessageDialog(null,"删除成功","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null,"删除失败","结果",JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String query2() {
		list = adminDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = adminDao.query(strType, strKey,page, pageSize, pageCnt);
		adminDao.closeConn();
		if(list != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public ArrayList<Admin> getList() {
		return list;
	}

	public void setList(ArrayList<Admin> list) {
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageCnt() {
		return pageCnt;
	}

	public void setPageCnt(int pageCnt) {
		this.pageCnt = pageCnt;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getStrKey() {
		return strKey;
	}

	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}

	public String getStrType() {
		return strType;
	}

	public void setStrType(String strType) {
		this.strType = strType;
	}

}
