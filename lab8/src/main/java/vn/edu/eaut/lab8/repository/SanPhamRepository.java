package vn.edu.eaut.lab8.repository;

import vn.edu.eaut.lab8.model.SanPham;
import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {
    private static final List<SanPham> dsSanPham = new ArrayList<>();
    private static int counter = 1;

    static {
        dsSanPham.add(new SanPham(counter++, "Laptop Gaming", 25000000.0, 10));
        dsSanPham.add(new SanPham(counter++, "Chuột Không Dây", 350000.0, 50));
    }

    public List<SanPham> getAll() { return dsSanPham; }

    public void add(SanPham sp) {
        sp.setId(counter++);
        dsSanPham.add(sp);
    }

    public void delete(int id) {
        dsSanPham.removeIf(s -> s.getId() == id);
    }
}