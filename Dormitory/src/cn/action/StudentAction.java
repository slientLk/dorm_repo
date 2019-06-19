package cn.action;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Student;
import cn.dao.LiveDao;
import cn.dao.StuDao;

public class StudentAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private StuDao stuDao = new StuDao();
	private ArrayList<Student> list;
	private String id;
	private int page = 1; // 当前页
	private int pageSize = 8; // 每页最大记录数
	private int totalCnt; // 总记录数
	private int pageCnt; // 总页数
	private Student student;
	private String strKey;
	private String strType;

	public String select() {
		list = stuDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = stuDao.select(page, pageSize, pageCnt);
		stuDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String selectById() {
		list = stuDao.selectById(id);
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String current() {
		list = stuDao.selectById(id);
		stuDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String add() {
		list = stuDao.selectById(student.getId());
		if(list.size() == 0) {
			boolean flag = stuDao.add(student.getId(), student.getPassword(), student.getUsername(), student.getGender(), student.getLivetime(), student.getStatus(),"upload/userImg.png");
			if(flag) {
				JOptionPane.showMessageDialog(null,"增加成功","结果",JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			}else {
				JOptionPane.showMessageDialog(null,"增加失败","结果",JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else {
			JOptionPane.showMessageDialog(null,"该学生已存在！","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		}
	}

	public String update() {
		boolean flag = stuDao.update(student);
		if (flag) {
			JOptionPane.showMessageDialog(null,"修改成功","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null,"修改失败","结果",JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String delete() {
		LiveDao liveDao = new LiveDao();
		list = stuDao.selectById(id);
		String username = list.get(0).getUsername();
		liveDao.delete(username);
		boolean flag1 = stuDao.delete(id);
		if (flag1) {
			JOptionPane.showMessageDialog(null,"删除成功","结果",JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null,"删除失败","结果",JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String query() {
		list = stuDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = stuDao.query(strType, strKey,page, pageSize, pageCnt);
		stuDao.closeConn();
		if(list != null) {
			return SUCCESS;
		}else {
			return ERROR;
		}
	}
	
	public ArrayList<Student> getList() {
		return list;
	}

	public void setList(ArrayList<Student> list) {
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

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
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
