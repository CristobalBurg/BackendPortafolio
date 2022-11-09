package com.TurismoApp.TurismoApp.Models.Services.WhatsAppService;

import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class WhatsAppSenderService {

private String ACCOUNT_SID="ACfd50b36adf73c18cb7057ac45836d031";
private String AUTH_TOKEN="da9d9c2652e05b33e428e8132f3744d5";

public void sendMessageUsingTwilio(Reserva reserva){
    String mensaje = "Muchas Gracias por tu reserva! 🙂 \n" +
    "🏘  Tu reserva quedará a nombre de: " + reserva.getUsuario().getNombre() + " " + reserva.getUsuario().getApellido() + "\n" +
    " El departamento ubicado en: " + reserva.getDepartamento().getDireccion() + " será reservado entre las fechas: \n" + 
    reserva.getFechaLlegada() + " y " + reserva.getFechaEntrega() + 
    "💕   Recuerda llevar Sabanas y toallas!";
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    Message message = Message.creator(
            new com.twilio.type.PhoneNumber( "whatsapp:" + reserva.getUsuario().getTelefono()),
            new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
            mensaje).create();
    
    System.out.println(message.getSid());
}

}
