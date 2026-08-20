package vn.edu.eaut.lab8.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import vn.edu.eaut.lab8.model.SinhVien;
import vn.edu.eaut.lab8.repository.SinhVienRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("sinhVienBean")
@SessionScoped
public class SinhVienBean implements Serializable {
    private SinhVien sinhVien = new SinhVien();
    private String keyword = ""; // Biến lưu từ khóa tìm kiếm (Bài 10)
    private final SinhVienRepository repo = new SinhVienRepository();

    // Danh sách các lớp cho selectOneMenu (Bài 12)
    private final List<String> dsLop;

    public SinhVienBean() {
        dsLop = new ArrayList<>();
        dsLop.add("DCCNTT15.10.1");
        dsLop.add("DCCNTT15.10.2");
        dsLop.add("DCCNTT15.10.3");
        dsLop.add("DCQTKD15.10.1");
    }

    // 1. Thêm mới sinh viên
    public String save() {
        repo.add(sinhVien);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã lưu sinh viên"));
        sinhVien = new SinhVien();
        return null;
    }

    // 2. Xóa sinh viên theo id
    public void delete(int id) {
        repo.delete(id);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã xóa sinh viên"));
    }

    // 3. Chọn sinh viên để sửa (Bài 9)
    public String edit(SinhVien sv) {
        this.sinhVien = sv;
        return "sinhvien-form?faces-redirect=true";
    }

    // 4. Cập nhật thông tin sinh viên (Bài 9)
    public String update() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Thành công", "Đã cập nhật thông tin sinh viên"));
        sinhVien = new SinhVien();
        return "sinhvien-list?faces-redirect=true";
    }

    // 5. Hàm hành động khi bấm nút Tìm kiếm (Bài 10)
    public void search() {
        // JSF tự động gọi getDanhSach() để lọc theo keyword
    }

    // Lấy danh sách sinh viên (Có hỗ trợ tìm kiếm)
    public List<SinhVien> getDanhSach() {
        if (keyword != null && !keyword.trim().isEmpty()) {
            return repo.searchByKeyword(keyword);
        }
        return repo.findAll();
    }

    // Getters và Setters
    public SinhVien getSinhVien() { return sinhVien; }
    public void setSinhVien(SinhVien sinhVien) { this.sinhVien = sinhVien; }

    public String getKeyword() { return keyword; }
    public void setKeyword(String keyword) { this.keyword = keyword; }

    public List<String> getDsLop() { return dsLop; }
}