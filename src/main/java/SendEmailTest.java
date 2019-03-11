import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;
//tinderauth@gmail.com
// @tinderAuth2019
public class SendEmailTest {
    private static String USER_NAME = "tinderauth@gmail.com";
    private static String PASSWORD = "@tinderAuth2019";
    private static String RECIPIENT = "alexey.kushnarov@ukr.net";

    public static void main(String[] args) {
        Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com", 587, USER_NAME, PASSWORD).withTransportStrategy(TransportStrategy.SMTP_TLS).buildMailer();
        String link = "http://localhost:8080/reg";
        String msg = String.format("Confirm your authoriztaion by link: %s",link);

        Email email = EmailBuilder.startingBlank()
                .from("Tinder",USER_NAME)
                .to(RECIPIENT)
                .withSubject("Confirm authorization")
                .withPlainText(msg)
                .buildEmail();

        mailer.sendMail(email);
        System.out.println(email.getId());
    }


}
