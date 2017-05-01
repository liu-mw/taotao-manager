package com.taotao.test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import com.taotao.common.utils.FtpUtil;

public class FTPTest {
	@Test
	public void testFtpClient() throws Exception{
		FTPClient ftpClient = new FTPClient();
		ftpClient.connect("192.168.18.128",21);
		ftpClient.login("ftpuser", "ftpuser");
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\ASUS\\Desktop\\图片\\u=1350614941,725003865&fm=117&gp=0.jpg"));
		ftpClient.changeWorkingDirectory("/home/ftpuser/images/www");
		ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
		ftpClient.storeFile("hello.jpg", inputStream);
	}
	@Test
	public void testFileUtil()throws Exception{
		FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\ASUS\\Desktop\\图片\\u=1350614941,725003865&fm=117&gp=0.jpg"));
		FtpUtil.uploadFile("192.168.18.128", 21, "ftpuser", "ftpuser", "/home/ftpuser/images/www", "2017/4/3", "heihei.jpg", inputStream);
	}
}
