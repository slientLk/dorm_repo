package cn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import cn.bean.Admin;

public class AdminDao extends BaseDao {
	ArrayList<Admin> list = null;

	public boolean confirm(String id) {
		boolean flag = false;
		String sql = "select * from admin where username = ?";
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

	public ArrayList<Admin> login(String id, String password) {
		Admin admin = null;
		String sql = "select * from admin where username = ? and password = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				admin = new Admin();
				list = new ArrayList<Admin>();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getInt("status"));
				admin.setImg(rs.getString("img"));
				list.add(admin);
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

	public ArrayList<Admin> select() {
		Admin admin = null;
		list = new ArrayList<Admin>();
		String sql = "select * from admin";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getInt("status"));
				list.add(admin);
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

	public ArrayList<Admin> select(int iPage, int iPageSize, int iPageCnt) {
		int j = 0;
		Admin admin = null;
		list = new ArrayList<Admin>();
		String sql = "select * from admin";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (iPage > iPageCnt)
				iPage = iPageCnt;
			if (iPage == 1)
				rs.beforeFirst();
			else
				rs.absolute((iPage - 1) * iPageSize);
			while (rs != null && rs.next()) {
				j++;
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getInt("status"));
				list.add(admin);
				if (j == iPageSize) {
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

	public ArrayList<Admin> selectById(String id) {
		Admin admin = null;
		list = new ArrayList<Admin>();
		String sql = "select * from admin where username = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getInt("status"));
				admin.setImg(rs.getString("img"));
				list.add(admin);
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
	
	public boolean update(Admin admin) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update admin set password=? where username=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, admin.getPassword());
			pstmt.setString(2, admin.getUsername());
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
	
	public boolean update(String img,String id) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update admin set img=? where username=?";
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
	
	public boolean add(String username,String password,int status,String img) {
		boolean flag = false;
		String sql = "insert into admin(username,password,status,img) values(?,?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setInt(3, status);
			pstmt.setString(4, img);
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
		String sql = "update admin set status=0 where username=?";
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
	
	public ArrayList<Admin> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		Admin admin = null;
		list = new ArrayList<Admin>();
		int j = 0;
		String sql = "select * from admin where " + strType + " like ?";
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
			sql = "select * from admin";
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
				admin = new Admin();
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				admin.setStatus(rs.getInt("status"));
				list.add(admin);
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
