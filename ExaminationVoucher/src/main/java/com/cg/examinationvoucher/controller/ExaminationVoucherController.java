package com.cg.examinationvoucher.controller;

/**
 * Examination Controller
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.examinationvoucher.entity.ExaminationVoucher;
import com.cg.examinationvoucher.service.ExaminationVoucherService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
public class ExaminationVoucherController {

	// logger
	Logger logger = LoggerFactory.getLogger(ExaminationVoucherController.class);

	@Autowired
	private ExaminationVoucherService examinationVoucherServices;

	/**
	 * Fetching all examination vouchers
	 * 
	 * @return List of examination Vouchers
	 */
	@Operation(summary = "Fetching all examination vouchers")
	@GetMapping("/examinationVouchers")
	public List<ExaminationVoucher> getAllExaminationVouchers() {
		String message = "Fetching all examination vouchers";
		logger.info("Inside the method [getAllExaminationVouchers] of service:" + message);
		return examinationVoucherServices.getAllExaminationVouchers();
	}

	/**
	 * Fetching examination vouchers records on the basis of subject name
	 * 
	 * @param subjectName represents name of the subject
	 * @return List of examination Vouchers
	 */
	@Operation(summary = "Fetching examination vouchers records on the basis of subject name")
	@GetMapping("/examinationVouchers/subjectName/{subjectName}")
	public List<ExaminationVoucher> getExaminationVouchersBySubjectName(
			@PathVariable("subjectName") String subjectName) {
		String message = "Fetching examination vouchers records on the basis of subject name";
		logger.info("Inside the method [get ExaminationVouchersBySubjectName] of service:" + message);
		return examinationVoucherServices.getExaminationVouchersBySubjectName(subjectName);
	}

	/**
	 * Fetching examination vouchers records on the basis of voucher price
	 * 
	 * @param voucherPrice represents price of the examination voucher
	 * @return ExaminationVoucher
	 */
	@Operation(summary = "Fetching examination vouchers records on the basis of voucher price")
	@GetMapping("/examinationVouchers/{voucherPrice}")
	public ExaminationVoucher getExaminationVouchersByVoucherPrice(@PathVariable("voucherPrice") int voucherPrice) {
		String message = "Fetching examination vouchers records on the basis of  voucher price";
		logger.info("Inside the method [get ExaminationVouchersByVoucherNumber] of service:" + message);
		return examinationVoucherServices.getExaminationVouchersByVoucherPrice(voucherPrice);

	}

	/**
	 * Fetching examination vouchers records on the basis of minimum skill rating
	 * 
	 * @param rating represents minimum skill rating
	 * @return List of ExaminationVoucher
	 */
	@Operation(summary = "Fetching examination vouchers records on the basis of minimum skill rating")
	@GetMapping("/examinationVouchers/minimumSkillRating/{rating}")
	public List<ExaminationVoucher> getExaminationVouchersByMinimumSkillRating(@PathVariable("rating") double rating) {
		String message = "Fetching examination vouchers records on the basis of minimum skill rating";
		logger.info("Inside the method [get ExaminationByminimumSkillRating] of service:" + message);
		return examinationVoucherServices.getExaminationVouchersByMinimumSkillRating(rating);
	}

	/**
	 * Fetching examination vouchers records on the basis of examination duration
	 * 
	 * @param examinationDuration represents examination duration
	 * @return List of ExaminationVoucher
	 */
	@Operation(summary = "Fetching examination vouchers records on the basis of examination duration")
	@GetMapping("/examinationVouchers/examinationDuration/{examinationDuration}")
	public List<ExaminationVoucher> getExaminationVouchersByexaminationDuration(
			@PathVariable("examinationDuration") int examinationDuration) {
		String message = "Fetching examination vouchers records on the basis of examination duration";
		logger.info("Inside the method [get ExaminationVouchersByExaminationDuration] of service:" + message);
		return examinationVoucherServices.getExaminationVouchersByExaminationDuration(examinationDuration);
	}

	/**
	 * deleting examination vouchers records on the basis of subject Id
	 * 
	 * @param subjectId 
	 * @param request
	 * @return  ResponseInfo of ResponseEntity type
	 */
	@Operation(summary = "deleting examination vouchers records on the basis of subject Id")
	@DeleteMapping("/examinationVouchers/{subjectId}")
	ResponseEntity<ResponseInfo> deleteExaminationVoucherBySubjectId(
			@PathVariable("subjectId") int subjectId, HttpServletRequest request) {
		String LogMessage = "deleting examination vouchers records on the basis of subject Id";
		logger.info("Inside the method [deleteExaminationVoucherBysubjectId] of service:" + LogMessage);
		examinationVoucherServices.deleteExaminationVoucherBySubjectId(subjectId);
		String msg = "Examination Voucher deleted successfully!";
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), msg,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);
	}

	/**
	 * updating examination vouchers
	 * 
	 * @param examinationVoucher represents examination vouchers
	 * @param request
	 * @return ResponseInfo of ResponseEntity type
	 */
	@Operation(summary = "updating examination vouchers ")
	@PutMapping("/examinationVouchers")
	ResponseEntity<ResponseInfo> updateExaminationVoucher(@Valid @RequestBody ExaminationVoucher examinationVoucher,
			HttpServletRequest request) {
		String message = "updating examination vouchers";
		logger.info("Inside the method [updateExaminationVoucher] of service:" + message);
		examinationVoucherServices.updateExaminationVoucher(examinationVoucher);
		String messsage = " Examination Voucher updated succesfully!";
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.ACCEPTED.value(), HttpStatus.ACCEPTED.name(), messsage,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.ACCEPTED);
	}

	/**
	 * adding examination voucher
	 * 
	 * @param examinationVoucher represents examination voucher
	 * @param request
	 * @return ResponseInfo of ResponseEntity type
	 */
	@Operation(summary = "adding examination voucher")
	@PostMapping("/examinationVouchers")
	ResponseEntity<ResponseInfo> addExaminationVoucher(@Valid @RequestBody ExaminationVoucher examinationVoucher,
			HttpServletRequest request) {
		String messageLog = "adding examination voucher";
		logger.info("Inside the method [addExaminationVoucher] of service:" + messageLog);
		String message = examinationVoucherServices.addExaminationVoucher(examinationVoucher);
		ResponseInfo rinfo = new ResponseInfo(HttpStatus.CREATED.value(), HttpStatus.CREATED.name(), message,
				request.getRequestURI());
		return new ResponseEntity<ResponseInfo>(rinfo, HttpStatus.CREATED);
	}
}
