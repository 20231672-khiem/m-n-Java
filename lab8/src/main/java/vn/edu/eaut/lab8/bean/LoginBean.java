package vn.edu.eaut.lab8.bean;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

    public String login() {
        // Kiểm tra tài khoản mẫu
        if ("admin".equals(username) && "123456".equals(password)) {
            return "index?faces-redirect=true"; // Đúng thì chuyển về trang index.xhtml
        } else {
            // Sai thì hiển thị FacesMessage báo lỗi đỏ lên form
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sai tài khoản hoặc mật khẩu!", "Vui lòng kiểm tra lại."));
            return null; // Ở lại trang login.xhtml
        }
    }

    public String logout() {
        username = "";
        password = "";
        return "login?faces-redirect=true";
    }

    // Getters và Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}