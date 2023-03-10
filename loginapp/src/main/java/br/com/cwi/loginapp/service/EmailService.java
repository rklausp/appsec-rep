package br.com.cwi.loginapp.service;

import br.com.cwi.loginapp.controller.request.EmailRequest;
import br.com.cwi.loginapp.controller.response.EmailResponse;
import br.com.cwi.loginapp.mapper.EmailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public EmailResponse enviar(String request, String assunto, String texto){
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("enviaemailappsec@gmail.com");
            message.setTo(request);
            message.setSubject(assunto);
            message.setText(texto);
            javaMailSender.send(message);
        } catch (MailException e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nao foi possivel enviar o email");
        }
        return EmailMapper.toResponse(request);



    }
}
