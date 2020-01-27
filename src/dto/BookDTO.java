package dto;

public class BookDTO {
	private String bookNo;
	private String bookName;
	private String publisher;
	private String author;
	private String regDate;
	private String rentYn;
	private String rentDate;
	private String returnDate;
	private String returnYn;
	private String delYn;
	
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public BookDTO() {
		// TODO Auto-generated constructor stub
	}
	public BookDTO(String bookNo, String bookName) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String i) {
		this.bookNo = i;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getRentDate() {
		return rentDate;
	}
	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturnYn() {
		return returnYn;
	}
	public void setReturnYn(String returnYn) {
		this.returnYn = returnYn;
	}
	public String getRentYn() {
		return rentYn;
	}
	public void setRentYn(String rentYn) {
		this.rentYn = rentYn;
	}
}
