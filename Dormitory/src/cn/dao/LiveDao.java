package cn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.bean.Live;

public class LiveDao extends BaseDao{
	ArrayList<Live> list = null;
	
	public ArrayList<Live> select() {
		Live live = null;
		list = new ArrayList<Live>();
		String sql = "select * from live";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				live = new Live();
				live.setUsername(rs.getString("username"));
				live.setBuildingId(rs.getString("buildingId"));
				live.setLivetime(rs.getDate("livetime"));
				list.add(live);
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
	
	public ArrayList<Live> select(int iPage,int iPageSize,int iPageCnt) {
		int j = 0;
		Live live = null;
		list = new ArrayList<Live>();
		String sql = "select * from live";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				live = new Live();
				live.setUsername(rs.getString("username"));
				live.setBuildingId(rs.getString("buildingId"));
				live.setLivetime(rs.getDate("livetime"));
				list.add(live);
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
	
	public ArrayList<Live> selectById(String id) {
		Live live = null;
		list = new ArrayList<Live>();
		String sql = "select * from live where username = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				live = new Live();
				live.setUsername(rs.getString("username"));
				live.setBuildingId(rs.getString("buildingId"));
				live.setLivetime(rs.getDate("livetime"));
				list.add(live);
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
	
	public boolean update(Live live) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update live set buildingId=?,livetime=? where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, live.getBuildingId());
			pstmt.setDate(2, live.getLivetime());
			pstmt.setString(3, live.getUsername());
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
	
	public boolean updateNewId(String buildingId) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update dormitory set lived_num=lived_num + 1 where buildingId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingId);
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
	
	public boolean updateOldId(String buildingId) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update dormitory set lived_num=lived_num - 1 where buildingId=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buildingId);
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
	
	public boolean add(String username,String buildingId,Date livetime) {
		boolean flag = false;
		String sql = "insert into live(username,buildingId,livetime) values(?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, buildingId);
			pstmt.setDate(3, livetime);
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
	
	public boolean updateStatus(int status,String username) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update student set status=? where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setString(2, username);
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
	
	public ArrayList<String> selectUn(){
		ArrayList<String> unList = new ArrayList<String>();
		String sql = "select username from student where status = 2";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				unList.add(rs.getString("username"));
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
		return unList;
	}
	
	public ArrayList<String> selectField(){
		ArrayList<String> fieldList = new ArrayList<String>();
		String sql = "select buildingId from dormitory";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				fieldList.add(rs.getString("buildingId"));
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
	
	public boolean delete(String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "delete from live where username=?";
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
	
	public ArrayList<Live> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		Live live = null;
		list = new ArrayList<Live>();
		int j = 0;
		String sql = "select * from live where " + strType + " like ?";
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
			sql = "select * from live";
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
				live = new Live();
				live.setUsername(live.getUsername());
				live.setBuildingId(live.getBuildingId());
				live.setLivetime(live.getLivetime());
				list.add(live);
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
