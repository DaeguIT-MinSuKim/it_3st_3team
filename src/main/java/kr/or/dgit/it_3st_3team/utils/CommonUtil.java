package kr.or.dgit.it_3st_3team.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import kr.or.dgit.it_3st_3team.dto.User;

public class CommonUtil {
	private static CommonUtil instance = new CommonUtil();

	public static CommonUtil getInstance() {
		return instance;
	}

	private CommonUtil() {
	}

	// 전화번호를 하이픈(-) 넣은 걸로 재생성해줌
	public String phoneNumberHyphenAdd(String num, boolean mask) {

		String formatNum = "";
		num = num.replaceAll("-", "");

		if (num.length() == 11) {
			if (mask) {
				formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-****-$3");
			} else {
				formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
			}
		} else if (num.length() == 8) {
			formatNum = num.replaceAll("(\\d{4})(\\d{4})", "$1-$2");
		} else {
			if (num.indexOf("02") == 0) {
				if (mask) {
					formatNum = num.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-****-$3");
				} else {
					formatNum = num.replaceAll("(\\d{2})(\\d{3,4})(\\d{4})", "$1-$2-$3");
				}
			} else {
				if (mask) {
					formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-****-$3");
				} else {
					formatNum = num.replaceAll("(\\d{3})(\\d{3,4})(\\d{4})", "$1-$2-$3");
				}
			}
		}
		return formatNum;
	}
	
	public String createRandomPassword() {
		char[] arrPwdWord = new char[] {
				'1','2','3','4','5','6','7','8','9','0',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
				'!','@','#','$','%','^','&','*','(',')'
		};
		
		StringBuilder returnPwd = new StringBuilder();
		
		for (int i = 0; i < 10; i++) {
			int selectRndPwdWord = (int) (Math.random() * arrPwdWord.length);
			returnPwd.append(arrPwdWord[selectRndPwdWord]);
		}
		
		return returnPwd.toString();
	}
	
	private boolean sendMailBySSL(Map<String, String> mailContent) {
		Properties props = new Properties();
		props.put("mail.smtp.host",					"smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port",	"465");
		props.put("mail.smtp.socketFactory.class",	"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth",					"true");
		props.put("mail.smtp.port",					"465");

		Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(mailContent.get("sendMailId"),mailContent.get("sendMailPwd"));
				}
			});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailContent.get("sendMail"), mailContent.get("sendMailName"),"utf-8"));
			message.setRecipients(Message.RecipientType.TO,
					new InternetAddress[] { new InternetAddress(mailContent.get("toMail"), mailContent.get("toMailName"),"utf-8") });
			message.setSubject(mailContent.get("subject"));
			message.setText(mailContent.get("content"));

			Transport.send(message);

			return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void sendFindPwdMail(User user) {
		Map<String, String> mailContent = new HashMap<>();
		mailContent.put("sendMailId", "sendmail.yuma");
		mailContent.put("sendMailPwd", "eorndkdlxl3wh"); // 대구아이티3조
		mailContent.put("sendMail", "sendmail.yuma@gmail.com");
		mailContent.put("sendMailName", "소프트웨어 관리자");
		mailContent.put("toMail", user.getEmail());
		mailContent.put("toMailName", user.getName());
		mailContent.put("subject", "[소프트웨어] 임시 비밀번호 발송 메일!");
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("임시 비밀 번호는 %s 입니다.", user.getUserPwd()));
		mailContent.put("content", sb.toString());
		
		if ( ! sendMailBySSL(mailContent)) {
			System.err.println("관리자에게 문의!!");
		}
		JOptionPane.showMessageDialog(null, "임시 비밀번호를 메일로 발송하였습니다.");
	}
	
	public void userImgSave(String userImgFullPath) {
		File imgFile = new File(userImgFullPath);
		File copyFile = new File(DefineUtil.IMG_PATH + imgFile.getName());
		try (FileInputStream fis = new FileInputStream(imgFile);
				FileOutputStream fos = new FileOutputStream(copyFile);) {

			byte[] c = new byte[512];
			while (fis.read(c) != -1) {
				fos.write(c);
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "사진을 저장하지 못했습니다.");
		}
	}
	
	public boolean checkPwd(JPasswordField pwd1, JPasswordField pwd2) {
		if (Arrays.equals(pwd1.getPassword(), pwd2.getPassword())) {
			return true;
		}
		return false;
	}
}
