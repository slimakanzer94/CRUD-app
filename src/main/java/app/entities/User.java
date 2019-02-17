package app.entities;


import org.springframework.util.StringUtils;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    @Transient
    private String confirmPassword;
    private String sex;
    private String country;
    private String adress;
    private String phoneNumber;
    private boolean newsLetter;
    @Transient
    private List<String> frameworks;
    @Transient
    private List<String> skills;
    @Column(name = "frameworks")
    private String frameworksList;
    @Column(name = "skills")
    private String skillsList;

    public void setframeworksList(){
        if (frameworks!=null) {
            frameworksList = StringUtils.collectionToDelimitedString(frameworks, ", ");
        }
        if (skills!=null) {
            skillsList = StringUtils.collectionToDelimitedString(skills, ", ");
        }
    }
    public User() {}
    public String getFrameworksList() {
        return frameworksList;
    }

    public String getSkillsList() {
        return skillsList;
    }
    public boolean isNew() {
        return (this.id == null);
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isNewsLetter() {
        return newsLetter;
    }

    public void setNewsLetter(boolean newsLetter) {
            this.newsLetter = newsLetter;
    }

    public List<String> getFrameworks() {
        return frameworks;
    }

    public void setFrameworks(List<String> frameworks) {
        this.frameworks = frameworks;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return String.format("User[id=%d, name='%s', password='%s]", id,name,password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getName().equals(user.getName()) &&
                getPassword().equals(user.getPassword());
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
