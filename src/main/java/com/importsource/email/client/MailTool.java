package com.importsource.email.client;

import javax.activation.FileDataSource;

import com.importsource.conf.Properties;
import com.importsource.conf.PropertiesTools;
import com.importsource.email.AbstractEmail;
import com.importsource.email.AttachEmail;
import com.importsource.email.Configuration;
import com.importsource.email.ImageEmail;
import com.importsource.email.SimpleEmail;

/**
 * 邮件工具类
 * @author Hezf
 *
 */
public class MailTool {
	
	/**
	 * 测试邮件发送是否正常。发送纯文本(标题和正文一样)
	 * @param text 标题
	 * @param content 内容
	 * @param receiver 接收人
	 */
	public static void test() {
		AbstractEmail mail = new SimpleEmail();
		String testMsg="importsource.xemail test";
		try {
			Properties p=Configuration.newPropertiesInstance();
			String from=PropertiesTools.get(p, "xemail.from", "");
			mail.send(testMsg, testMsg, null, from);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 发送纯文本(标题和正文一样)
	 * @param subject 标题
	 * @param content 内容
	 * @param receiver 接收人
	 */
	public static void sendText(String text, String receiver) {
		AbstractEmail mail = new SimpleEmail();
		try {
			mail.send(text, text, null, receiver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 发送纯文本
	 * @param subject 标题
	 * @param content 内容
	 * @param receiver 接收人
	 */
	public static void sendText(String subject, String content, String receiver) {
		AbstractEmail mail = new SimpleEmail();
		try {
			mail.send(subject, content, null, receiver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 发送带附件的
	 * @param subject 标题
	 * @param content 内容
	 * @param fileDataSource 附件
	 * @param receiver 接收人
	 */
	public static void sendAttach(String subject, String content, FileDataSource fileDataSource, String receiver) {
		AbstractEmail mail = new AttachEmail();
		try {
			mail.send(subject, content, null, receiver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
	/**
	 * 发送正文带图片的
	 * @param subject 标题
	 * @param content 内容
	 * @param fileDataSource 图片
	 * @param receiver 接收人
	 */
	public static void sendImage(String subject, String content, FileDataSource fileDataSource, String receiver) {
		AbstractEmail mail = new ImageEmail();
		try {
			mail.send(subject, content, null, receiver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}