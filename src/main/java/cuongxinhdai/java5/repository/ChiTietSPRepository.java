package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.ChiTietSP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChiTietSPRepository  extends JpaRepository<ChiTietSP, UUID> {
   
}
