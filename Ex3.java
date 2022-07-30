import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
      
		/*
		 * 구구단 게임 만들기 
		 * 1.컴퓨터가 램덤의 숫자를 준다 
		 * 2.키보드로 정답을 적는다 
		 * 3. 맞췄을경우 10점 틀렸을경우 -10 점 
		 * 4. 총 100점을 맞줘야 게임을 끝낼수 있다.
		 */
		Scanner scan=new Scanner(System.in);
		int point=0;
		System.out.print("구구단 게임을 시작하시겠습니까? yes/no>>");
		String game=scan.next();
		if(game.equals("yes")) {
			while(point<100) {
				int n=0;
			int a=(int)(Math.random()*9)+1;
			int b=(int)(Math.random()*9)+1;
			System.out.println("문제: "+ a+" x "+b+"= ");
			n=scan.nextInt();
			if (n==(a*b)) {
				point+=10;
				System.out.println("정답!!! 현재점수 :"+point);
			}else {
				point-=10;
				System.out.println("오답!!! 현재점수 :"+point);
			}
			}
			System.out.println("100점으로 게임을 종료합니다...");
		}else {
			System.out.println("구구단 게임을 종료합니다..");
			System.exit(0);
		}
		
	}

}
