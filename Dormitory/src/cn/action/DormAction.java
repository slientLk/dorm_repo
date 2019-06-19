package cn.action;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Dormitory;
import cn.dao.DormitoryDao;

public class DormAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private DormitoryDao dormitoryDao = new DormitoryDao();
	private ArrayList<Dormitory> list;
	private ArrayList<String> fieldList;
	private String id;
	private int page = 1; // ��ǰҳ
	private int pageSize = 8; // ÿҳ����¼��
	private int totalCnt; // �ܼ�¼��
	private int pageCnt; // ��ҳ��
	private Dormitory dormitory;
	private String strKey;
	private String strType;

	public String select() {
		list = dormitoryDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = dormitoryDao.select(page, pageSize, pageCnt);
		dormitoryDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String current5() {
		list = dormitoryDao.selectById(id);
		dormitoryDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String beforeAdd() {
		fieldList = dormitoryDao.selectField();
		if (fieldList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String add5() {
		list = dormitoryDao.selectById(dormitory.getBuildingId());
		if(list.size() == 0) {
			boolean flag = dormitoryDao.add(dormitory.getBuildingId(), dormitory.getBuildingName(),
					dormitory.getBuildingFloor(), dormitory.getMax_num(), dormitory.getLived_num());
			if (flag) {
				JOptionPane.showMessageDialog(null, "���ӳɹ�", "���", JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			} else {
				JOptionPane.showMessageDialog(null, "����ʧ��", "���", JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else {
			JOptionPane.showMessageDialog(null, "�������Ѵ��ڣ�", "���", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		}
	}

	public String delete5() {
		int lived_num = dormitoryDao.selectNum(id);
		if(lived_num > 0) {
			JOptionPane.showMessageDialog(null, "�������µ�ס����Ϣ����ɾ����", "���", JOptionPane.PLAIN_MESSAGE);
			return INPUT;
		}else {
			boolean flag = dormitoryDao.delete(id);
			if (flag) {
				JOptionPane.showMessageDialog(null, "ɾ���ɹ�", "���", JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			} else {
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��", "���", JOptionPane.ERROR_MESSAGE);
				return ERROR;
			}
		}
	}

	public String query5() {
		list = dormitoryDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = dormitoryDao.query(strType, strKey, page, pageSize, pageCnt);
		dormitoryDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public DormitoryDao getDormitoryDao() {
		return dormitoryDao;
	}

	public void setDormitoryDao(DormitoryDao dormitoryDao) {
		this.dormitoryDao = dormitoryDao;
	}

	public ArrayList<Dormitory> getList() {
		return list;
	}

	public void setList(ArrayList<Dormitory> list) {
		this.list = list;
	}

	public ArrayList<String> getFieldList() {
		return fieldList;
	}

	public void setFieldList(ArrayList<String> fieldList) {
		this.fieldList = fieldList;
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

	public Dormitory getDormitory() {
		return dormitory;
	}

	public void setDormitory(Dormitory dormitory) {
		this.dormitory = dormitory;
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
