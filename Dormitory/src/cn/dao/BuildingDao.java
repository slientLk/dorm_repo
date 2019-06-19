package cn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.bean.Building;
import cn.bean.Building;
import cn.bean.Building;

public class BuildingDao extends BaseDao {
	ArrayList<Building> list = null;

	public ArrayList<Building> select() {
		Building building = null;
		list = new ArrayList<Building>();
		String sql = "select * from building";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				building = new Building();
				building.setBuildingName(rs.getString("buildingName"));
				building.setUsername(rs.getString("username"));
				building.setLocal(rs.getString("local"));
				building.setStatus(rs.getInt("status"));
				list.add(building);
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
//			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}
	
	public ArrayList<Building> select(int iPage,int iPageSize,int iPageCnt) {
		int j = 0;
		Building building = null;
		list = new ArrayList<Building>();
		String sql = "select * from building";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				building = new Building();
				building.setBuildingName(rs.getString("buildingName"));
				building.setUsername(rs.getString("username"));
				building.setLocal(rs.getString("local"));
				building.setStatus(rs.getInt("status"));
				list.add(building);
				if(j == iPageSize) {
					break;
				}
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
//			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}
	
	public ArrayList<String> selectField(){
		ArrayList<String> fieldList = new ArrayList<String>();
		String sql = "select username from dorm_manager";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				fieldList.add(rs.getString("username"));
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
//			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return fieldList;
	}
	
	public ArrayList<Building> selectById(String id) {
		Building building = null;
		list = new ArrayList<Building>();
		String sql = "select * from building where buildingName = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				building = new Building();
				building.setBuildingName(rs.getString("buildingName"));
				building.setUsername(rs.getString("username"));
				building.setLocal(rs.getString("local"));
				building.setStatus(rs.getInt("status"));
				list.add(building);
			}
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
//			this.closeConn();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return list;
	}
	
	public boolean update(Building building) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update building set username=? where buildingName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, building.getUsername());
			pstmt.setString(2, building.getBuildingName());
			int num = pstmt.executeUpdate();
			if (num == 1)
				flag = true;
			if (pstmt != null)
				pstmt.close();
//			if (conn != null)
//				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public boolean add(String buildingName,String username,String local,int status) {
		boolean flag = false;
		String sql = "insert into building(buildingName,username,local,status) values(?,?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingName);
			pstmt.setString(2, username);
			pstmt.setString(3, local);
			pstmt.setInt(4, status);
			int num = pstmt.executeUpdate();
			if (num == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.closeAll();
		}
		return flag;
	}
	
	public boolean delete(String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update building set status=0 where buildingName=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int num = pstmt.executeUpdate();
			if (num == 1)
				flag = true;
			if (pstmt != null)
				pstmt.close();
//			if (conn != null)
//				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public ArrayList<Building> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		Building building = null;
		list = new ArrayList<Building>();
		int j = 0;
		String sql = "select * from building where " + strType + " like ?";
		conn = this.getConn();
		if(strType != null && !strType.trim().equals("")){
			try {
				pstmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				pstmt.setString(1, "%" + strKey + "%");
				rs= pstmt.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			sql = "select * from building";
			try {
				stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				rs = stmt.executeQuery(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				building = new Building();
				building.setBuildingName(rs.getString("buildingName"));
				building.setUsername(rs.getString("username"));
				building.setLocal(rs.getString("local"));
				building.setStatus(rs.getInt("status"));
				list.add(building);
				if(j == iPageSize) {
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
