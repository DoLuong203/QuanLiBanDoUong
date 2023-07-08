package cuongxinhdai.java5.repository;

import cuongxinhdai.java5.model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MauSacRepository extends JpaRepository<MauSac, UUID> {
}
