package cn.action;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Live;
import cn.dao.LiveDao;

public class LiveAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private LiveDao liveDao = new LiveDao();
	private ArrayList<Live> list;
	private ArrayList<String> fieldList;
	private ArrayList<String> unList;
	private String id;
	private int page = 1; // 当前页
	private int pageSize = 8; // 每页最大记录数
	private int totalCnt; // 总记录数
	private int pageCnt; // 总页数
	private Live live;
	private String strKey;
	private String strType;
	private String oldId; // 旧宿舍

	public String select() {
		list = liveDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = liveDao.select(page, pageSize, pageCnt);
		liveDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String selectById2() {
		list = liveDao.selectById(id);
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String current6() {
		fieldList = liveDao.selectField();
		list = liveDao.selectById(id);
		liveDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String beforeAdd2() {
		unList = liveDao.selectUn();
		fieldList = liveDao.selectField();
		if (fieldList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String add6() {
		String username = live.getUsername();
		if(username == null || "".equals(username)) {
			JOptionPane.showMessageDialog(null, "当前没有未分配的学生", "结果", JOptionPane.WARNING_MESSAGE);
			return INPUT;
		}
		int lived_num = liveDao.selectNum(live.getBuildingId());
		if(lived_num < 6) {
			boolean flag1 = liveDao.add(username, live.getBuildingId(), live.getLivetime());
			boolean flag2 = liveDao.updateStatus(1,username);
			if (flag1 && flag2) {
				JOptionPane.showMessageDialog(null, "增加成功", "结果", JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			} else {
				JOptionPane.showMessageDialog(null, "增加失败", "结果", JOptionPane.PLAIN_MESSAGE);
				return INPUT;
			}
		}else {
			JOptionPane.showMessageDialog(null, "该宿舍已满六人！", "结果", JOptionPane.PLAIN_MESSAGE);
			return INPUT;
		}
	}

	public String update6() {
		int lived_num = liveDao.selectNum(live.getBuildingId());
		if (lived_num < 6) {
			boolean flag1 = liveDao.update(live);
			boolean flag2 = liveDao.updateNewId(live.getBuildingId());
			boolean flag3 = liveDao.updateOldId(oldId);
			if (flag1 && flag2 && flag3) {
				JOptionPane.showMessageDialog(null, "修改成功", "结果", JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			} else {
				JOptionPane.showMessageDialog(null, "修改失败", "结果", JOptionPane.ERROR_MESSAGE);
				return ERROR;
			}
		} else {
			JOptionPane.showMessageDialog(null, "该宿舍已满人", "结果", JOptionPane.ERROR_MESSAGE);
			return INPUT;
		}
	}

	public String delete6() {
		list = liveDao.selectById(id);
		String username = list.get(0).getUsername();
		boolean flag2 = liveDao.updateStatus(2,username);
		boolean flag1 = liveDao.delete(id);
		if (flag1 && flag2) {
			JOptionPane.showMessageDialog(null, "删除成功", "结果", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null, "删除失败", "结果", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}

	public String query6() {
		list = liveDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = liveDao.query(strType, strKey, page, pageSize, pageCnt);
		liveDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public LiveDao getLiveDao() {
		return liveDao;
	}

	public void setLiveDao(LiveDao liveDao) {
		this.liveDao = liveDao;
	}

	public ArrayList<Live> getList() {
		return list;
	}

	public void setList(ArrayList<Live> list) {
		this.list = list;
	}

	public ArrayList<String> getFieldList() {
		return fieldList;
	}

	public void setFieldList(ArrayList<String> fieldList) {
		this.fieldList = fieldList;
	}

	public ArrayList<String> getUnList() {
		return unList;
	}

	public void setUnList(ArrayList<String> unList) {
		this.unList = unList;
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

	public Live getLive() {
		return live;
	}

	public void setLive(Live live) {
		this.live = live;
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

	public String getOldId() {
		return oldId;
	}

	public void setOldId(String oldId) {
		this.oldId = oldId;
	}

}
