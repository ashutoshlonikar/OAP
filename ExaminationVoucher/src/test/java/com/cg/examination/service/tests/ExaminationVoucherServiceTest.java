package com.cg.examination.service.tests;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.naming.NameNotFoundException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import com.cg.examinationvoucher.entity.ExaminationVoucher;
import com.cg.examinationvoucher.exceptions.SubjectNameNotFoundException;
import com.cg.examinationvoucher.repository.ExaminationVoucherJpaRepository;
import com.cg.examinationvoucher.service.ExaminationVoucherService;


@SpringBootTest(classes = { ExaminationVoucherServiceTest.class })
class ExaminationVoucherServiceTest {
	@Mock
	ExaminationVoucherJpaRepository examinationVoucherRepository;

	@InjectMocks
	ExaminationVoucherService examinationVoucherService;

	@Test
	void getAllexaminationVouchersTest() {
		List<ExaminationVoucher> examinationVoucher = new ArrayList<>();
		examinationVoucher.add(new ExaminationVoucher(1234,"Java",2000.0,4.2,80));
		examinationVoucher.add(new ExaminationVoucher(5678,"Spring Boot",1000.0,4.5,90));
		when(examinationVoucherRepository.findAll()).thenReturn(examinationVoucher);
		assertEquals(examinationVoucher, examinationVoucherService.getAllExaminationVouchers());
	}

	@Test
	void getAllexaminationVouchersFailTest() {
		List<ExaminationVoucher> examinationVoucher = new ArrayList<>();
		examinationVoucher.add(new ExaminationVoucher(1234,"Java",2000.0,4.2,80));
		examinationVoucher.add(new ExaminationVoucher(5678,"Spring Boot",1000.0,4.5,90));
		when(examinationVoucherRepository.findAll()).thenReturn(examinationVoucher);
		assertNotEquals("not equal", examinationVoucherService.getAllExaminationVouchers());
	}

	@Test
	void getexaminationVouchersBySubjectNameTest() throws SubjectNameNotFoundException {
		ExaminationVoucher examinationVoucher = new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllBySubjectName(examinationVoucher.getSubjectName())).thenReturn(List.of(examinationVoucher));
		assertEquals(List.of(examinationVoucher), examinationVoucherService.getExaminationVouchersBySubjectName(examinationVoucher.getSubjectName()));
	}

	@Test
	void getexaminationVouchersBySubjectNameFailTest() throws SubjectNameNotFoundException {
		ExaminationVoucher examinationVoucher = new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllBySubjectName(examinationVoucher.getSubjectName())).thenReturn(List.of(examinationVoucher));
		assertNotEquals("subject with name", examinationVoucherService.getExaminationVouchersBySubjectName(examinationVoucher.getSubjectName()));
	}

	@Test
	void getexaminationVouchersByVoucherPriceTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findById(examinationVoucher.getSubjectId())).thenReturn(Optional.of(examinationVoucher));
		assertEquals(examinationVoucher, examinationVoucherService.getExaminationVouchersByVoucherPrice(examinationVoucher.getSubjectId()));
	}

	@Test
	void getexaminationVouchersByVoucherPriceFailTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findById(examinationVoucher.getSubjectId())).thenReturn(Optional.of(examinationVoucher));
		assertNotEquals("subject with id",
				examinationVoucherService.getExaminationVouchersByVoucherPrice(examinationVoucher.getSubjectId()));
	}

	@Test
	void getexaminationVouchersByExaminationDurationTest() throws NameNotFoundException {
		ExaminationVoucher examinationVoucher = new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllByExaminationDuration(examinationVoucher.getExaminationDuration())).thenReturn(List.of(examinationVoucher));
		assertEquals(List.of(examinationVoucher), examinationVoucherService.getExaminationVouchersByExaminationDuration(examinationVoucher.getExaminationDuration()));
	}

	@Test
	void getexaminationVouchersByExaminationDurationFailTest() throws NameNotFoundException {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllByExaminationDuration(examinationVoucher.getExaminationDuration())).thenReturn(List.of(examinationVoucher));
		assertNotEquals("subject with name", examinationVoucherService.getExaminationVouchersByExaminationDuration(examinationVoucher.getExaminationDuration()));
	}
	
	@Test
	void getExamByMinimunSkillRatingTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllByMinimumSkillRating(examinationVoucher.getminimumSkillRating())).thenReturn(List.of(examinationVoucher));
		assertEquals(List.of(examinationVoucher), examinationVoucherService.getExaminationVouchersByMinimumSkillRating(examinationVoucher.getminimumSkillRating()));
	}

	@Test
	void getExamByMinimunSkillRatingFailTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllByMinimumSkillRating(examinationVoucher.getminimumSkillRating())).thenReturn(List.of(examinationVoucher));
		assertNotEquals("Rating",
				examinationVoucherService.getExaminationVouchersByMinimumSkillRating(examinationVoucher.getminimumSkillRating()));
	}


	@Test 
	void deleteexaminationVoucherBySubjectIdTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findById(examinationVoucher.getSubjectId())).thenReturn(Optional.of(examinationVoucher));
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertEquals("Examination voucher deleted successfully",examinationVoucherService.deleteExaminationVoucherBySubjectId(examinationVoucher.getSubjectId()));
	}
	@Test 
	void deleteexaminationVoucherBySubjectIdFailTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findById(examinationVoucher.getSubjectId())).thenReturn(Optional.of(examinationVoucher));
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertNotEquals("Examination voucher not deleted",examinationVoucherService.deleteExaminationVoucherBySubjectId(examinationVoucher.getSubjectId()));
	}
	@Test
	void updateExamTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertEquals("Examination voucher updated successfully", examinationVoucherService.updateExaminationVoucher(examinationVoucher));
	}
	
	@Test
	void updateExamFailTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertNotEquals("Examination voucher not updated", examinationVoucherService.updateExaminationVoucher(examinationVoucher));
	}
	
	
	@Test
	void addexaminationVoucherTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllBySubjectName(examinationVoucher.getSubjectName())).thenReturn(List.of(examinationVoucher));
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertEquals("Examination voucher inserted successfully",examinationVoucherService.addExaminationVoucher(examinationVoucher));
		
	}
	@Test
	void addexaminationVoucherFailTest() {
		ExaminationVoucher examinationVoucher =new ExaminationVoucher(1234,"Java",2000.0,4.2,80);
		when(examinationVoucherRepository.findAllBySubjectName(examinationVoucher.getSubjectName())).thenReturn(List.of(examinationVoucher));
		when(examinationVoucherRepository.save(examinationVoucher)).thenReturn(examinationVoucher);
		assertNotEquals("Examination voucher not inserted",examinationVoucherService.addExaminationVoucher(examinationVoucher));
	}

}
