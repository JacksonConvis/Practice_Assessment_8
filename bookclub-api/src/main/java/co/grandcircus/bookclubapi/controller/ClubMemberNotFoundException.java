package co.grandcircus.bookclubapi.controller;
public class ClubMemberNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ClubMemberNotFoundException(Long id) {
		super("Could not find club member with id " + id);
	}
}