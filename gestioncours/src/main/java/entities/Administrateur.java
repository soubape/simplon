package entities;

import java.util.Objects;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String email;

	public Administrateur() {

	}

	/**
	 * @param username
	 * @param password
	 */
	public Administrateur(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	
	}

	/**
	 * @param username
	 * @param password
	 * @param email
	 */
	public Administrateur(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		
	}

	/**
	 * @return the username
	 */

	public String getUsername() {
		return username;
	}

	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Administrateur other = (Administrateur) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
        builder.append( "Username : " ).append( this.username )
               .append( " Password : " ).append( this.password )
               .append( " Email : " ).append( this.email )
               .append( "\n" );
        return builder.toString();
		//return "Administrateur [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
