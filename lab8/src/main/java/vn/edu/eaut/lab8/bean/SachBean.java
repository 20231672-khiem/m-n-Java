package vn.edu.eaut.lab8.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import vn.edu.eaut.lab8.model.Sach;
import vn.edu.eaut.lab8.repository.SachRepository;

import java.io.Serializable;
import java.util.List;

@Named("sachBean")
@SessionScoped
public class SachBean implements Serializable {
    private Sach sach = new Sach();
    private final SachRepository repository = new SachRepository();

    public List<Sach> getDsSach() {
        return repository.getAll();
    }

    public String save() {
        repository.add(sach);
        sach = new Sach(); // Xóa trắng form sau khi lưu
        return "sach-list?faces-redirect=true"; // Chuyển hướng về trang danh sách
    }

    public void delete(int id) {
        repository.delete(id);
    }

    public Sach getSach() { return sach; }
    public void setSach(Sach sach) { this.sach = sach; }
}