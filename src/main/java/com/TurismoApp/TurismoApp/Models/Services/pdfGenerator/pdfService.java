package com.TurismoApp.TurismoApp.Models.Services.pdfGenerator;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

import com.TurismoApp.TurismoApp.Models.Entity.Multa;
import com.TurismoApp.TurismoApp.Models.Entity.Reserva;
import com.lowagie.text.DocumentException;

import org.thymeleaf.context.Context;


@Service
public class pdfService {


	public ByteArrayOutputStream createPdf(
		boolean isCheckIn , 
		Reserva reserva, 
		int total, 
		Multa multa,
		final HttpServletRequest request,
		final HttpServletResponse response)
		throws DocumentException {

		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateResolver.setCharacterEncoding("UTF-8");

		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

		Context context = new Context();
		context.setVariable("fechaLlegada", reserva.getFechaLlegada());
		context.setVariable("fechaEntrega", reserva.getFechaEntrega());
		context.setVariable("direccion", reserva.getDepartamento().getDireccion());
		context.setVariable("nombre", reserva.getUsuario().getNombre() + " " + reserva.getUsuario().getApellido());
		context.setVariable("inventario", reserva.getDepartamento().getInventarioProductos());
		context.setVariable("pago", reserva.getReservaPagos().get(0).getPago().getMonto());
		context.setVariable("total", total);


		String processedHtml = "";
		if (isCheckIn){
			processedHtml = templateEngine.process("templates/templateCheckin", context);
		} else {
			context.setVariable("multa", multa);
			processedHtml = templateEngine.process("templates/templateCheckout", context);
		}

		ByteArrayOutputStream bos = new ByteArrayOutputStream();

		try {

			ITextRenderer renderer = new ITextRenderer();
			renderer.setDocumentFromString(processedHtml);

			renderer.layout();
			renderer.createPDF(bos, false);
			renderer.finishPDF();

		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e) {
				}
			}
		}
		return bos;
	}
}
