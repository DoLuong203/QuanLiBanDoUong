package cuongxinhdai.java5.service;

import cuongxinhdai.java5.model.ChucVu;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public interface ChucVuService {
    ArrayList<ChucVu> getAll();

}
