package services;

import dto.User;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.email.EmailPopulatingBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.MailerBuilder;
import org.simplejavamail.mailer.config.TransportStrategy;

public class MailService {
    private final static Mailer mailer = MailerBuilder.withSMTPServer("smtp.gmail.com", 587, "tinderamam@gmail.com", "VfrbvLtdxtyrj").withTransportStrategy(TransportStrategy.SMTP_TLS).buildMailer();
    //todo: change host when deploying on heroku
    private final String HOST = "http://localhost:8080/verification?u=";

    public void sendTo(User user) {
        String name = user.getName() + " " + user.getSurname();
        String adress = user.getLogin();
        String link = HOST + user.getRegUid();


        Email email = EmailBuilder.startingBlank().from("Tinder", "tinderamam@gmail.com")
                .to(name, adress)
                .withSubject("Email confirmation")
                .withPlainText("Click on the following link to confirm your email: " + link)
                .buildEmail();

        mailer.sendMail(email, true);
    }
}
