package cn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.bean.DormManager;

public class DormManagerDao extends BaseDao{
	ArrayList<DormManager> list = null;
	public boolean confirm(String id) {
		boolean flag = false;
		String sql = "select * from dorm_manager where id = ?";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs != null && rs.next()) {
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
	
	public ArrayList<DormManager> login(String id,String password) {
		DormManager dormManager = null;
		String sql = "select * from dorm_manager where id = ? and password = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				dormManager = new DormManager();
				list = new ArrayList<DormManager>();
				dormManager.setId(rs.getString("id"));
				dormManager.setPassword(rs.getString("password"));
				dormManager.setUsername(rs.getString("username"));
				dormManager.setGender(rs.getString("gender"));
				dormManager.setTelephone(rs.getString("telephone"));
				dormManager.setStatus(rs.getInt("status"));
				dormManager.setImg(rs.getString("img"));
				list.add(dormManager);
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
	
	public ArrayList<DormManager> select() {
		DormManager manager = null;
		list = new ArrayList<DormManager>();
		String sql = "select * from dorm_manager";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				manager = new DormManager();
				manager.setId(rs.getString("id"));
				manager.setPassword(rs.getString("password"));
				manager.setUsername(rs.getString("username"));
				manager.setGender(rs.getString("gender"));
				manager.setTelephone(rs.getString("telephone"));
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
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
	
	public boolean update(String img,String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update dorm_manager set img=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img);
			pstmt.setString(2, id);
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
	
	public ArrayList<DormManager> select(int iPage,int iPageSize,int iPageCnt) {
		int j = 0;
		DormManager manager = null;
		list = new ArrayList<DormManager>();
		String sql = "select * from dorm_manager";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				manager = new DormManager();
				manager.setId(rs.getString("id"));
				manager.setPassword(rs.getString("password"));
				manager.setUsername(rs.getString("username"));
				manager.setGender(rs.getString("gender"));
				manager.setTelephone(rs.getString("telephone"));
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
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
	
	public boolean add(String id,String password,String username, String gender, String telephone,String img) {
		boolean flag = false;
		String sql = "insert into dorm_manager(id,password,username,gender,telephone,status,img) values(?,?,?,?,?,1,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			pstmt.setString(4, gender);
			pstmt.setString(5, telephone);
			pstmt.setString(6, img);
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
	
	public ArrayList<DormManager> selectById(String id) {
		DormManager manager = null;
		list = new ArrayList<DormManager>();
		String sql = "select * from dorm_manager where id = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				manager = new DormManager();
				manager.setId(rs.getString("id"));
				manager.setPassword(rs.getString("password"));
				manager.setUsername(rs.getString("username"));
				manager.setGender(rs.getString("gender"));
				manager.setTelephone(rs.getString("telephone"));
				manager.setStatus(rs.getInt("status"));
				manager.setImg(rs.getString("img"));
				list.add(manager);
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
	

	public boolean update(DormManager man) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update dorm_manager set password=?,telephone=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, man.getPassword());
			pstmt.setString(2, man.getTelephone());
			pstmt.setString(3, man.getId());
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
	
	public boolean delete(String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update dorm_manager set status=0 where id=?";
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
	
	public ArrayList<DormManager> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		DormManager manager = null;
		list = new ArrayList<DormManager>();
		int j = 0;
		String sql = "select * from dorm_manager where " + strType + " like ?";
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
			sql = "select * from dorm_manager";
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
				manager = new DormManager();
				manager.setId(rs.getString("id"));
				manager.setPassword(rs.getString("password"));
				manager.setUsername(rs.getString("username"));
				manager.setGender(rs.getString("gender"));
				manager.setTelephone(rs.getString("telephone"));
				manager.setStatus(rs.getInt("status"));
				list.add(manager);
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
