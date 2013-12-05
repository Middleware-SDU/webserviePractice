package cn.edu.sdu.webservice.ejbcontainer.module;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Yonggang Yuan
 *
 */

@Entity
@Table(name="user")
public class User implements Serializable{

    private static final long serialVersionUID = 2504061277038855739L;

    @Id
    @GeneratedValue(generator="",strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private Integer id;

    @Column(name="user_name", length=20, nullable=false)
    private String name;

    @Column(name="user_balance", scale=2)
    private Double balance;

    @Column(name="user_status", nullable=false)
    private Boolean visible;

    public User(){}

    public User(String name, Double balance){
        this.name = name;
        this.balance = balance;
        this.setVisible(true);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * 存款
     * @return 返回存款后的余额
     */
    public Double deposit(Double in) {
        if(this.balance == null || this.balance == 0) {
            this.balance = in;
            return this.balance;
        }
        this.balance = this.balance + in;
        return this.balance;
    }

    /**
     * 取款
     * @return #1： 返回-1.0代表【余额不足】
     *         #2：正常返回取款后的余额
     */
    public Double draw(Double out) {
        if(this.balance == null || this.balance == 0 || this.balance < out) {
            return -1.0;
        }
        this.balance = this.balance - out;
        return this.balance;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        User other = (User) obj;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        return true;
    }

}
