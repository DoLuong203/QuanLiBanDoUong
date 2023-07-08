package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DongSPRepository extends JpaRepository<DongSP , UUID> {
}
