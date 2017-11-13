package be.dragon.language.users;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

/**
 *
 */
@Entity(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "PASSWORD")
    private String password;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "CREATED_TIME")
    private Date creationTime;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "UPDATED_TIME")
    private Date updatedTime;

    @Temporal(value = TemporalType.DATE)
    @Column(name = "DOB")
    private Date dateofBirth;


    @Lob
    @Column(name = "PROFILE_PIC")
    private byte[] profilePic;

    @Transient
    private transient String dateOfBirthString;

    public User() {

    }

    public User(String userName, String password, Date creationTime, Date updatedTime, Date dateofBirth, byte[] profilePic) {
        this.userName = userName;
        this.password = password;
        this.creationTime = creationTime;
        this.updatedTime = updatedTime;
        this.dateofBirth = dateofBirth;

        this.profilePic = profilePic;
        this.dateOfBirthString = dateofBirth.toString();
    }

    public User(String benoit, String password, LocalDateTime now, LocalDateTime now1, LocalDateTime now2) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date dateofBirth) {
        this.dateofBirth = dateofBirth;
    }


    public byte[] getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(byte[] profilePic) {
        this.profilePic = profilePic;
    }

    public String getDateOfBirthString() {
        return dateOfBirthString;
    }

    public void setDateOfBirthString(String dateOfBirthString) {
        this.dateOfBirthString = dateOfBirthString;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id != null ? id.equals(user.id) : user.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", creationTime=" + creationTime +
                ", updatedTime=" + updatedTime +
                ", dateofBirth=" + dateofBirth +

                ", profilePic=" + Arrays.toString(profilePic) +
                ", dateOfBirthString='" + dateOfBirthString + '\'' +
                '}';
    }
}
