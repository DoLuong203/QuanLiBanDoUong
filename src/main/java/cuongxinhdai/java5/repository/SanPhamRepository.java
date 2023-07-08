package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
