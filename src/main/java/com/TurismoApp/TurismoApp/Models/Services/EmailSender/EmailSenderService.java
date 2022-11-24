package com.TurismoApp.TurismoApp.Models.Services.EmailSender;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.TurismoApp.TurismoApp.Models.Entity.Transportista;
import com.TurismoApp.TurismoApp.Models.Services.CalculoPagoService.TotalesService;

@Service
public class EmailSenderService {

        @Autowired
        private JavaMailSender mailSender;

        @Autowired
        private TotalesService totalesService;

        public void sendSimpleMail(String emailTo, String body, String subject, Reserva reserva)
                        throws MessagingException {

                int total = totalesService.getTotalReserva(reserva.getFechaLlegada(), reserva.getFechaEntrega(),
                                reserva.getDepartamento().getValorArriendoDia(),
                                reserva.getReservaServicioExtra());

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailTo);
                helper.setText(getMailTemplate(reserva, total), true);
                helper.setFrom("turismorealnoreply@gmail.com");
                helper.setSubject(subject);

                mailSender.send(message);
        }

        public void sendMailTransporte(String emailTo, String body, String subject, Reserva reserva)
                        throws MessagingException {

                MimeMessage message = mailSender.createMimeMessage();
                MimeMessageHelper helper = new MimeMessageHelper(message, true);

                helper.setTo(emailTo);
                Transportista transportista = reserva.getTransportista();
                helper.setText(transportistaMail(reserva, transportista), true);
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
                                .append("                <td bgcolor=\"green\" align=\"center\" style=\"color: white;\">")
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
                                .append("                       <b> A Nombre de :</b>"
                                                + reserva.getUsuario().getNombre() + " "
                                                + reserva.getUsuario().getApellido())
                                .append("                    </p>")
                                .append("                    <p>")
                                .append("                        <b> Departamento: </b>"
                                                + reserva.getDepartamento().getDireccion())
                                .append("                    </p>")
                                .append("                    <p>")
                                .append("                        <b>Total: </b>  $"
                                                + total + " ( $" + reserva.getReservaPagos().get(0).getPago().getMonto()
                                                + " Adelantados)")
                                .append("                    </p>")
                                .append("                    <p>")
                                .append("                       <b> Fecha Llegada / Entrega: </b>"
                                                + reserva.getFechaLlegada() + " Hasta el "
                                                + reserva.getFechaEntrega())
                                .append("                    </p>")
                                .append("                </td>")
                                .append("            </tr>")
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

        public String transportistaMail(Reserva reserva, Transportista transportista) {

                String template = "<!DOCTYPE html\n" +
                                "    PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional //EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n"
                                +
                                "<html xmlns=\"http://www.w3.org/1999/xhtml\" xmlns:o=\"urn:schemas-microsoft-com:office:office\"\n"
                                +
                                "    xmlns:v=\"urn:schemas-microsoft-com:vml\" lang=\"en\">\n" +
                                "\n" +
                                "<head>\n" +
                                "    <link rel=\"stylesheet\" type=\"text/css\" hs-webfonts=\"true\"\n" +
                                "        href=\"https://fonts.googleapis.com/css?family=Lato|Lato:i,b,bi\">\n" +
                                "    <title>Email template</title>\n" +
                                "    <meta property=\"og:title\" content=\"Email template\">\n" +
                                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
                                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                                "    <style type=\"text/css\">\n" +
                                "        a {\n" +
                                "            text-decoration: underline;\n" +
                                "            color: inherit;\n" +
                                "            font-weight: bold;\n" +
                                "            color: #253342;\n" +
                                "        }\n" +
                                "\n" +
                                "        h1 {\n" +
                                "            font-size: 56px;\n" +
                                "        }\n" +
                                "\n" +
                                "        h2 {\n" +
                                "            font-size: 28px;\n" +
                                "            font-weight: 900;\n" +
                                "        }\n" +
                                "\n" +
                                "        p {\n" +
                                "            font-weight: 100;\n" +
                                "        }\n" +
                                "\n" +
                                "        td {\n" +
                                "            vertical-align: top;\n" +
                                "        }\n" +
                                "\n" +
                                "        #email {\n" +
                                "            margin: auto;\n" +
                                "            width: 600px;\n" +
                                "            background-color: white;\n" +
                                "        }\n" +
                                "\n" +
                                "        button {\n" +
                                "            font: inherit;\n" +
                                "            background-color: #FF7A59;\n" +
                                "            border: none;\n" +
                                "            padding: 10px;\n" +
                                "            text-transform: uppercase;\n" +
                                "            letter-spacing: 2px;\n" +
                                "            font-weight: 900;\n" +
                                "            color: white;\n" +
                                "            border-radius: 5px;\n" +
                                "            box-shadow: 3px 3px #d94c53;\n" +
                                "        }\n" +
                                "\n" +
                                "        .subtle-link {\n" +
                                "            font-size: 9px;\n" +
                                "            text-transform: uppercase;\n" +
                                "            letter-spacing: 1px;\n" +
                                "            color: #CBD6E2;\n" +
                                "        }\n" +
                                "    </style>\n" +
                                "</head>\n" +
                                "\n" +
                                "<body bgcolor=\"#F5F8FA\"\n" +
                                "    style=\"width: 100%; margin: auto 0; padding:0; font-family:Lato, sans-serif; font-size:18px; color:#33475B; word-break:break-word\">\n"
                                +
                                "    <div id=\"email\">\n" +
                                "        <table role=\"presentation\" width=\"100%\">\n" +
                                "            <tr>\n" +
                                "\n" +
                                "                <td bgcolor=\"green\" align=\"center\" style=\"color: white;\">\n" +
                                "\n" +
                                "                    <img alt=\"Flower\" src="+ "https://lh3.googleusercontent.com/qTfuWPVvsDFmBBpXc15438Y60drr8BhWXYUoVTLZqy_RPzvTc53hNuy96fwQ34e2Ydo=w2400" +" width=\"400px\" align=\"middle\">\n"
                                +
                                "\n" +
                                "                    <h1>Tu servicio de transporte ya está coordinado </h1>\n" +
                                "\n" +
                                "                </td>\n" +
                                "        </table>\n" +
                                "        <table role=\"presentation\" border=\"0\" cellpadding=\"0\" cellspacing=\"10px\" style=\"padding: 30px 30px 30px 60px;\">\n"
                                +
                                "            <tr>\n" +
                                "                <td>\n" +
                                "                    <h2> Estimado " + reserva.getUsuario().getNombre()
                                + ", ya se ha designado tu chofer</h2>\n" +
                                "                    <p>\n" +
                                "                        <b>Chofer:</b> " + transportista.getNombre() + " "
                                + transportista.getApellido() + "\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <b>Auto:</b> " + transportista.getVehiculo() + "\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <b>Fecha ida:</b>" + reserva.getFechaLlegada() + "\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <b>Fecha vuelta:</b>" + reserva.getFechaEntrega() + "\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <b>Contacto:</b>" + transportista.getContacto() + "\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <b>Horario:</b> 07:30 AM <small style=\"font-size: smaller;\"> (sujeto a coordinación\n"
                                +
                                "                            cliente/transportista)</small>\n" +
                                "                    </p>\n" +
                                "                    <p>\n" +
                                "                        <i>\n" +
                                "                            Para brindarte la mejor experiencia , nos contactaremos contigo para coordinar de mejor\n"
                                +
                                "                            manera la dirección en que hay que ir a buscarte entro de la comuna <b>"
                                + reserva.getDepartamento().getComuna().getNombre() + "</b> y el\n" +
                                "                            horario que a ti te acomode en coordinación con nuestro transportista.\n"
                                +
                                "                        </i>\n" +
                                "\n" +
                                "                    </p>\n" +
                                "\n" +
                                "                </td>\n" +
                                "            </tr>\n" +
                                "        </table>\n" +
                                "        <table role=\"presentation\" bgcolor=\"#F5F8FA\" width=\"100%\">\n" +
                                "            <tr>\n" +
                                "                <td align=\"left\" style=\"padding: 30px 30px;\">\n" +
                                "                    <p style=\"color:#99ACC2\"> Hecho con &hearts; turismo Real </p>\n"
                                +
                                "                </td>\n" +
                                "            </tr>\n" +
                                "        </table>\n" +
                                "    </div>\n" +
                                "</body>\n" +
                                "\n" +
                                "</html>";

                return template;
        }
}
