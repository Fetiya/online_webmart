/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.serviceImpl;

import edu.mum.cs490.smartmart.domain.Admin;
import edu.mum.cs490.smartmart.domain.Customer;
import edu.mum.cs490.smartmart.domain.Vendor;
import edu.mum.cs490.smartmart.service.INotificationService;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 *
 * @author Komal
 */
public class NotificationServiceImpl implements INotificationService {

    private SimpleMailMessage toVendorTemplate;
    private SimpleMailMessage toCustomersTemplate;

    private JavaMailSenderImpl javaMailSender;

    public SimpleMailMessage getToVendorTemplate() {
        return toVendorTemplate;
    }

    public void setToVendorTemplate(SimpleMailMessage toVendorTemplate) {
        this.toVendorTemplate = toVendorTemplate;
    }

    public SimpleMailMessage getToCustomersTemplate() {
        return toCustomersTemplate;
    }

    public void setToCustomersTemplate(SimpleMailMessage toCustomersTemplate) {
        this.toCustomersTemplate = toCustomersTemplate;
    }

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    /**
     * Begin email sending implementation, notify vendor for signup
     *
     * @param customer
     * @param message
     */
    @Override
    public void notifyCustomerSignUp(Customer customer, String message) {
        SimpleMailMessage template = getToCustomersTemplate();
        String emailMessage = String.format(template.getText(), customer.getFirstName() + " " + customer.getLastName(), message);
        System.out.println("+++++++++=========" + customer );
        System.out.println("+++++++++" + customer.getCredential() );
        sendMail(template.getFrom(), customer.getCredential().getUsername(), template.getSubject(), emailMessage);

    }

    /**
     * notify vendor for signup
     *
     * @param vendor
     * @param message
     */
    @Override
    public void notifyVendorSignUp(Vendor vendor, String message) {
        SimpleMailMessage template = getToCustomersTemplate();
             System.out.println("Vendor is" + vendor);
        System.out.println("Vendor admin is" + vendor.getVendorAdmin());
        System.out.println("Vendor credential is" + vendor.getVendorAdmin().getCredential());
        String emailMessage = String.format(template.getText(), vendor.getVendorAdmin().getFirstName() + " " + vendor.getVendorAdmin().getLastName(), message);
   
        sendMail(template.getFrom(), vendor.getVendorAdmin().getCredential().getUsername(), template.getSubject(), emailMessage);

    }

    @Override
    public void contactAdmin(Admin admin, String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
     //Email sending implementation
    public void sendMail(String fromEmail, String toEmail, String emailSubject, String emailBody) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            helper.setFrom(fromEmail);
            helper.setTo(toEmail);
            helper.setSubject(emailSubject);
            helper.setText(emailBody);

            /*
             uncomment the following lines for attachment FileSystemResource
             file = new FileSystemResource("attachment.jpg");
             helper.addAttachment(file.getFilename(), file);
             */
            javaMailSender.send(mimeMessage);
            System.out.println("Mail sent successfully.");//debugging
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
    
    
}
