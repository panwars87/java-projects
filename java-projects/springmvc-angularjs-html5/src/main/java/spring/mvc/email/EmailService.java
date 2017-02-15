package spring.mvc.email;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class EmailService {

    /*Email From*/
    public static final String FROM = "from";
    /*Email To*/
    public static final String TO = "to";
    /*Email Subject*/
    public static final String SUBJECT = "subject";
    /*Email BCC*/
    public static final String BCC_LIST = "bccList";
    /*Email CCC*/
    public static final String CCC_LIST = "ccList";

    @Autowired
    private JavaMailSender mailSender;
    
    @Autowired
    private VelocityEngine velocityEngine;
    
   public boolean sendEmail(final String templateName, final Map<String, Object> model) {
        boolean r = false;
        
    	try {
    		
    		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
            @SuppressWarnings("unchecked")
            public void prepare(MimeMessage mimeMessage) throws Exception {
                
            	String from = (String) model.get(FROM);
                String to = (String) model.get(TO);
                String subject = (String) model.get(SUBJECT);

                List<String> bCCList = (List<String>) model.get(BCC_LIST);
                MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
                message.setFrom(from);
                message.setTo(to);
                message.setSubject(subject);
                message.setSentDate(new Date());
                if (bCCList != null) {
                    for (String bcc : bCCList) {
                        message.addBcc(bcc);
                    }
                }
                
                model.put("noArgs", new Object[]{});
                
                String text = VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine, templateName,"UTF-8", model);
                message.setText(text, true);
            }
        };

        mailSender.send(preparator); 
        r = true;
        }catch(Exception e) {
        	e.printStackTrace();        	
        }
    	return r;
    }
}
