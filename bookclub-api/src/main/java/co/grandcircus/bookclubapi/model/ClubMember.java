package co.grandcircus.bookclubapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClubMember {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer booksRead;
	private Boolean foundingMember;

	public ClubMember() {
		super();
	}

	public ClubMember(Long id, String name, Integer booksRead,
			Boolean foundingMember) {
		super();
		this.id = id;
		this.name = name;
		this.booksRead = booksRead;
		this.foundingMember = foundingMember;
	}

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
		this.name = name;
	}

	public Integer getBooksRead() {
		return booksRead;
	}

	public void setBooksRead(Integer booksRead) {
		this.booksRead = booksRead;
	}

	public Boolean getFoundingMember() {
		return foundingMember;
	}

	public void setFoundingMember(Boolean foundingMember) {
		this.foundingMember = foundingMember;
	}

}
