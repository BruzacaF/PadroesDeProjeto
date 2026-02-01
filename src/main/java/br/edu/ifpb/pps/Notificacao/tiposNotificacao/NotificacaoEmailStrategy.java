package br.edu.ifpb.pps.Notificacao.tiposNotificacao;

import br.edu.ifpb.pps.Notificacao.NotificacaoStrategy;
import io.github.cdimascio.dotenv.Dotenv;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificacaoEmailStrategy implements NotificacaoStrategy {
    private String emailDestinatario;
    private String emailRemetente;
    private String senhaRemetente;
    private String smtpHost;
    private String smtpPort;

    public NotificacaoEmailStrategy(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
        carregarConfiguracoes();
    }

    private void carregarConfiguracoes() {
        try {
            Dotenv dotenv = Dotenv.configure()
                    .ignoreIfMissing()
                    .load();
            
            Properties config = new Properties();
            config.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
            
            this.emailRemetente = dotenv.get("EMAIL_REMETENTE");
            this.senhaRemetente = dotenv.get("EMAIL_SENHA");
            
            this.smtpHost = config.getProperty("email.smtp.host");
            this.smtpPort = config.getProperty("email.smtp.port");
        } catch (Exception e) {
            System.err.println("Erro ao carregar configurações de email: " + e.getMessage());
        }
    }

    @Override
    public void enviarMensagem(String mensagem) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailRemetente, senhaRemetente);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(emailRemetente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailDestinatario));
            message.setSubject("Notificação MyHome");
            message.setText(mensagem);

            Transport.send(message);
            System.out.println("Email enviado com sucesso de " + emailRemetente + " para " + emailDestinatario);
        } catch (MessagingException e) {
            System.err.println("Erro ao enviar email para " + emailDestinatario + ": " + e.getMessage());
        }
    }
}

