package it.korea.studnet;

import java.util.Scanner;

public class StdService {
	Scanner scan = new Scanner(System.in);
	int person;    // 학생수 받을 변수 
	Student student[];   // 배열로 선언
	int stdcount = 0;   // 등록할떄 배열로 순서대로 채우기 위한 변수 

	public void start() {   // 시작 
		System.out.print("학생수가 몇명인가요>>");
		person = scan.nextInt();
		student = new Student[person];
		int menu = 0;
		while (true) {
			System.out.println("1. 등록   2. 출력	 3.검색    4.최고득점자   5.종료");
			menu = scan.nextInt();
			switch (menu) {
			case 1:
				addStudent();   //등록
				break;
			case 2:
				printStudent();  // 출력
				break;
			case 3:
				Search();  // 검색
				break;
			case 4:
				FirstTotal();   // 최고득점자
				break;
			case 5:
				System.out.println("종료되었습니다.");
				scan.close();
				System.exit(0); // 프로그램 종료
			}

		}
	}

	public void addStudent() { // 등록하기
		if (stdcount == person) {
			System.out.println("더이상 등록을 할수가 없습니다.");
		} else {
			Student st = new Student();
			System.out.print("학생이름: ");
			st.setStName(scan.next());
			System.out.print("학생국어 점수: ");
			st.setKor(scan.nextInt());
			System.out.print("학생영어 점수: ");
			st.setEng(scan.nextInt());
			System.out.print("학생수학 점수: ");
			st.setMath(scan.nextInt());
			student[stdcount++] = st;
		}
	}

	public void printStudent() { // 출력하기
		for (int i = 0; i < stdcount; i++) {
			System.out.println((i+1)+"번 "+"이름: " + student[i].getStName() + ", 국어: " + student[i].getKor() + 
					", 영어: "+ student[i].getEng() + ", 수학: " + student[i].getMath() + 
					", 총점: " + student[i].getTotal()+ ", 평균: " + student[i].getAvg());
		}
	}

	public void Search() { // 검색하기
		System.out.print("검색할 이름을 입력하세요>>");
		String name = scan.next();
		for (int i = 0; i < stdcount; i++) {
			if (name.equals(student[i].getStName())) {   // 만약에 입력한 name과 같다면
				System.out.println((i+1)+"번 "+"이름: " + student[i].getStName() + ", 국어: " + student[i].getKor() + ", 영어: "
						+ student[i].getEng() + ", 수학: " + student[i].getMath() + ", 총점: " + student[i].getTotal()
						+ ", 평균: " + student[i].getAvg());
			}
		}
	}

	public void FirstTotal() { // 최고 득점자              
		int max = 0;            // 높은 총점값
		int max_name = 0;        // 높은사람의 배열값을 알아내기 위해 변수선언
		int nesting = 0;         // 중복자가 있을수도 있기떄문에 변수선언
		for (int i = 0; i < stdcount; i++) {     
			if (max == student[i].getTotal()) {   // 만약에 동점자가 있다면 nesting++
				nesting = i;
			}
			if (max < student[i].getTotal()) {   // 총점이 제일 높은사람 찾기 취한 if 문
				max_name = i;
				max = student[i].getTotal();
			}
		}
		if (nesting != 0) {   // 만약에 중접자가 있다면 
			if (nesting < max_name) {  // 유저의 등록한 순서 대로 이름을 출력하기위함
				System.out.println((nesting+1)+"번 "+student[nesting].getStName() + ", " +(max_name+1)+"번 "+ student[max_name].getStName()+"총 두명입니다.");
			} else {
				System.out.println((max_name+1)+"번 "+student[max_name].getStName() + ", " +(nesting+1)+"번 "+ student[nesting].getStName()+"총 두명입니다.");
			}

		} else {   // 중접자가 없다면
			System.out.println((max_name+1)+"번 "+student[max_name].getStName());
		}
	}
}
