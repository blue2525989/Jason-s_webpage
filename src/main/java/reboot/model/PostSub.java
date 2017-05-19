package reboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class PostSub {
	/**
	 * This is a Post
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private Long masterId;
    @Lob
    private String message;
    private String date;
    private Long userId;
	private String username;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
    public Long getMasterId() {
        return masterId;
    }

    public void setMasterId(Long id) {
        this.masterId = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String content) {
        this.message = content;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;;
    }
    
    public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long id) {
		this.userId = id;
	}

	public String getUsername() {
        return username;
    }
	
	public void setUsername(String userName) {
		this.username = userName;
		
	}
    
}