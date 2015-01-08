/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.mum.cs490.smartmart.domain;

import edu.mum.cs490.smartmart.validators.annotations.FieldMatch;
import edu.mum.cs490.smartmart.validators.annotations.UniqueUserName;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.SafeHtml;


/**
 *
 * @author dipika
 */
@Entity
@FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match")
public class Credential implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @NotBlank (message = "{NotBlank.Credential.username.validation}")
    @SafeHtml
    @UniqueUserName(message = "{UniqueUserName.Credential.username.validation}")
//    @Pattern(regexp = "((?=.*[@])(?=.*[.]))", message="{Pattern.Credential.username.validation}")
    private String username;
    
    @NotBlank (message = "{NotBlank.Credential.password.validation}")    
//    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message="{Pattern.Credential.password.validation}")
    @SafeHtml
    private String password;

    @Transient
    @SafeHtml
    @NotBlank (message = "{NotBlank.Credential.confirmPassword.validation}")
//    @Pattern(regexp = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})", message="{Pattern.Credential.password.validation}")
    private String confirmPassword;
    
    private boolean active;
    
   
    @Enumerated(EnumType.STRING)
    private Role role;
    
    @OneToOne(mappedBy ="credential")
    private Users user;
    
    public Credential() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Credential)) {
            return false;
        }
        Credential other = (Credential) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.mum.cs490.webmart.domain.Credentials[ id=" + id + " ]";
    }

}
