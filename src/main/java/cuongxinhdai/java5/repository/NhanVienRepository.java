package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NhanVienRepository extends JpaRepository<NhanVien , UUID> {
}
