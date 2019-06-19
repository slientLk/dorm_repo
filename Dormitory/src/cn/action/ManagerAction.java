package cn.action;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.DormManager;
import cn.dao.DormManagerDao;

public class ManagerAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DormManagerDao dormManagerDao = new DormManagerDao();
	private ArrayList<DormManager> list;
	private String id;
	private int page = 1; // 当前页
	private int pageSize = 8; // 每页最大记录数
	private int totalCnt; // 总记录数
	private int pageCnt; // 总页数
	private DormManager manager;
	private String strKey;
	private String strType;

	public String select() {
		list = dormManagerDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = dormManagerDao.select(page, pageSize, pageCnt);
		dormManagerDao.closeConn();
		if(list != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public String add1() {
		list = dormManagerDao.selectById(manager.getId());
		if(list.size() == 0) {
			boolean flag = dormManagerDao.add(manager.getId(), manager.getPassword(), manager.getUsername(), manager.getGender() ,manager.getTelephone(),"upload/userImg.png");
			if(flag) {
				JOptionPane.showMessageDialog(null,"增加成功","结果",JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			}else {
				JOptionPane.showMessageDialog(null,"增加失败","结果",JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else {
			JOptionPane.showMessageDialog(null,"该宿管已存在！","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		}
	}
	
	public String current1() {
		list = dormManagerDao.selectById(id);
		dormManagerDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String update1() {
		boolean flag = dormManagerDao.update(manager);
		if (flag) {
			JOptionPane.showMessageDialog(null,"修改成功","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null,"修改失败","结果",JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String delete1() {
		boolean flag = dormManagerDao.delete(id);
		if (flag) {
			JOptionPane.showMessageDialog(null,"删除成功","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null,"删除失败","结果",JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String query1() {
		list = dormManagerDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = dormManagerDao.query(strType, strKey,page, pageSize, pageCnt);
		dormManagerDao.closeConn();
		if(list != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public DormManagerDao getDormManagerDao() {
		return dormManagerDao;
	}

	public void setDormManagerDao(DormManagerDao dormManagerDao) {
		this.dormManagerDao = dormManagerDao;
	}

	public ArrayList<DormManager> getList() {
		return list;
	}

	public void setList(ArrayList<DormManager> list) {
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

	public DormManager getManager() {
		return manager;
	}

	public void setManager(DormManager manager) {
		this.manager = manager;
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
