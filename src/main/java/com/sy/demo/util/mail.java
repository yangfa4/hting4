package com.sy.demo.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class mail {
public void SendMail(String usermail,String username) {
	 try {
	       
         /*
         *Properties是一个属性对象，用来创建Session对象
         */
         Properties props = new Properties();
         props.setProperty("mail.smtp.host", "smtp.qq.com");
         props.setProperty("mail.smtp.port", "25");
         props.setProperty("mail.smtp.auth", "true");
         props.setProperty("mail.smtp.ssl.enable", "false");//"true"
         props.setProperty("mail.smtp.connectiontimeout", "5000");
         final String user = "962006028@qq.com";//用户名
         final String pwd = "syhetkyonvlebeef";//密码
         /*
         *Session类定义了一个基本的邮件对话。
         */
         
         Session session = Session.getInstance(props, new Authenticator() {
             @Override
             protected PasswordAuthentication getPasswordAuthentication() {
                 //登录用户名密码
                 return new PasswordAuthentication(user,pwd);
             }
         });
         session.setDebug(true);
         /*
         *Transport类用来发送邮件。
         *传入参数smtp，transport将自动按照smtp协议发送邮件。
         */
         Transport transport = session.getTransport("smtp");//"smtps"
         transport.connect("smtp.qq.com",user,pwd);
         /*
         *Message对象用来储存实际发送的电子邮件信息
         */
         MimeMessage message = new MimeMessage(session);
         message.setSubject("用户注册");
         //消息发送者接收者设置(发件地址，昵称)，收件人看到的昵称是这里设定的
         message.setFrom(new InternetAddress(user,"韩汀社区"));
         message.addRecipients(Message.RecipientType.TO,new InternetAddress[]{
             //消息接收者(收件地址，昵称)
             //不过这个昵称貌似没有看到效果
                 new InternetAddress(usermail,username),
         });
         message.saveChanges();

         //设置邮件内容及编码格式
         //后一个参数可以不指定编码，如"text/plain"，但是将不能显示中文字符
         String img="<img src='data:img/jpg;base64,iVBORw0KGgoAAAANSUhEUgAAANwAAAByCAIAAAC3LihIAAAACXBIWXMAAAsTAAALEwEAmpwYAAA5\r\n" + 
         		"rGlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0w\r\n" + 
         		"TXBDZWhpSHpyZVN6TlRjemtjOWQiPz4KPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRh\r\n" + 
         		"LyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMwNjcgNzkuMTU3NzQ3LCAyMDE1LzAzLzMw\r\n" + 
         		"LTIzOjQwOjQyICAgICAgICAiPgogICA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMu\r\n" + 
         		"b3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPgogICAgICA8cmRmOkRlc2NyaXB0aW9uIHJk\r\n" + 
         		"ZjphYm91dD0iIgogICAgICAgICAgICB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94\r\n" + 
         		"YXAvMS4wL21tLyIKICAgICAgICAgICAgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20v\r\n" + 
         		"eGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiCiAgICAgICAgICAgIHhtbG5zOnN0RXZ0PSJodHRw\r\n" + 
         		"Oi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvc1R5cGUvUmVzb3VyY2VFdmVudCMiCiAgICAgICAgICAg\r\n" + 
         		"IHhtbG5zOnhtcD0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wLyIKICAgICAgICAgICAgeG1s\r\n" + 
         		"bnM6ZGM9Imh0dHA6Ly9wdXJsLm9yZy9kYy9lbGVtZW50cy8xLjEvIgogICAgICAgICAgICB4bWxu\r\n" + 
         		"czpwaG90b3Nob3A9Imh0dHA6Ly9ucy5hZG9iZS5jb20vcGhvdG9zaG9wLzEuMC8iCiAgICAgICAg\r\n" + 
         		"ICAgIHhtbG5zOnRpZmY9Imh0dHA6Ly9ucy5hZG9iZS5jb20vdGlmZi8xLjAvIgogICAgICAgICAg\r\n" + 
         		"ICB4bWxuczpleGlmPSJodHRwOi8vbnMuYWRvYmUuY29tL2V4aWYvMS4wLyI+CiAgICAgICAgIDx4\r\n" + 
         		"bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ+eG1wLmRpZDoxMGE0NjIzMy0zZTVkLTU0NDAtODhmMC01\r\n" + 
         		"YmY3ODEyZWExNDM8L3htcE1NOk9yaWdpbmFsRG9jdW1lbnRJRD4KICAgICAgICAgPHhtcE1NOkRv\r\n" + 
         		"Y3VtZW50SUQ+eG1wLmRpZDo4MzY4MjVFMTk4RUUxMUU2QUY0OEJGRDQxRjdBNUM3NTwveG1wTU06\r\n" + 
         		"RG9jdW1lbnRJRD4KICAgICAgICAgPHhtcE1NOkluc3RhbmNlSUQ+eG1wLmlpZDo5MDQyNDdlZi0z\r\n" + 
         		"ZjU5LWVkNDAtODkyOC01OGEyYWU1ODE2MjU8L3htcE1NOkluc3RhbmNlSUQ+CiAgICAgICAgIDx4\r\n" + 
         		"bXBNTTpEZXJpdmVkRnJvbSByZGY6cGFyc2VUeXBlPSJSZXNvdXJjZSI+CiAgICAgICAgICAgIDxz\r\n" + 
         		"dFJlZjppbnN0YW5jZUlEPnhtcC5paWQ6NmM2ZTM3YjEtYzdhMy00YzRkLTg1MjgtMDc4NGE1ZTBj\r\n" + 
         		"Nzc3PC9zdFJlZjppbnN0YW5jZUlEPgogICAgICAgICAgICA8c3RSZWY6ZG9jdW1lbnRJRD54bXAu\r\n" + 
         		"ZGlkOjEwYTQ2MjMzLTNlNWQtNTQ0MC04OGYwLTViZjc4MTJlYTE0Mzwvc3RSZWY6ZG9jdW1lbnRJ\r\n" + 
         		"RD4KICAgICAgICAgPC94bXBNTTpEZXJpdmVkRnJvbT4KICAgICAgICAgPHhtcE1NOkhpc3Rvcnk+\r\n" + 
         		"CiAgICAgICAgICAgIDxyZGY6U2VxPgogICAgICAgICAgICAgICA8cmRmOmxpIHJkZjpwYXJzZVR5\r\n" + 
         		"cGU9IlJlc291cmNlIj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OmFjdGlvbj5zYXZlZDwvc3RF\r\n" + 
         		"dnQ6YWN0aW9uPgogICAgICAgICAgICAgICAgICA8c3RFdnQ6aW5zdGFuY2VJRD54bXAuaWlkOjkw\r\n" + 
         		"NDI0N2VmLTNmNTktZWQ0MC04OTI4LTU4YTJhZTU4MTYyNTwvc3RFdnQ6aW5zdGFuY2VJRD4KICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgPHN0RXZ0OndoZW4+MjAxNy0wNi0yMVQxMTo1NDo0NSswODowMDwvc3RF\r\n" + 
         		"dnQ6d2hlbj4KICAgICAgICAgICAgICAgICAgPHN0RXZ0OnNvZnR3YXJlQWdlbnQ+QWRvYmUgUGhv\r\n" + 
         		"dG9zaG9wIENDIDIwMTUgKFdpbmRvd3MpPC9zdEV2dDpzb2Z0d2FyZUFnZW50PgogICAgICAgICAg\r\n" + 
         		"ICAgICAgICA8c3RFdnQ6Y2hhbmdlZD4vPC9zdEV2dDpjaGFuZ2VkPgogICAgICAgICAgICAgICA8\r\n" + 
         		"L3JkZjpsaT4KICAgICAgICAgICAgPC9yZGY6U2VxPgogICAgICAgICA8L3htcE1NOkhpc3Rvcnk+\r\n" + 
         		"CiAgICAgICAgIDx4bXA6Q3JlYXRvclRvb2w+QWRvYmUgUGhvdG9zaG9wIENDIDIwMTUgKFdpbmRv\r\n" + 
         		"d3MpPC94bXA6Q3JlYXRvclRvb2w+CiAgICAgICAgIDx4bXA6Q3JlYXRlRGF0ZT4yMDE3LTA2LTIx\r\n" + 
         		"VDExOjM1OjA5KzA4OjAwPC94bXA6Q3JlYXRlRGF0ZT4KICAgICAgICAgPHhtcDpNb2RpZnlEYXRl\r\n" + 
         		"PjIwMTctMDYtMjFUMTE6NTQ6NDUrMDg6MDA8L3htcDpNb2RpZnlEYXRlPgogICAgICAgICA8eG1w\r\n" + 
         		"Ok1ldGFkYXRhRGF0ZT4yMDE3LTA2LTIxVDExOjU0OjQ1KzA4OjAwPC94bXA6TWV0YWRhdGFEYXRl\r\n" + 
         		"PgogICAgICAgICA8ZGM6Zm9ybWF0PmltYWdlL3BuZzwvZGM6Zm9ybWF0PgogICAgICAgICA8cGhv\r\n" + 
         		"dG9zaG9wOkNvbG9yTW9kZT4zPC9waG90b3Nob3A6Q29sb3JNb2RlPgogICAgICAgICA8dGlmZjpP\r\n" + 
         		"cmllbnRhdGlvbj4xPC90aWZmOk9yaWVudGF0aW9uPgogICAgICAgICA8dGlmZjpYUmVzb2x1dGlv\r\n" + 
         		"bj43MjAwMDAvMTAwMDA8L3RpZmY6WFJlc29sdXRpb24+CiAgICAgICAgIDx0aWZmOllSZXNvbHV0\r\n" + 
         		"aW9uPjcyMDAwMC8xMDAwMDwvdGlmZjpZUmVzb2x1dGlvbj4KICAgICAgICAgPHRpZmY6UmVzb2x1\r\n" + 
         		"dGlvblVuaXQ+MjwvdGlmZjpSZXNvbHV0aW9uVW5pdD4KICAgICAgICAgPGV4aWY6Q29sb3JTcGFj\r\n" + 
         		"ZT42NTUzNTwvZXhpZjpDb2xvclNwYWNlPgogICAgICAgICA8ZXhpZjpQaXhlbFhEaW1lbnNpb24+\r\n" + 
         		"MjIwPC9leGlmOlBpeGVsWERpbWVuc2lvbj4KICAgICAgICAgPGV4aWY6UGl4ZWxZRGltZW5zaW9u\r\n" + 
         		"PjExNDwvZXhpZjpQaXhlbFlEaW1lbnNpb24+CiAgICAgIDwvcmRmOkRlc2NyaXB0aW9uPgogICA8\r\n" + 
         		"L3JkZjpSREY+CjwveDp4bXBtZXRhPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"IAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAog\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAK\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"IAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAog\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAK\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAKICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgIAogICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgCiAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAg\r\n" + 
         		"ICAgICAgICAgICAgICAKICAgICAgICAgICAgICAgICAgICAgICAgICAgIAo8P3hwYWNrZXQgZW5k\r\n" + 
         		"PSJ3Ij8+E9f3UAAAACBjSFJNAAB6JQAAgIMAAPn/AACA6QAAdTAAAOpgAAA6mAAAF2+SX8VGAAAV\r\n" + 
         		"ZUlEQVR42uydeXwURdrHn+qeOzOZTO5MEhJCIOQgXMoRAsglCIIKrAiyElwV3QV1ZV0PBFk8V13d\r\n" + 
         		"RfBVV8GLQxZYDoFwE24C5OBKgrlD7mPuo6dnpt4/ZjLTCTNJCORleK3vH/l0T1d3V+f5zVNPPVVd\r\n" + 
         		"gzDGQCD4EhT5FxCIKAkEIkoCESWBQERJIKIkEIgoCUSUBAIRJYFAREkgoiQQiCgJRJQEAhElgYiS\r\n" + 
         		"QCCiJBBREghElAQCESWBiLIHwRibdUZiNiJKHwIhxDJsTWEVsRwRpQ8hC5ZnbztenvMrMR4RpS81\r\n" + 
         		"4jb79lU/EuMRUfoQ/dJTmirqNXUqYj8iSl9BIpcCQN6+bGI/IkpfQd+swQCXD14g9iOi9BUaK+oR\r\n" + 
         		"QE1Bpa5JS0xIROkTaOpVrRstxIRElD5BQ1mdY4MxmIkJiSjvPozBXJFX7Ni2sVZiQiLKu8+Nq+Vg\r\n" + 
         		"dy5fSPFoYkIiyrtP9rYTrm2hRERMSER59yk6cdm1LQ3yJyYkorzL5P5y1mJiHNuyYLk8XEFMSER5\r\n" + 
         		"l8lan+naTho3iKLIfFAiyrtKSXZhQ2mta7fPsARiv/+X8O6huh5Ys8O1jSjULy2lzWHzJTDlAtAg\r\n" + 
         		"HgqiRGJaIsr/CzdZdbkMAyAAAEgcO0AgETqPYSOu/AOoNzuPYYDADBS9nliXiLIHsdvsm17/hvvJ\r\n" + 
         		"uGceaVWkGRcMAbbIrUgAaPkOWypRn8PEwCSm7Cm2LFtnUOmg1U1GD4iNTIpyarLuHdxOkQgAARiO\r\n" + 
         		"QMv3xMBElD1CQVb+pf3nUavkAGD6a0+2ukkdNPwDgfsY95eqcMtaYmAiyjuPSWvc/Nq/odUDAkBU\r\n" + 
         		"SmxUci/nYUs5AOPUIgZAgLgu05QDdpOjYKMuS2cuIvYmorwD/PDSGpZhuS5w9qoMjjOkHY11Gy26\r\n" + 
         		"H04OiO/YrNHsNLN1xN5ElLfLkX/vqcgr4brJtHkTQntHuEsI44BWYE4JjN3byH8GIB4AsHZ9nXa/\r\n" + 
         		"RNiL2JuI8rYoPV906ItdmOP+ZEH+D7/6eJtCSITC3nGWwK1qxK3qDHnVUaq4YY3OXOQn6E3sTUTZ\r\n" + 
         		"fQxq/fdLPuf6SAD43btPeyga/Cckm+QUIvfBor4AUZJj+1rtcrl4ADE2EeVt8dXCjy0MyxXZsNlj\r\n" + 
         		"4kd4HqdBcQeQ8hMQJyNaBvwQkE1EcUcg6AXH0au1qzDgXoFPEmPfKyAf/L3v/yxfn/vLWWhtkxFA\r\n" + 
         		"UHTo0l3vdH6mXQeID8g9ybLZkH3sehrGMKH/OYVkKLH3PYHPjegcW7fPpUhX2/3st0u75vdl3D0j\r\n" + 
         		"e+NE8UQMIOZHEUWS5rubVF0uO/D5jnau+3fvLPQPCbjVS2lMV44U3G+1GQFDsvJvxNLEU3aT7xav\r\n" + 
         		"drfZjlBy1ujBD4+41etUNP9wofI5jK0AIBP2iw1aQCxNRNkdtr79vUlrBACEnLKMTIx59K35t3QR\r\n" + 
         		"xtqYW7X4hmqbcwQcw6j4ncTMRJTdoSzn15xdp7mhJF/Iz1i75NYu0vTNldrljLXR5Wjvj10vFfbt\r\n" + 
         		"iQo3NTb4+8sFQqG3AhhjhBBR2D0cU27669ducwJggIy1L/opZF08vdlw9tj1cRerXmCsjc7zMaQo\r\n" + 
         		"340J/H0PVXhq+qi0lGSvcchXXw3v30+v0/m4+TG21Wh2sTYNEWV7sred0DdrMcdNps+f2Htov66c\r\n" + 
         		"a8dM7o0XjxalN+lPAGBXAj1F+V7/sNd7rs5yhaKqssLbUb1eV1FeLpV16Uu1e9vWpS8syj1/nvuh\r\n" + 
         		"1Wq9eumSRq127FoYxmQ0ura5JV2fd4NzZfNOl8zcmR90sGDw6ZLHWgztF7KrUm2+dONVDPbfVvNt\r\n" + 
         		"s9r2fLIFOCM30kDZtKW/61p7/e21ulUmS7VTy86Bb3R/zLo77iMxxu+8+cbenTtSBw+R+cvULS0I\r\n" + 
         		"4NGJ45sbGwGhvyx7a8r0GXMenlpVXjH4vvvKS0sAIGP2LIvFolGrpVLpI4/PmZeRcfNlWYvlT08v\r\n" + 
         		"tJjNG9atW/7+By/8+RWKos6dPDln+jST0YgAaJr2k8lCQkKEYrGFYWiaZ7EwNdXVZpMJACiEZs2d\r\n" + 
         		"t2b9d917qOjAOUHSNAx2A1OmZ4pNbHW7AjdU26vV2+NCnus4ClIZLxgsFXZ7u1V0KIQoAEBAOWbN\r\n" + 
         		"UIgf7Jcu4AX6uiiz1mdazBauKOd88EynZ5nZugsVz9RpM8F1JgZA4MePTevz3x4aVAwMDp67IEMZ\r\n" + 
         		"FRWgUFzKycEYXvzra0aDQaNSR8fEmk2mqOheI0alBwYHMxbLlfz8gUOHYowZs9lsMkkkYs8G4POz\r\n" + 
         		"cvIu5Vy8cPbsgb17Zs2bFx6h3Lppg8lonPnE3Lj4eEVgYIBCoYyKFovFD6WnhYSGfbVhQ+G1a5Wl\r\n" + 
         		"paeOZ5lMpoxFz3f7iSIDZnZcQCZKAAAKCTqKnfSnj14f08U7Doj8MCHsLx2XucsjOozB/OHk1xiD\r\n" + 
         		"2ZUFSkhPWfB5J/2b8pYf8qteZu1aZy+9dWZQL8W8Ib2+4FHSHq1zS1PTpbzcZ+c+odVq/3vwcOrg\r\n" + 
         		"wTc305m7d2XMnlXHsLfcbthsNE0zZjNFUXxBeymEC/ljJkzcsnffHXkQg6UMAc+OGTNbZ2JviPmR\r\n" + 
         		"wdLR7cpcrV1ZUPvurMEMQl5XyGkxnD9SNDI2aGG/0Jdp2o9GYoRoAIyxDYMNYxsGO41EFluLHbNi\r\n" + 
         		"foSQF+rTnjJn9xnHymkuNznz7ac6PuVy9etF9Z+0cZAAgFCKclX/sDd6tLYalWra2NFlxcVpYx9Y\r\n" + 
         		"8NwisUSSuWvnmk8+1qhVKz74+/BRo2qrbzz/+/ksy6qamwHgsUkTMbYDwEMzHln04ktduQVN0wAg\r\n" + 
         		"FHlejobP5/vL5Xcmji9/qrJlI7SJe2B475+iFU9wiwnoAIR4HSgSACSCaAAIlT3gL07uoJiIH35v\r\n" + 
         		"xJQXd50BTrJ80LQRsuCO/unnyxdWtPzo7qU7IxfByLgtEfKHe7q2BoO+uKjo1RVvL132llupanVC\r\n" + 
         		"WMjO/2wZPmqURq0Ji1D2698/7+LF8tLS0ePGmc3moitXW5qbvV2zuqpSGRXdxeSRTC6X+Xc1I1FQ\r\n" + 
         		"977efD068Ilw/yk3H/UXJQ6K/qdM2I9PK8QCZU7lH2s1e4S8EMdRtSnfzNby6QCN6QqFeM2GMwgo\r\n" + 
         		"hGiZKJFH+bWPtsEGAFa7wdGUV6m2xIculgrjuaF/btWSKckFEkGMr4uysby+pqCC6yYnL360ky+3\r\n" + 
         		"aiO0nWQuFkSO7XuY+y/w1EO3UIjPuU83CYtQBgYH796+LSc7m+bxMMY2ljUzDADcP3IkAPRPTv56\r\n" + 
         		"w0YA2L5506F9e195c1nHF9ywbt3SFxYJxeIDp88mJCV1WgGJxK+DzCiXY9fHNelPAEBFy0/3xXx7\r\n" + 
         		"85hW//A2rUqtZs+w2B9DZRMAQGsuOFTAnSqAjhY5m/UH+mUFS0fd1AW0A4BDrCZrbXHjmuLGNSPj\r\n" + 
         		"tjgC1pLG/8mtWiIRxIj5UfeAp7yw4yR3NyoltoO1gX5t+JezuUFu1yrmRU7sf8H1/fbecbbmV7/J\r\n" + 
         		"p+VJEctvp8I0TWvV6vGTp7z13nsioQghxFiY7Zs3n846NiwtjbVYss+clkj8EEWdOXEcA1y7fFkq\r\n" + 
         		"kyGEZDJZQKCHLueQYcPmLVy4a+vWSSOGfb91+7gHH+y0DgK+oPOo15DtUKSDwroPOh5o3X8tRcAL\r\n" + 
         		"7BU4V2culIn6i/jho+MzebSUpsRlTd+UN6+fkHAOA6YQ308Y5/FbDwAUEgJAVMCsaQMqLlQ8c6b0\r\n" + 
         		"8ftj1gFCuVVLlPLpI+I2dxwD+IooS7OLuG33uGemeiupNV/Lr24/UUhAKSYmnu9UkQBAU5LYoIUH\r\n" + 
         		"CwdWtmwcEbcpQDyo23UWSySns7LOnTwZrowUikSFV6/u3bkDAMpKSiaNGN7S1BSujBw4ZEhFWSkA\r\n" + 
         		"zJn6EE3TNrvdZDImp6bOmf/U3IwMbkudmJLy6Zdff/rl16ePH3dEkx3DWixdWT6JR0vb7sq8tyHs\r\n" + 
         		"kcIROnNhqGwCa9Puv5ailM9I67M9zH9ia7wYY8fWjoNFjG0AQFPO9IKYHzk6fl+t5pdTJY8CQFrc\r\n" + 
         		"NmXAI/dG8ry5qqGa03ZTNNVvVEoHOV5uCOP4O7pvZqf9OHeuW5w8MeGC3vLroYL7qtU7ul3tv769\r\n" + 
         		"0m63//zjj3OnT5uSNuLogf2q5uZVn/wjOCT0vU8/O3Xl2tELF7/ftn32k/MRwE87du46lrXr6LHN\r\n" + 
         		"u/ecPXnyleefY8ye18NOGzNm+KhRnd5dr9fZ7Z3nsf1FSb2D3LP0UyM/9FisXntwR16A1nwtQj7V\r\n" + 
         		"YCnj0dLUyI9qNLvUxjx3Dt+mc8xr6UiUYAcAhNwOTsdcL6h7L0A8MEAyuKj+43smeV6RV8rdHTR1\r\n" + 
         		"OO1lWd4G3WGN6UqbhhtDQtirtzpFMkAyqJdiXmXLxjOls8cnnA70G9aNaj+7eMmzi5cAwJI/PH3y\r\n" + 
         		"2LGvftrgjtKSkzkjAlYASB44kMfjAUDvPn0CFIpesbHeutUutm/eFK5Upo0Z67mnpddbWEtX6jk0\r\n" + 
         		"5utgabqeKY5WzLnZz1ltusOFw3XMdZoSz0htKm/+rkF3BAHVL+yVXoHz+LS7r9lportNgA8AAFdq\r\n" + 
         		"lhfWfRAsTR+feMYRG2zLFU1KzPXv8gJPd02U6rpmzgw16DvSa5hf3MBZUwABAPgJYwdEftCNmyZF\r\n" + 
         		"rHAEplnFE6an1HTQrnmocEvLhytXMBZL8oBUQOhSbo5Wo/5m7RqbzWYyGhFCqUOGjJvkDAod/qyp\r\n" + 
         		"sSE8QgkA336xVq1SZeXmddDLLispWfr8orMnT2SePuuxgGM4Uavu6jh1TJD35BpCYkFUmP+DA6M+\r\n" + 
         		"QYinMV2hW/vUIn64xnSZsTbY7RY7WOt1hwCgVrNXQAfQlJiihBTiW+1GmTCBpkQ3N+L5N5b+2vAv\r\n" + 
         		"Vy8HACYnXTlYMOhs6eMPJl32dVHWXb/BtY88zHMXh7E2OYdtwO0mUyM/7t5NpcJ4P1GcgSm12U05\r\n" + 
         		"VX8cFnsLP/D43JPzjh85HBoWfjU/X6EIrK+tNRuNB375xWDQq1UqlmXtdrtLlFarFQCsLAsAVy9d\r\n" + 
         		"Wvbnl5/902KHQG/mUOa+vTt3bFy3DgDOFhTFxsV5ERJyfDdu/5/Po6Rj+h5wx3CUs/NkYEr3Xe13\r\n" + 
         		"033pUyUz2iYvFVNTSgFErSk5kcunJoa/OTDqH+2uMCkx795ovhvL6gAAY+c6AlIv6ckG3SE7btNg\r\n" + 
         		"8emAyIDHun3fAPEgA1MKGCpVmxIj3pIJu7rI5SvL3lq9bp1LWE9Mm3oq69iWfZkeCzsGpmX+8ob6\r\n" + 
         		"uiVPZyx8/oV3P/3MQwdOo0lLTmpqbHB0erZmHggK8dpv+/Jf/8QAfRPv/CqHGFsRIACgKFGK8h2x\r\n" + 
         		"IFrECxPyQni0H02JARBr07I2tdFSpTFdUhlzEsPf4DYyGLMAUNWyyczWCmiFxaY2WMpsNoMNm+3Y\r\n" + 
         		"Yscsn/Ln0/6sTYsQhQFjbMXYOsBLpHs3Ralt0kDrfF4ejxbLPA8NG5iydm23Uj79du4rE/Z1hUBl\r\n" + 
         		"Td+mRn7UxRNHpKdzd2tqqlnW6yiiWtUCAAxjFoslm37ZExYe4a0vnz5+/JX8vMnTHl7+fpuAJCc7\r\n" + 
         		"++effugVExsSGqrVao9kZh45sJ+m6edffvmO28JmN9kwAwBivrJd/tLVoQaAIL+R0YrHPWTrGj8H\r\n" + 
         		"gOLGtcWNax0uk0/JEaKdOSCMMdjs2GK0uH+lnUICXxQlyxkXpng05SUhoreUchUJGCIVM2/nvla7\r\n" + 
         		"0dlhwtCgO9Lt65SVlHSQxJFKZUKRKCBAIRAKZf5efy2Az+d/+YPnEMLhMr9evbqurtbx6FOmz3j9\r\n" + 
         		"b6uUkVF33BZGS4XV1v2pnxTwlPIZsUEL5JJUIR3cQaSuZ4rrtPvVxrzEiGW+2HxTFHKJzWaxWi2e\r\n" + 
         		"vY5zASBOwtyva0NV3lOeV91dB8sNjG1dT+py+feGjSKx2NvRl19/49klS7o4+uK5m9K7999Xr/n7\r\n" + 
         		"6jVGg4FlWT+p1NGR7wlighYoJPd1+/TUqK6G+FJhfHxIvO/GlCI/MWNkUGtf1ag2eBz1RoCcPtL9\r\n" + 
         		"97Zyq2pjrqvDZLGpGWuTiB/WjetMmT6jg6OKoCBFUNAd+UdJ/Px62hYxgfPBl7hryXNFZBubaRs8\r\n" + 
         		"/6K8iK+8ua3p9k2rVD9bbCpXZg2D1Y4ZIPgYd02UkcmxraEdAIBBpfdYzE/Q2/XOjaNoeXM31+e1\r\n" + 
         		"2Y25VUu47+/yKL+uJYcJvw1RhsVFQOtK0ADQVFHvJQqJc7fdAIChRr2jGy86WWyqo0WjLdYWV1AA\r\n" + 
         		"AAI6qKdnBBPuJVH2GdbfnegCuHTwgmft+k+iaTE4skeOFSiR/VTpjFu6l8p48VDhELUp331DDAAg\r\n" + 
         		"F6cSBRBRugmMCokZ1Me121Rer21Ue0ia0AERsqnAfdMRoEl36nTJTDvu/GUDE1udX/2Xw4XDuUky\r\n" + 
         		"19WUAdOJAogo2/DA0w9xlNbm52m59A19CQAAY3cEiqBGs2v/1cSi+o8Ya9PNp1jt+sqWTdnlT+27\r\n" + 
         		"0vfX+n9yhejOO1DSaMUcogAf5C6/OPbpYyuayp3RpEgmWXH8M4/FThRPqdce4tTaLTKalviLEsX8\r\n" + 
         		"KIkgym5njWyVma0xMpXOXnb7x3WfOCjqs/jQJUQBRJTtqcgv+SrDPdA3a+WCoY+kefJ8uj2Xe7N2\r\n" + 
         		"dRufx3mPkfMhgg6eqHVYKNDv/vEJZ4j5SfPtgZiBfcZkTHYpbfdHmz1OYuVRsrH9DnuQV9sY0dnK\r\n" + 
         		"c3v1iLuNHAEATYlHx+8jtiei9MqUl2YmPTDQIRuLkfn5jW89FgsQDxzdZx+NJO1/XAy8vBCG237e\r\n" + 
         		"WlLICx2fcIZPBxDbE1F2xPzP/pgw2rmmxeUDF45/t99jsTD/SZOTrgT7jfLgINFNirx5G+NQ2fjJ\r\n" + 
         		"SZfl4hRieF+GXrlypS/UY9BDw7QN6prCSgAoPlcQ3jcqNM7DdC8+LY8NWsijpDrmujuF7pqugTjq\r\n" + 
         		"RG2cpZ8wLjlixeDoNTQlIVYnHZ1bIGfX6d0f/exYM+PRZU8Om+11hRqMbTfU28qavlGb8iy2Fm++\r\n" + 
         		"k0/JAySD+wQvilLMvv33vgm/RVECgL5Zm7n6v44FVO97dFSnq7hY7foG3VGV8byZbbDa9HZgKCTg\r\n" + 
         		"IT8hP1QhGRIqm8B9DYpARNl9KvJKzv0nK2/vOVmw/KE/zxo0dTgxFRGlT2BQ6Q58vqP2+o2weGVC\r\n" + 
         		"+oDEsak0n0dsRkTpE+TtPadv1kYkRAdGBssjAruySgSBiJJAuGMQl0MgoiQQiCgJRJQEAhElgYiS\r\n" + 
         		"QCCiJBBREghElAQCESWBiJJAIKIkEFESCESUBCJKAoGIkkBESSAQURIIRJQEIkoCgYiSQERJIBBR\r\n" + 
         		"En5j/O8ADn8/28a126UAAAAASUVORK5CYII='/>";
        		 
        		 
         String url="http://127.0.0.1:1234/lz/ActivateMailbox?email="+usermail+"&nickName="+username;
         String content = "<html>\n" +
		         "<body>\n"
		         + "<div style='text-align:left;'>"+img+"</div>\r\n"
		         +"<h4>"+username+"&nbsp&nbsp您好！</h4>\n"
		         +"<h4>我们即将完成您的 韩汀社区 账户创建。您可以使用此账户登录  韩汀社区。</h4> \n"
		         +"<h4>登录邮箱："+usermail+"</h4>\n" 
		         +"<h4>显示名称："+username+"</h4> \n"
		         +"<h4>点击下方链接验证电子邮件地址。</h4> \n"
		     	+ "		<p style='font-size:16px;'>欢迎注册御品韩汀，点击以下链接验证您的邮箱</p>\r\n" + "		<a href='" + url
 				+ "' style='background: #f34295;margin:15px 0;display:inline-block; padding:10px 70px;border-radius:30px;color:#fff;text-decoration:none;font-size:16px;letter-spacing:4px;' rel='noopener' target='_blank'>确认电子邮箱地址</a>\r\n"
 				+ "		<p>如您无法点击上述链接，可将如下地址复制到浏览器后打开：<br>\r\n" + "			<a href='" + url
 				+ "' style='color: #201e5d;display:inline-block;text-decoration:none;line-height:32px;' rel='noopener' target='_blank'>"
 				+ url + "</a>\r\n" + "		</p>\r\n" + "	</div>\r\n" + "</div>"
		         +"<h4>如果您未注册 韩汀社区 账户，可能是其他人误用您的信息进行了注册。</h4>\n"
		         +"<h4>请联系 韩汀社区 客户服务获取更多帮助。</h4>\n"
		         +"</body></html>";
         
         message.setContent(content, "text/html; charset=utf-8");
         //发送
         //transport.send(message);
         Transport.send(message);
         transport.close();
     } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
}
}
