package BUS.GuiGmail;

import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.*;
import java.util.Date;
import java.util.Properties;

public class EmailSender extends Funtion {

    private String fromEmail, password, subject, body;

    public EmailSender(String fromEmail, String password, String toEmail, String subject, String body) {
        super(toEmail);
        this.fromEmail = fromEmail;
        this.password = password;
        this.subject = subject;
        this.body = body;
    }

    public boolean sendEmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp-mail.outlook.com"); // SMTP Host của Outlook
        props.put("mail.smtp.port", "587"); // Cổng TLS của Outlook
        props.put("mail.smtp.auth", "true"); // Bật xác thực
        props.put("mail.smtp.starttls.enable", "true"); // Bật TLS

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(fromEmail));
            msg.setSubject(subject, "UTF-8");
            msg.setText(body, "UTF-8");
            msg.setSentDate(new Date());
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));

            Transport.send(msg);
            JOptionPane.showMessageDialog(null, "Gửi Email Thành Công !");
            System.out.print("Đã Gửi Email Thành Công !");
            return true; // Trả về true nếu email được gửi thành công
        } catch (MessagingException ex) {
            JOptionPane.showMessageDialog(null, "Gửi Email Không Thành Công ! kiểm tra kết nối.");
            System.out.print("Đã Gửi Email thất bại !");
            return false; // Trả về false nếu có lỗi khi gửi email
        }
    }
}
