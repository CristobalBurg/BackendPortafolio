package com.TurismoApp.TurismoApp.Models.Services.pdfGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.lowagie.text.DocumentException;

@Service
public class pdfGeneratorService {

    public void generatePdfFromHtml(String html) throws IOException, DocumentException {
        UUID uuid = UUID.randomUUID();
        String outputFolder = "src/main/resources/reports" + File.separator + uuid.toString() + ".pdf";
        OutputStream outputStream = new FileOutputStream(outputFolder);

        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(outputStream);

        outputStream.close();
    }

    public String generarTemplateReserva(Reserva reserva) {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setCharacterEncoding("UTF-8");

        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);



        Context context = new Context();
        context.setVariable("fecha", reserva.getFechaLlegada());
		context.setVariable("direccion", reserva.getDepartamento().getDireccion());
		context.setVariable("nombre", reserva.getUsuario().getNombre()  + " " + reserva.getUsuario().getApellido());
        context.setVariable("inventario", reserva.getDepartamento().getInventarioProductos());




        return templateEngine.process("templates/template", context);
    }
    
}
