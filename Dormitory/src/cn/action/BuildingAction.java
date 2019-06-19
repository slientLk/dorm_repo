package cn.action;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Building;
import cn.dao.BuildingDao;

public class BuildingAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private BuildingDao buildingDao = new BuildingDao();
	private ArrayList<Building> list;
	private ArrayList<String> fieldList;
	private String id;
	private int page = 1; // 当前页
	private int pageSize = 8; // 每页最大记录数
	private int totalCnt; // 总记录数
	private int pageCnt; // 总页数
	private Building building;
	private String strKey;
	private String strType;

	public String select() {
		list = buildingDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = buildingDao.select(page, pageSize, pageCnt);
		buildingDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String current4() {
		fieldList = buildingDao.selectField();
		list = buildingDao.selectById(id);
		buildingDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String update4() {
		boolean flag = buildingDao.update(building);
		if (flag) {
			JOptionPane.showMessageDialog(null, "修改成功", "结果", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null, "修改失败", "结果", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}
	
	public String beforeAdd3() {
		fieldList = buildingDao.selectField();
		if (fieldList != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	
	public String add4() {
		list = buildingDao.selectById(building.getBuildingName());
		if(list.size() == 0) {
			boolean flag = buildingDao.add(building.getBuildingName(), building.getUsername(), building.getLocal(),
					building.getStatus());
			if (flag) {
				JOptionPane.showMessageDialog(null, "增加成功", "结果", JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			} else {
				JOptionPane.showMessageDialog(null, "增加失败", "结果", JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else {
			JOptionPane.showMessageDialog(null, "该楼宇已存在！", "结果", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		}
	}

	public String delete4() {
		boolean flag = buildingDao.delete(id);
		if (flag) {
			JOptionPane.showMessageDialog(null, "删除成功", "结果", JOptionPane.PLAIN_MESSAGE);
			return SUCCESS;
		} else {
			JOptionPane.showMessageDialog(null, "删除失败", "结果", JOptionPane.ERROR_MESSAGE);
			return ERROR;
		}
	}

	public String query4() {
		list = buildingDao.select();
		totalCnt = list.size();
		pageCnt = (totalCnt - 1) / pageSize + 1;
		list = buildingDao.query(strType, strKey, page, pageSize, pageCnt);
		buildingDao.closeConn();
		if (list != null) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public ArrayList<Building> getList() {
		return list;
	}

	public void setList(ArrayList<Building> list) {
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

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building building) {
		this.building = building;
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
