package vn.edu.eaut.lab8.repository;

import vn.edu.eaut.lab8.model.SinhVien;
import java.util.*;

public class SinhVienRepository {
    private static final List<SinhVien> data = new ArrayList<>();
    private static int autoId = 3;

    static {
        data.add(new SinhVien(1, "20240001", "Nguyễn Văn An", "an@gmail.com", "DCCNTT15.10.1"));
        data.add(new SinhVien(2, "20240002", "Trần Thị Bình", "binh@gmail.com", "DCCNTT15.10.2"));
    }

    public List<SinhVien> findAll() {
        return data;
    }

    public void add(SinhVien sv) {
        sv.setId(autoId++);
        data.add(sv);
    }

    public void delete(int id) {
        data.removeIf(x -> x.getId() == id);
    }

    // --- BỔ SUNG CHỨC NĂNG TÌM KIẾM (BÀI 10) ---
    public List<SinhVien> searchByKeyword(String keyword) {
        if (keyword == null || keyword.trim().isEmpty()) {
            return findAll(); // Nếu không nhập từ khóa thì trả về toàn bộ danh sách
        }

        List<SinhVien> result = new ArrayList<>();
        String lowerKeyword = keyword.toLowerCase().trim();

        for (SinhVien sv : data) {
            // Kiểm tra xem họ tên hoặc lớp có chứa từ khóa tìm kiếm không (không phân biệt hoa thường)
            boolean matchName = sv.getHoTen() != null && sv.getHoTen().toLowerCase().contains(lowerKeyword);
            boolean matchClass = sv.getLop() != null && sv.getLop().toLowerCase().contains(lowerKeyword);

            if (matchName || matchClass) {
                result.add(sv);
            }
        }
        return result;
    }
}