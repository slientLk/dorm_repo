package cn.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.bean.Admin;
import cn.bean.DormManager;
import cn.bean.Student;
import cn.dao.AdminDao;
import cn.dao.DormManagerDao;
import cn.dao.StuDao;

public class UploadAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private File photo;
	private String photoContentType;
	private String photoFileName;
	private String savePath;
	private String type;
	private String id;
	private StuDao stuDao = new StuDao();
	private DormManagerDao dormManagerDao = new DormManagerDao();
	private AdminDao adminDao = new AdminDao();
	private Map<String, Object> session = ServletActionContext.getContext().getSession();

	public String upload() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath(savePath) + "\\" + photoFileName;
		File upload = new File(path);
		if (!upload.exists()) {
			upload.getParentFile().mkdir();
		}
		if (copy(photo, upload)) {
			int lastIndex = path.lastIndexOf("\\");
			savePath = "upload/" + path.substring(lastIndex + 1);
			if ("0".equals(type)) {
				boolean flag = stuDao.update(savePath, id);
				ArrayList<Student> stuList = stuDao.selectById(id);
				if (flag && stuList != null) {
					session.put("list", stuList);
					JOptionPane.showMessageDialog(null, "头像上传成功", "结果", JOptionPane.PLAIN_MESSAGE);
					return SUCCESS;
				} else {
					JOptionPane.showMessageDialog(null, "头像上传失败", "结果", JOptionPane.PLAIN_MESSAGE);
					return ERROR;
				}
			} else if ("1".equals(type)) {
				boolean flag = dormManagerDao.update(savePath, id);
				ArrayList<DormManager> manList = dormManagerDao.selectById(id);
				if (flag && manList != null) {
					session.put("list", manList);
					JOptionPane.showMessageDialog(null, "头像上传成功", "结果", JOptionPane.PLAIN_MESSAGE);
					return SUCCESS;
				} else {
					JOptionPane.showMessageDialog(null, "头像上传失败", "结果", JOptionPane.PLAIN_MESSAGE);
					return ERROR;
				}
			} else if ("2".equals(type)) {
				boolean flag = adminDao.update(savePath, id);
				ArrayList<Admin> adminList = adminDao.selectById(id);
				if (flag && adminList != null) {
					session.put("list", adminList);
					JOptionPane.showMessageDialog(null, "头像上传成功", "结果", JOptionPane.PLAIN_MESSAGE);
					return SUCCESS;
				} else {
					JOptionPane.showMessageDialog(null, "头像上传失败", "结果", JOptionPane.PLAIN_MESSAGE);
					return ERROR;
				}
			}
		}

		return INPUT;
	}

	private boolean copy(File photo, File upload) throws Exception {
		// TODO Auto-generated method stub
		InputStream is = null;
		OutputStream os = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;

		try {
			is = new FileInputStream(photo);
			os = new FileOutputStream(upload);
			bis = new BufferedInputStream(is);
			bos = new BufferedOutputStream(os);

			int b;
			while ((b = bis.read()) != -1) {
				bos.write(b);
			}

			bis.close();
			bos.close();

			return true;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "上传头像不可为空！", "结果", JOptionPane.PLAIN_MESSAGE);
			return false;
		}
	}

	public File getPhoto() {
		return photo;
	}

	public void setPhoto(File photo) {
		this.photo = photo;
	}

	public String getPhotoContentType() {
		return photoContentType;
	}

	public void setPhotoContentType(String photoContentType) {
		this.photoContentType = photoContentType;
	}

	public String getPhotoFileName() {
		return photoFileName;
	}

	public void setPhotoFileName(String photoFileName) {
		this.photoFileName = photoFileName;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public StuDao getStuDao() {
		return stuDao;
	}

	public void setStuDao(StuDao stuDao) {
		this.stuDao = stuDao;
	}

	public DormManagerDao getDormManagerDao() {
		return dormManagerDao;
	}

	public void setDormManagerDao(DormManagerDao dormManagerDao) {
		this.dormManagerDao = dormManagerDao;
	}

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
