package libraryTest;

import dao.LibraryDAO;
import dto.BookDTO;
import dto.MemberDTO;

public class LibraryTest {

	public static void main(String[] args) {
//		rentBook
//		①책을 입력받음
//		②DB상의 리스트에 있는지 체크해서, 있다면 일련번호 가져옴 <- 이건 파일 입출력 연동시 추가
//		③일련번호만 넘겨주면 해당일련번호로 대여 실행 rentYN -> Y로 바꿈
		BookDTO b1 = new BookDTO("b1", "메밀꽃필무렵");
		BookDTO b2 = new BookDTO("b2", "징기즈칸");
		BookDTO b3 = new BookDTO("b3", "JAVA의 정석");
		BookDTO b4 = new BookDTO("b4", "데미안");
		BookDTO b5 = new BookDTO("b5", "트렌드 코리아");
		BookDTO b6 = new BookDTO("b6", "지적 대화를 위한 넓고 얕은 지식");
		BookDTO b7 = new BookDTO("b7", "지쳤거나 좋아하는 게 없거나");
		BookDTO b8 = new BookDTO("b8", "에이트");
		BookDTO b9 = new BookDTO("b9", "팩트풀니스");
		BookDTO b10 = new BookDTO("b10", "아주 작은 습관의 힘");

		MemberDTO p1 = new MemberDTO("p1", "서강준");
		MemberDTO p2 = new MemberDTO("p2", "이동욱");
		MemberDTO p3 = new MemberDTO("p3", "공  유");
		MemberDTO p4 = new MemberDTO("p4", "유인나");
		MemberDTO p5 = new MemberDTO("p5", "아이유");

		LibraryDAO dao = new LibraryDAO();
		dao.rentBook(p1, b1);
		dao.rentBook(p2, b2);
		dao.rentBook(p3, b3);
		dao.rentBook(p4, b4);
		dao.rentBook(p5, b5);
		dao.rentBook(p1, b6);
		dao.rentBook(p3, b7);
		dao.rentBook(p5, b8);
		dao.rentBook(p4, b9);
		dao.rentBook(p5, b10);

		dao.viewMain();

	}
}
