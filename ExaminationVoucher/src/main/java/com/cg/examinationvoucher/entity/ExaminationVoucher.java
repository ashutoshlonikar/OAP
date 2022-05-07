package com.cg.examinationvoucher.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class ExaminationVoucher {

	@Id
	@GeneratedValue
	@NotNull(message = "Subject Id must be not null")
	/**
	 * Represents  the Subject Id
	 */
	private int subjectId;
	
	@NotEmpty(message = "Subject name must not be empty")
	/**
	 * Represents  the subject name
	 */
	private String subjectName;
	
	@NotNull(message = "voucher price must not be empty")
	/**
	 * Represents  the voucher Price
	 */
	private double voucherPrice;
	
	@NotNull(message = "Minimum skill rating must be not null")
	/**
	 * Represents  the minimum skill rating
	 */
	private double minimumSkillRating;
	
	@NotNull(message = "Examination duration must be not null")
	/**
	 * Represents  the examination duration
	 */
	private int examinationDuration;
	
	// getters & setters
    
	/** Gets the Examination Voucher Number
	 * @return A integer representing the Examination Voucher Number
	 */
	public int getSubjectId() {
		return subjectId;
	}
	
	/** Sets the Examination Voucher Number
	 * @param A integer representing the Examination Voucher Number
	*/
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	
	/** Gets the Examination Name
	 * @return A String representing the Examination Name
	 */
	public String getSubjectName() {
		return subjectName;
	}
	
	/** Sets the Examination Name
	 * @param A String representing the Examination Name
	*/
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	/** Gets the Voucher Price
	 * @return A double representing the Voucher Price
	 */
	public double getVoucherPrice() {
		return voucherPrice;
	}
	
	/** Sets the Voucher Price
	 * @param A double representing the Voucher Price
	*/
	public void setVoucherPrice(double voucherPrice) {
		this.voucherPrice = voucherPrice;
	}
	
	/** Gets the Eligibility Rating Criteria
	 * @return A double representing the Eligibility Rating Criteria
	 */
	public double getminimumSkillRating() {
		return minimumSkillRating;
	}
	
	/** Sets the Eligibility Rating Criteria
	 * @param A double representing the Eligibility Rating Criteria
	*/
	public void setminimumSkillRating(double minimumSkillRating) {
		this.minimumSkillRating = minimumSkillRating;
	}

	/**
	 * Gets the examination duration
	 * @return A integer representing examination duration
	 */
	 
	public int getExaminationDuration() {
		return examinationDuration;
	}
 
	/**
	 * Sets the examination duration
	 * @param examinationDuration  representing examination duration
	 */
	public void setExaminationDuration(int examinationDuration) {
		this.examinationDuration = examinationDuration;
	}

	/**
	 * Default constructor
	 */
	public ExaminationVoucher() {
		super();

	}
	
	/**
	 * Parameterized Constructor
	 * @param subjectId represents subject Id of the examination
	 * @param subjectName represents the subjectName of the examination
	 * @param voucherPrice represents the price of the examination voucher
	 * @param minimumSkillRating represents the minimum skill rating
	 * @param examinationDuration represents the duration of the examination
	 */
	
	public ExaminationVoucher(@NotNull(message = "Subject Id must be not null") int subjectId,
			@NotEmpty(message = "Subject name must not be empty") String subjectName,
			@NotNull(message = "voucher price must not be empty") double voucherPrice,
			@NotNull(message = "Minimum skill rating must be not null") double minimumSkillRating,
			@NotNull(message = "Examination duration must be not null") int examinationDuration) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.voucherPrice = voucherPrice;
		this.minimumSkillRating = minimumSkillRating;
		this.examinationDuration = examinationDuration;
	}

	/**
	 * Overriding toString method
	 */

	@Override
	public String toString() {
		return "ExaminationVoucher [subjectId=" + subjectId + ", subjectName=" + subjectName + ", voucherPrice="
				+ voucherPrice + ", MinimumSkillRating=" + minimumSkillRating + ", examinationDuration="
				+ examinationDuration + "]";
	}
	
}
