package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import dto.BookDTO;
import dto.MemberDTO;

public class LibraryDAO {
	HashMap<String, ArrayList<BookDTO>> map = new HashMap<String, ArrayList<BookDTO>>();
	public void rentBook(MemberDTO member, BookDTO book) {
		ArrayList<BookDTO> bookList =  map.get(member.getPersonId());
		if(bookList==null) {
			bookList = new ArrayList<BookDTO>();
			bookList.add(book);
			map.put(member.getPersonId(), bookList);
		}else{
			bookList.add(book);
			map.replace(member.getPersonId(), bookList);
		}
		System.out.println("'"+member.getPersonId()+"'님이 '"+book.getBookName()+"'을 대여했습니다.");
		System.out.println(map.get(member.getPersonId()));
	}
	
	Scanner scan;
	public void viewMain() {
		System.out.println("-------------------------------");
		System.out.println("다음 메뉴를 선택하세요.(숫자입력)");
		System.out.println("-------------------------------");
		System.out.println("1. 나의 대여목록 확인");
		System.out.println("2. 책 대여");
		scan = new Scanner(System.in);
		int num = scan.nextInt();
		System.out.println(num);
		switch (num) {
			case 1: {
				System.out.println("-------------------------------");
				System.out.println("ID를 입력해 주세요.");
				System.out.printf("-------------------------------");
				scan = new Scanner(System.in);
				String personId = scan.nextLine();
				System.out.println(personId);
				bookList(personId);
				scan.close();
			}
			case 2: {
				System.out.println("ID를 입력해 주세요");
				String personId = scan.nextLine();
				System.out.println("이름을 입력해 주세요");
				String personName = scan.nextLine();
				MemberDTO member = new MemberDTO(personId, personName);
				
				System.out.println("책의 일련번호를 입력해 주세요");
				String bookNo = scan.nextLine();
				System.out.println("책의 이름을 입력해 주세요");
				String bookName = scan.nextLine();
				BookDTO book = new BookDTO(bookNo, bookName);
				
				rentBook(member, book);
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + num);
		}
	}
	
	void bookList(String personId) {
		ArrayList<BookDTO> str = map.get(personId);
		for(int i=0; i<(map.get(personId)).size(); i++) {
			System.out.println(str.get(i).getBookName());
		}
		viewMain();
	}
}
