package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KhachHangRepository extends JpaRepository<KhachHang, UUID>{
}
