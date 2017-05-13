package reboot.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {
	
	/**
	 * This is a Post
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
    private String name; // title of post
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
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;;
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