package com.pdf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PdfController {

	public PdfController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping("/pdf")
	public String creatPdf() {
		return "pdfview";
	}

}
