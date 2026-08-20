package vn.edu.eaut.lab8.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import vn.edu.eaut.lab8.model.SanPham;
import vn.edu.eaut.lab8.repository.SanPhamRepository;

import java.io.Serializable;
import java.util.List;

@Named("sanPhamBean")
@SessionScoped
public class SanPhamBean implements Serializable {
    private SanPham sanPham = new SanPham();
    private final SanPhamRepository repository = new SanPhamRepository();

    public List<SanPham> getDsSanPham() { return repository.getAll(); }

    public String save() {
        repository.add(sanPham);
        sanPham = new SanPham(); // Reset form
        return "sanpham-list?faces-redirect=true";
    }

    public void delete(int id) { repository.delete(id); }

    public SanPham getSanPham() { return sanPham; }
    public void setSanPham(SanPham sanPham) { this.sanPham = sanPham; }
}