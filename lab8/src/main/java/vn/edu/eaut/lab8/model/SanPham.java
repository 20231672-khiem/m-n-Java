package vn.edu.eaut.lab8.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SanPham {
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String tenSanPham;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 0, message = "Giá sản phẩm không được là số âm")
    private Double gia;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng không được nhỏ hơn 0")
    private Integer soLuong;

    public SanPham() {}

    public SanPham(int id, String tenSanPham, Double gia, Integer soLuong) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.gia = gia;
        this.soLuong = soLuong;
    }

    // Getters và Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTenSanPham() { return tenSanPham; }
    public void setTenSanPham(String tenSanPham) { this.tenSanPham = tenSanPham; }
    public Double getGia() { return gia; }
    public void setGia(Double gia) { this.gia = gia; }
    public Integer getSoLuong() { return soLuong; }
    public void setSoLuong(Integer soLuong) { this.soLuong = soLuong; }
}