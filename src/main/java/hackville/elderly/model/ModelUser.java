package hackville.elderly.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table (name="tb_user")
public class ModelUser extends ModelAudit {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(max = 100)
    private String name;

    @NotNull
    @Column(unique = true)
    @Size(max = 100)
    private String email;
    
	@Size(max = 100)
    private String location;
	
	@Size(max = 10)
    private String age;
	
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userId")
    private Set<ModelTopicUser> topic = new HashSet<>();
    
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "userId")
    private Set<ModelConnection> userConnection = new HashSet<>();
    
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Set<ModelTopicUser> getTopic() {
		return topic;
	}

	public void setTopic(Set<ModelTopicUser> topic) {
		this.topic = topic;
	}

	public Set<ModelConnection> getUserConnection() {
		return userConnection;
	}

	public void setUserConnection(Set<ModelConnection> userConnection) {
		this.userConnection = userConnection;
	}
	
}


