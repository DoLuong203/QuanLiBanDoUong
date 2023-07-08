package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.ChucVu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChucVuRepository extends JpaRepository<ChucVu , UUID> {
}
