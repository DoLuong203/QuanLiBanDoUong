package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HoaDonRepository extends JpaRepository<HoaDon , UUID> {
}
