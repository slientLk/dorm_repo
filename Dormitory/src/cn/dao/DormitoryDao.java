package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.bean.Dormitory;

public class DormitoryDao extends BaseDao{
	ArrayList<Dormitory> list = null;
	
	public ArrayList<Dormitory> select() {
		Dormitory dormitory = null;
		list = new ArrayList<Dormitory>();
		String sql = "select * from dormitory";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				dormitory = new Dormitory();
				dormitory.setBuildingId(rs.getString("buildingId"));
				dormitory.setBuildingName(rs.getString("buildingName"));
				dormitory.setBuildingFloor(rs.getString("buildingFloor"));
				dormitory.setMax_num(rs.getInt("max_num"));
				dormitory.setLived_num(rs.getInt("lived_num"));
				list.add(dormitory);
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
	
	public ArrayList<Dormitory> select(int iPage,int iPageSize,int iPageCnt) {
		int j = 0;
		Dormitory dormitory = null;
		list = new ArrayList<Dormitory>();
		String sql = "select * from dormitory";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				dormitory = new Dormitory();
				dormitory.setBuildingId(rs.getString("buildingId"));
				dormitory.setBuildingName(rs.getString("buildingName"));
				dormitory.setBuildingFloor(rs.getString("buildingFloor"));
				dormitory.setMax_num(rs.getInt("max_num"));
				dormitory.setLived_num(rs.getInt("lived_num"));
				list.add(dormitory);
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
	
	public ArrayList<Dormitory> selectById(String id) {
		Dormitory dormitory = null;
		list = new ArrayList<Dormitory>();
		String sql = "select * from dormitory where buildingId = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				dormitory = new Dormitory();
				dormitory.setBuildingId(rs.getString("buildingId"));
				dormitory.setBuildingName(rs.getString("buildingName"));
				dormitory.setBuildingFloor(rs.getString("buildingFloor"));
				dormitory.setMax_num(rs.getInt("max_num"));
				dormitory.setLived_num(rs.getInt("lived_num"));
				list.add(dormitory);
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
	
	public int selectNum(String buildingId) {
		int lived_num = 0;
		String sql = "select lived_num from dormitory where buildingId=?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingId);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				lived_num = rs.getInt("lived_num");
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
		return lived_num;
	}
	
	public boolean add(String buildingId,String buildingName,String buildingFloor,int max_num,int lived_num) {
		boolean flag = false;
		String sql = "insert into dormitory(buildingId,buildingName,buildingFloor,max_num,lived_num) values(?,?,?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingId);
			pstmt.setString(2, buildingName);
			pstmt.setString(3, buildingFloor);
			pstmt.setInt(4, max_num);
			pstmt.setInt(5, lived_num);
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
	
	public ArrayList<String> selectField(){
		ArrayList<String> fieldList = new ArrayList<String>();
		String sql = "select buildingName from building";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				fieldList.add(rs.getString("buildingName"));
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
	
	public boolean delete(String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "delete from dormitory where buildingId=?";
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
	
	public ArrayList<Dormitory> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		Dormitory dormitory = null;
		list = new ArrayList<Dormitory>();
		int j = 0;
		String sql = "select * from dormitory where " + strType + " like ?";
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
			sql = "select * from dormitory";
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
				dormitory = new Dormitory();
				dormitory.setBuildingId(rs.getString("buildingId"));
				dormitory.setBuildingName(rs.getString("buildingName"));
				dormitory.setBuildingFloor(rs.getString("buildingFloor"));
				dormitory.setMax_num(rs.getInt("max_num"));
				dormitory.setLived_num(rs.getInt("lived_num"));
				list.add(dormitory);
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
