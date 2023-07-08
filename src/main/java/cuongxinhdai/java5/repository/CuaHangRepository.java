package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.CuaHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CuaHangRepository extends JpaRepository<CuaHang, UUID> {
}
