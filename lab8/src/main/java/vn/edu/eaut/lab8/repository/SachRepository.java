package vn.edu.eaut.lab8.repository;

import vn.edu.eaut.lab8.model.Sach;
import java.util.ArrayList;
import java.util.List;

public class SachRepository {
    private static final List<Sach> dsSach = new ArrayList<>();
    private static int counter = 1;

    // Khởi tạo một vài dữ liệu mẫu
    static {
        dsSach.add(new Sach(counter++, "Lập Trình Web với JSF", "Nông Dưỡng", 2025));
        dsSach.add(new Sach(counter++, "Cấu Trúc Dữ Liệu", "Lê Văn B", 2023));
    }

    public List<Sach> getAll() {
        return dsSach;
    }

    public void add(Sach sach) {
        sach.setId(counter++);
        dsSach.add(sach);
    }

    public void delete(int id) {
        dsSach.removeIf(s -> s.getId() == id);
    }
}