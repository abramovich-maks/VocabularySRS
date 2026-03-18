package com.vocabularysrs.domain.loginandregister;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
class UserConformer {

    private final JavaMailSender mailSender;
    private final UserRepository userRepository;
    private final MailSenderProperties mailProperties;

    public void sendConfirmationEmail(User user) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("VocabularySRS <maks.abramovich.1995@gmail.com>");
            helper.setTo(user.getEmail());
            helper.setSubject("Welcome to VocabularySRS - Confirm Your Email");
            helper.setText(buildEmailContent(user), true);

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send confirmation email", e);
        }
    }

    @Transactional
    public ConfirmResponse confirmUser(String confirmationToken) {
        Optional<User> optionalUser = userRepository.findByConfirmationToken(confirmationToken);
        if (optionalUser.isEmpty()) {
            return new ConfirmResponse(false);
        }
        User user = optionalUser.get();
        if (user.isEnabled()) {
            return new ConfirmResponse(true);
        }
        user.confirm();
        userRepository.save(user);
        return new ConfirmResponse(true);
    }

    private String buildEmailContent(final User user) {
        String link = mailProperties.baseUrl() + "/confirm?token=" + user.getConfirmationToken();

        return """
                <html>
                <body style="font-family: Arial, sans-serif; background-color: #f5f5f5; padding: 20px;">
                
                    <div style="max-width: 600px; margin: auto; background: white; padding: 30px; border-radius: 10px;">
                
                        <h2 style="color: #333;">👋 Hi %s!</h2>
                
                        <p style="color: #555;">
                            Thanks for joining <b>VocabularySRS</b>
                        </p>
                
                        <p style="color: #555;">
                            This is my personal project to help you learn and remember new words using spaced repetition.
                        </p>
                
                        <p style="color: #555;">
                            After confirmation you’ll be able to:
                        </p>
                
                        <ul style="color: #555;">
                            <li>📖 Add your own words</li>
                            <li>🧠 Practice daily</li>
                            <li>📊 Track your progress</li>
                        </ul>
                
                        <div style="text-align: center; margin: 30px 0;">
                            <a href="%s" 
                               style="background-color: #4CAF50; color: white; padding: 12px 24px; 
                                      text-decoration: none; border-radius: 6px; font-weight: bold;">
                                Confirm Email
                            </a>
                        </div>
                
                        <p style="color: #999; font-size: 14px;">
                            Or copy this link:<br/>
                            <a href="%s">%s</a>
                        </p>
                
                        <hr/>
                
                        <p style="color: #aaa; font-size: 12px;">
                            If you didn’t register — just ignore this email.
                        </p>
                
                    </div>
                </body>
                </html>
                """.formatted(
                user.getUsername(),
                link,
                link,
                link
        );
    }
}