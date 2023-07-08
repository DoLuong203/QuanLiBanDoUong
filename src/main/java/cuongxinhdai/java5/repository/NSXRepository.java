package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.NSX;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NSXRepository extends JpaRepository<NSX , UUID> {
}
