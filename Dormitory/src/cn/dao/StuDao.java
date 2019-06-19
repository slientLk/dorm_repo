package cn.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.bean.Student;

public class StuDao extends BaseDao {
	ArrayList<Student> list = null;

	public boolean confirm(String id) {
		boolean flag = false;
		String sql = "select * from student where id=?";
		conn = this.getConn();
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

	public ArrayList<Student> login(String id,String password) {
		Student student = null;
		String sql = "select * from student where id = ? and password = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				student = new Student();
				list = new ArrayList<Student>();
				student.setId(rs.getString("id"));
				student.setPassword(rs.getString("password"));
				student.setUsername(rs.getString("username"));
				student.setGender(rs.getString("gender"));
				student.setLivetime(rs.getDate("livetime"));
				student.setStatus(rs.getInt("status"));
				student.setImg(rs.getString("img"));
				list.add(student);
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
	

	public boolean register(String id,String password,String username, String gender, Date date) {
		boolean flag = false;
		String sql = "insert into student(id,password,username,gender,livetime,status,img) values(?,?,?,?,?,2,'upload/userImg.png')";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			pstmt.setString(4, gender);
			pstmt.setDate(5, date);
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
	
	public ArrayList<Student> select() {
		Student student = null;
		list = new ArrayList<Student>();
		String sql = "select * from student";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setPassword(rs.getString("password"));
				student.setUsername(rs.getString("username"));
				student.setGender(rs.getString("gender"));
				student.setLivetime(rs.getDate("livetime"));
				student.setStatus(rs.getInt("status"));
				list.add(student);
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
	
	public ArrayList<Student> select(int iPage,int iPageSize,int iPageCnt) {
		int j = 0;
		Student student = null;
		list = new ArrayList<Student>();
		String sql = "select * from student";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if(iPage > iPageCnt) iPage = iPageCnt;
			if(iPage == 1) rs.beforeFirst();
			else rs.absolute((iPage - 1)*iPageSize);
			while (rs != null && rs.next()) {
				j++;
				student = new Student();
				student.setId(rs.getString("id"));
				student.setPassword(rs.getString("password"));
				student.setUsername(rs.getString("username"));
				student.setGender(rs.getString("gender"));
				student.setLivetime(rs.getDate("livetime"));
				student.setStatus(rs.getInt("status"));
				list.add(student);
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
	
	public ArrayList<Student> selectById(String id) {
		Student student = null;
		list = new ArrayList<Student>();
		String sql = "select * from student where id = ?";
		Connection conn = this.getConn();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			while (rs != null && rs.next()) {
				student = new Student();
				student.setId(rs.getString("id"));
				student.setPassword(rs.getString("password"));
				student.setUsername(rs.getString("username"));
				student.setGender(rs.getString("gender"));
				student.setLivetime(rs.getDate("livetime"));
				student.setStatus(rs.getInt("status"));
				student.setImg(rs.getString("img"));
				list.add(student);
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
	
	public boolean update(Student stu) {
		boolean flag = false;
		conn = this.getConn();
		String sql = "update student set password=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu.getPassword());
			pstmt.setString(2, stu.getId());
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
		String sql = "update student set img=? where id=?";
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
	
	public boolean add(String id,String password,String username, String gender, Date date,int status,String img) {
		boolean flag = false;
		String sql = "insert into student(id,password,username,gender,livetime,status,img) values(?,?,?,?,?,?,?)";
		Connection conn = this.getConn();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, username);
			pstmt.setString(4, gender);
			pstmt.setDate(5, date);
			pstmt.setInt(6, status);
			pstmt.setString(7, img);
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
		String sql = "update student set status=0 where id=?";
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
	
	public ArrayList<Student> query(String strType, String strKey,int iPage,int iPageSize,int iPageCnt){
		ResultSet rs = null;
		Student student = null;
		list = new ArrayList<Student>();
		int j = 0;
		String sql = "select * from student where " + strType + " like ?";
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
			sql = "select * from student";
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
				student = new Student();
				student.setId(rs.getString("id"));
				student.setPassword(rs.getString("password"));
				student.setUsername(rs.getString("username"));
				student.setGender(rs.getString("gender"));
				student.setLivetime(rs.getDate("livetime"));
				student.setStatus(rs.getInt("status"));
				list.add(student);
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
