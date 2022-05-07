package com.cg.examinationvoucher.service;

import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cg.examinationvoucher.entity.ExaminationVoucher;
import com.cg.examinationvoucher.exceptions.ExaminationDurationNotFoundException;
import com.cg.examinationvoucher.exceptions.ExaminationVoucherNotFoundException;
import com.cg.examinationvoucher.exceptions.MinimumSkillRatingNotFoundException;
import com.cg.examinationvoucher.exceptions.SubjectIdNotFoundException;
import com.cg.examinationvoucher.exceptions.SubjectNameNotFoundException;
import com.cg.examinationvoucher.exceptions.VoucherPriceNotFoundException;
import com.cg.examinationvoucher.repository.ExaminationVoucherJpaRepository;

@Service
@Transactional
public class ExaminationVoucherService {

	// logger
	Logger logger = LoggerFactory.getLogger(ExaminationVoucherService.class);

	@Autowired
	private ExaminationVoucherJpaRepository examinationVoucherJpaRepository;

	/**
	 * Fetching all Examination vouchers
	 * 
	 * @return List of Examination Vouchers
	 */
	public List<ExaminationVoucher> getAllExaminationVouchers() {
		String message = "Fetching all Examination vouchers";
		logger.info("Inside the method [getAllExaminationVouchers] of controller:" + message);
		List<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository.findAll();
		if (examinationVoucher.isEmpty()) {
			logger.error("ExaminationVoucherNotFoundException occured");
			throw new ExaminationVoucherNotFoundException("No examination voucher available");
		} else {
			return examinationVoucherJpaRepository.findAll();
		}
	}

	/**
	 * Fetching Examination vouchers records on the basis of subject name
	 * 
	 * @param subjectName represents name of the subject
	 * @return List of Examination Vouchers
	 */
	public List<ExaminationVoucher> getExaminationVouchersBySubjectName(String subjectName) {
		String message = "Fetching Examination vouchers records on the basis of subject name";
		logger.info("Inside the method [getExaminationVouchersBySubjectName] of controller:" + message);
		List<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository
				.findAllBySubjectName(subjectName);
		if (examinationVoucher.isEmpty()) {
			logger.error("SubjectNameNotFoundException occured");
			throw new SubjectNameNotFoundException("No record found for this subject name: " + subjectName);
		} else {
			return examinationVoucherJpaRepository.findAllBySubjectName(subjectName);
		}
	}

	/**
	 * Fetching Examination vouchers records on the basis of voucher price
	 * number
	 * 
	 * @param VoucherPrice represents voucher price
	 * @return ExaminationVouchers
	 * @throws ExaminationVoucherPriceNotFoundException
	 */
	public ExaminationVoucher getExaminationVouchersByVoucherPrice(int voucherPrice)
			throws VoucherPriceNotFoundException {
		String message = "Fetching Examination vouchers records on the basis of voucher price";
		logger.info("Inside the method [getExaminationVouchersByVoucherPrice] of controller:" + message);
		Optional<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository.findById(voucherPrice);
		if (examinationVoucher.isPresent()) {
			return examinationVoucher.get();
		} else {
			logger.error("ExaminationVoucherPriceNotFoundException occured");
			throw new VoucherPriceNotFoundException(
					"No record found for this voucher number: " + voucherPrice);
		}
	}

	/**
	 * Fetching Examination vouchers records on the basis of minimum skill rating
	 * 
	 * @param rating represents minimum skill rating
	 * @return List of Examination Vouchers
	 */
	public List<ExaminationVoucher> getExaminationVouchersByMinimumSkillRating(double rating) {
		String message = "Fetching Examination vouchers records on the basis of minimum skill rating";
		logger.info("Inside the method [getExaminationByMinimumSkillRating] of controller:" + message);
		List<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository
				.findAllByMinimumSkillRating(rating);
		if (examinationVoucher.isEmpty()) {
			logger.error("MinimumSkillRatingNotFoundException occured");
			throw new MinimumSkillRatingNotFoundException("No record found this rating " + rating);
		} else {
			return examinationVoucherJpaRepository.findAllByMinimumSkillRating(rating);
		}
	}

	/**
	 * Fetching Examination vouchers records on the basis of examination duration
	 * 
	 * @param examinationDuration represents examination duration
	 * @return List of Examination Vouchers
	 */
	public List<ExaminationVoucher> getExaminationVouchersByExaminationDuration(int examinationDuration) {
		String message = "Fetching Examination vouchers records on the basis of examination duration";
		logger.info("Inside the method [getExaminationVouchersByExaminationDuration] of controller:" + message);
		List<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository.findAllByExaminationDuration(examinationDuration);
		if (examinationVoucher.isEmpty()) {
			logger.error("ExaminationDurationNotFoundException");
			throw new ExaminationDurationNotFoundException("No record found this examination duration: " + examinationDuration);
		} else {
			return examinationVoucherJpaRepository.findAllByExaminationDuration(examinationDuration);
		}
	}

	/**
	 * Deleting Examination vouchers records on the basis of subject Id
	 * 
	 * @param subjectId 
	 * @return String
	 * @throws SubjectIdNotFoundException
	 */
	public String deleteExaminationVoucherBySubjectId(int subjectId)
			throws SubjectIdNotFoundException {
		String message = "Deleting Examination vouchers records on the basis of subject Id";
		logger.info("Inside the method [deleteExaminationVoucherBySubjectId] of controller:" + message);
		Optional<ExaminationVoucher> examinationVoucher = examinationVoucherJpaRepository.findById(subjectId);
		if (examinationVoucher.isPresent()) {
			examinationVoucherJpaRepository.deleteById(subjectId);
			return "Examination voucher deleted successfully";
		} else {
			logger.error("SubjectIdNotFoundException occured");
			throw new SubjectIdNotFoundException(
					"No record found for this voucher number: " + subjectId);
		}
	}

	/**
	 * Updating Examination vouchers
	 * 
	 * @param examinationVoucher represents
	 * @return String
	 */
	public String updateExaminationVoucher(ExaminationVoucher examinationVoucher) {
		String message = "Updating Examination vouchers";
		logger.info("Inside the method [updateExaminationVoucher] of controller:" + message);
		ExaminationVoucher updatedExaminationVoucher = examinationVoucherJpaRepository.save(examinationVoucher);
		if (updatedExaminationVoucher != null) {
			return "Examination voucher updated successfully";
		} else {
			return "Examination voucher not updated";
		}
	}

	/**
	 * Adding Examination voucher
	 * 
	 * @param examinationVoucher represents examination Voucher
	 * @return String
	 * @throws ExaminationVoucherNotFoundException
	 */
	public String addExaminationVoucher(ExaminationVoucher examinationVoucher)
			throws ExaminationVoucherNotFoundException {
		String messageLog = "Adding Examination voucher";
		logger.info("Inside the method [addExaminationVoucher] of controller:" + messageLog);
		ExaminationVoucher savedExaminationVoucher = examinationVoucherJpaRepository.save(examinationVoucher);
		if (savedExaminationVoucher != null) {
			return "Examination voucher inserted successfully";
		} else {
			logger.error("ExaminationVoucherNotFoundException occured");
			throw new ExaminationVoucherNotFoundException("Examination Voucher Not Found Exception");
		}
	}
}
