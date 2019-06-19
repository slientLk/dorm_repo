package cn.action;

import javax.swing.JOptionPane;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Student;
import cn.dao.StuDao;

public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private Student student;
	private StuDao stuDao = new StuDao();

	public String register() {
		boolean flag;
		flag = stuDao.confirm(student.getId());
		if(!flag) {
			flag = stuDao.register(student.getId(), student.getPassword(), student.getUsername(), student.getGender(), student.getLivetime());
			if(flag) {
				JOptionPane.showMessageDialog(null,"注册成功","结果",JOptionPane.PLAIN_MESSAGE);
				return SUCCESS;
			}else {
				JOptionPane.showMessageDialog(null,"注册失败","结果",JOptionPane.PLAIN_MESSAGE);
				return ERROR;
			}
		}else{
			JOptionPane.showMessageDialog(null,"该用户名已被注册！","结果",JOptionPane.PLAIN_MESSAGE);
			return INPUT;
		}
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
