package com.cg.examinationvoucher.repository;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.examinationvoucher.entity.ExaminationVoucher;

@Repository
public interface ExaminationVoucherJpaRepository extends JpaRepository<ExaminationVoucher, Integer> {
	List<ExaminationVoucher> findAllBySubjectName(String name);
    List<ExaminationVoucher> findAllByMinimumSkillRating(double rating);
	List<ExaminationVoucher> findAllByVoucherPrice(double voucherPrice);
	List<ExaminationVoucher> findAllByExaminationDuration(int examinationDuration);
}
