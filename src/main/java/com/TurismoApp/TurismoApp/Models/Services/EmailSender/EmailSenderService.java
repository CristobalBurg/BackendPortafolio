package com.TurismoApp.TurismoApp.Models.Services.EmailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService.TotalesService;

@Service
public class EmailSenderService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TotalesService totalesService;

    public void sendSimpleMail(String emailTo, String body, String subject, Reserva reserva) throws MessagingException {

        int total = totalesService.getTotalReserva(reserva.getFechaLlegada()
        , reserva.getFechaEntrega(),
         reserva.getDepartamento().getValorArriendoDia());

        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(emailTo);
        helper.setText(getMailTemplate(reserva ,  total), true);
        helper.setFrom("turismorealnoreply@gmail.com");
        helper.setSubject(subject);

        mailSender.send(message);

    }

    public String getMailTemplate(Reserva reserva, int total) {

        StringBuilder template = new StringBuilder();
        template.append("<!DOCTYPE html")
                .append("    PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">")
                .append("<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"")
                .append("    xmlns:v=\"urn:schemas-microsoft-com:vml\" lang=\"en\">")
                .append("")
                .append("<head>")
                .append("    <link rel=\"stylesheet\" type=\"text/css\" hs-webfonts=\"true\"")
                .append("        href=\"https://fonts.googleapis.com/css?family=Lato|Lato:i,b,bi\">")
                .append("    <title>Email template</title>")
                .append("    <meta property=\"og:title\" content=\"Email template\">")
                .append("")
                .append("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">")
                .append("")
                .append("    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">")
                .append("")
                .append("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">")
                .append("")
                .append("    <style type=\"text/css\">")
                .append("        a {")
                .append("            text-decoration: underline;")
                .append("            color: inherit;")
                .append("            font-weight: bold;")
                .append("            color: #253342;")
                .append("        }")
                .append("")
                .append("        h1 {")
                .append("            font-size: 56px;")
                .append("        }")
                .append("")
                .append("        h2 {")
                .append("            font-size: 28px;")
                .append("            font-weight: 900;")
                .append("        }")
                .append("")
                .append("        p {")
                .append("            font-weight: 100;")
                .append("        }")
                .append("")
                .append("        td {")
                .append("            vertical-align: top;")
                .append("        }")
                .append("")
                .append("        #email {")
                .append("            margin: auto;")
                .append("            width: 600px;")
                .append("            background-color: white;")
                .append("        }")
                .append("")
                .append("        button {")
                .append("            font: inherit;")
                .append("            background-color: #FF7A59;")
                .append("            border: none;")
                .append("            padding: 10px;")
                .append("            text-transform: uppercase;")
                .append("            letter-spacing: 2px;")
                .append("            font-weight: 900;")
                .append("            color: white;")
                .append("            border-radius: 5px;")
                .append("            box-shadow: 3px 3px #d94c53;")
                .append("        }")
                .append("")
                .append("        .subtle-link {")
                .append("            font-size: 9px;")
                .append("            text-transform: uppercase;")
                .append("            letter-spacing: 1px;")
                .append("            color: #CBD6E2;")
                .append("        }")
                .append("    </style>")
                .append("")
                .append("</head>")
                .append("")
                .append("<body bgcolor=\"#F5F8FA\"")
                .append("    style=\"width: 100%; margin: auto 0; padding:0; font-family:Lato, sans-serif; font-size:18px; color:#33475B; word-break:break-word\">")
                .append("")
                .append("    <div id=\"email\">")
                .append("        <table role=\"presentation\" width=\"100%\">")
                .append("            <tr>")
                .append("")
                .append("                <td bgcolor=\"#00A4BD\" align=\"center\" style=\"color: white;\">")
                .append("")
                .append("                    <img alt=\"Flower\"")
                .append("                        src=\"https://hs-8886753.f.hubspotemail.net/hs/hsstatic/TemplateAssets/static-1.60/img/hs_default_template_images/email_dnd_template_images/ThankYou-Flower.png\"")
                .append("                        width=\"400px\" align=\"middle\">")
                .append("")
                .append("                    <h1>¡Gracias por Tu Reserva! </h1>")
                .append("")
                .append("                </td>")
                .append("        </table>")
                .append("        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"10px\" style=\"padding: 30px 30px 30px 60px;\">")
                .append("            <tr>")
                .append("                <td>")
                .append("                    <h2>Estos son los datos de tu reserva:</h2>")
                .append("                    <p>")
                .append("                       <b> A Nombre de :</b>" + reserva.getUsuario().getNombre() + " "
                        + reserva.getUsuario().getApellido())
                .append("                    </p>")
                .append("                    <p>")
                .append("                        <b> Departamento: </b>" + reserva.getDepartamento().getDireccion())
                .append("                    </p>")
                .append("                    <p>")
                .append("                        <b>Total: </b>  $"
                        + total + " ( $" + reserva.getPago().getMonto() + " Adelantados)")
                .append("                    </p>")
                .append("                    <p>")
                .append("                       <b> Fecha Llegada / Entrega: </b>" + reserva.getFechaLlegada() + " Hasta el "
                        + reserva.getFechaEntrega())
                .append("                    </p>")
                .append("                </td>")
                .append("            </tr>")
                .append("        </table>")
                .append("        <table role=\"presentation\" bgcolor=\"#F5F8FA\" width=\"100%\">")
                .append("            <tr>")
                .append("                <td align=\"left\" style=\"padding: 30px 30px;\">")
                .append("                    <p style=\"color:#99ACC2\"> Hecho con ♥ por Turismo Real </p>")
                .append("                </td>")
                .append("            </tr>")
                .append("        </table>")
                .append("    </div>")
                .append("</body>")
                .append("")
                .append("</html>");
        return template.toString();

    }
}
