package com.cg.examinationvoucher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

/**
 * Represents an Examination Voucher Main method
 * @author Ashutosh Lonikar
 * @version 1.5
 * @since 1.0
 */

@OpenAPIDefinition(info = @Info(title = "Examination Voucher API", version = "1.0", description = "Examination Voucher Information",contact =@Contact(email ="ashutosh.lonikar@gmail.com"),license =@License(name = "License 5.0")))
@SpringBootApplication
public class ExaminationVoucherApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExaminationVoucherApplication.class, args);
	}

}
