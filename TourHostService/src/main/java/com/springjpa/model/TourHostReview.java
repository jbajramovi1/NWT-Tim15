package com.springjpa.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tourHostReview")
public class TourHostReview implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@ManyToOne(targetEntity=TourHost.class)
	@JoinColumn(name="idTourHost")
    private TourHost tourHost;

	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="idUser")
    private User user;
    
	@Column(name = "reviewTitle")
	private String reviewTitle;
	
	@Column(name = "reviewDate")
	private Date reviewDate;
	
	@Column(name = "reviewRating")
	private int reviewRating;
	
	@Column(name = "review")
	private char[] review;
		
	protected TourHostReview() {
	}
	
	public TourHostReview(TourHost tourHost, User user, String reviewTitle, Date reviewDate,
			int reviewRating, char[] review) {
		super();
		this.tourHost = tourHost;
		this.user = user;
		this.reviewTitle = reviewTitle;
		this.reviewDate = reviewDate;
		this.reviewRating = reviewRating;
		this.review = review;
	}

	@Override
	public String toString() {
		return "TourHostReview [tourHost=" + tourHost + ", user=" + user + ", reviewTitle="
				+ reviewTitle + ", reviewDate=" + reviewDate + ", reviewRating=" + reviewRating + ", review="
				+ Arrays.toString(review) + "]";
	}

	public TourHost getTourHost() {
		return tourHost;
	}

	public void setTourHost(TourHost tourHost) {
		this.tourHost = tourHost;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public Date getReviewDate() {
		return reviewDate;
	}

	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	public int getReviewRating() {
		return reviewRating;
	}

	public void setReviewRating(int reviewRating) {
		this.reviewRating = reviewRating;
	}

	public char[] getReview() {
		return review;
	}

	public void setReview(char[] review) {
		this.review = review;
	}
}



