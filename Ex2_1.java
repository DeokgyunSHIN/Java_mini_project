import java.util.Arrays;
import java.util.Scanner;

public class Ex2_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 로또 만들기 강사님 버전
		/*
		 * 시스템로또번호 6개 ,보너스번호 변수 ,카운트 변수 (몇개등록되었는지) ,스캐너, 사용자로또번호 6개, 45개 번호가 들어있는 바구니
		 * 
		 */
		int system[] = new int[6];
		int bonusNum = 0;
		int count = 0;
		int player[] = new int[6];
		Scanner scan = new Scanner(System.in);

		int lottery[] = new int[45];

		// 45개 번호가 들어있는 바구니부터 만들기
		for (int i = 0; i < 45; i++) {
			lottery[i] = (i + 1);
		}
		while (count < 7) {

			// 랜덤 index 만들기 (인덱스 번위는 0~44
			int randIndex = (int) (Math.random() * 45);
			if (lottery[randIndex] != 0) {
				// count 가6보다 작으면 아직 로또 번호 완성 전이니깐 로또 번호 만들고
				if (count < 6) {
					system[count] = lottery[randIndex];
				} else {
					// count 가 6이라면 로또번호는 완성! 나머지는 보너스 번호에 준다.
					bonusNum = lottery[randIndex];
				}
				// 뽑힌 자리는 0으로 바꾼다.
				lottery[randIndex] = 0;
				// 개수 증가

				count++;
			}
		}
		System.out.println(Arrays.toString(system) + " " + bonusNum);
		count = 0;

		while (count < 6) {
			System.out.print(count + 1 + " 번쨰의 로또번호>>");
			int temp = scan.nextInt();
			// 값의 유효성 체크
			if (temp < 1 || temp > 45) {
				System.out.println("유호 범위의 숫자가 아닙니다 다시선택하세요.");
				continue;
			}

			// 중복처리
			for (int i = 0; i < count; i++) {
				if (temp == player[i]) {
					System.out.println("선택한 번호는 중복입니다! ");
					temp = 0;
					break;
				}
			}
			if (temp != 0) {
				player[count++] = temp;
			}
		}
		System.out.println("유저" + Arrays.toString(player));
		// 스캐너 닫기
		scan.close();
		// 당첨번호를 저장할 배열
		int luckyNum[] = new int[6];
		int luckyCount = 0;
		boolean isBouns = false;
		// 비교
		for (int i = 0; i < player.length; i++) {
			for (int j = 0; j < system.length; j++) {
				if (player[i] == system[j]) {
					luckyNum[i] = player[i]; // 당첨번ㅗ 저장
					luckyCount++;
					break; // 찾았으니 종료
				}
			}
			// 보너스 번호를 못찾을 때만 비교 , 찾은 후에는 비교하지 않는다.
			if (!isBouns) { // 원래 if 문은 참일때만 실행되는데 if 문 앞에 ! 가들어가면 거짓이어야 실행된다.
				if (player[i] == bonusNum) {
					isBouns = true;
				}
			}
		}
		// 당첨 번호 출력 
		for (int i=0;i<luckyCount;i++) {
			System.out.print(luckyNum[i]+", ");
		}
		System.out.println( isBouns && luckyCount== 5 ? " 보너스 번호 : "+bonusNum : "보너스 번호 없음");
		
		if(luckyCount==6) {
			System.out.println("로또 1등!");
		}else if (luckyCount==5 && isBouns) {
			System.out.println("로또 2등!");
		}else if (luckyCount==5 && isBouns==false) {
			System.out.println("로또 3등!");
		}else if(luckyCount==4) {
			System.out.println("로또 4등!");
		}else if (luckyCount==3) {
			System.out.println("로또 5등 !");
		}else {
			System.out.println("당첨되지 못했습니다..");
		}
	}
}