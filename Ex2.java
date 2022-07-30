import java.util.Arrays;
import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/**
		 * 추가적인 설명!! number[] 배열을 만들어준 이유는 같은 숫자를 찾기 위한 반복문에 그냥 println를 통해서 할려고 했는데 그렇게
		 * 해버리면 ex)당첨번호 : 3 1 보너스 번호 : 23 등등 이러한 깔끔하게 코드가 나오지 않아서 배열을 하나더 추가함으로써 깔끔하게
		 * 출력하기 위함 입니다.
		 */
		Scanner scan = new Scanner(System.in);
		int com[] = new int[7]; // 시스템 6개의 번호와 1개의 보너스 넣는 배열
		int user[] = new int[6]; // 사용자(유저)입력한 값을 넣는 배열
		int number[] = new int[7]; // 당첨 번호를 알기 위해 표시하는 배열
		int count = 0; // 당첨 번호 맞춘 횟수
		int bonus = 0; // 보너스 번호를 맞춘 횟수

		for (int i = 0; i < com.length; i++) { // 시스템에서 보너스 번호 1개까지 포함한 총 7개의 랜덤 번호를 넣기 위한 반복문
			com[i] = (int) (Math.random() * 45) + 1; // 배열 순서대로 랜덤함수를 통해서 1~45의 숫자를 넣음
			for (int j = 0; j < i; j++) { // 중복 숫자를 있는지 확인하기 위한 반복문
				if (com[i] == com[j]) { // 만약에 중복 숫자가 있다면
					i--; // i-- 함으로써 중복 값을 없앤다
					break;
				}
			}
		}
	   System.out.println(Arrays.toString(com));
		System.out.print("1~45 사이의 숫자를 입력하세요>>"); // 설명
		for (int i = 0; i < user.length; i++) { // 사용자(유저)가 배열에 하나씩 키보드로 입력하기 위한 반복문
			user[i] = scan.nextInt(); // 스캐너를 통해서 순서대로 배열에 키보드 입력값을 넣는다.
			if (user[i] < 1 || user[i] > 45) { // 사용자(유저)가 실수로 1이하나 45이상의 숫자를 넣었을경우
				System.out.print("범위는 1~45입니다. 다시입력해주세요>>"); // 안내문
				i--; // 규칙에 어긋나기 때문에 i-- 함으로써 다시 입력할수 있게 해준다.
			}
			for (int j = 0; j < i; j++) { // 사용자(유저)가 키보드로 입력한 값이 중복되는지 확인하는 반복문

				if (user[i] == user[j]) { // 만약에 사용자(유저)가 입력한값이 중복이 있다면
					System.out.print("똑같은 숫자를 입력하셨습니다. 다시입력해주세요>>"); // 안내문
					i--; // i-- 함으로써 다시 입력할수 있게 해준다.
					break;
				}
			}
		}
		for (int i = 0; i < user.length; i++) { // 시스템 배열과 사용자(유저)의 배열중에 같은 숫자가 있는지 확인하기 위한 반복문
			if (com[com.length - 1] == user[i]) { // 시스템의 맨 마지막 에 있는 배열의 숫자는 보너스 숫자 이기때문에 혹시나 사용자(유저)의 배열중에 같다면
				bonus++; // 보너스 변수에 ++를 해준다.
				number[com.length - 1]++; // 그리고 난중에 당첨 번호를 출력하기 위해서 number[]이라는 배열에 시스템의 배열과 똑같은 자리에 ++를 해준다.
			}
			for (int j = 0; j < user.length; j++) { // 반복문
				if (com[i] == user[j]) { // 보너스 번호 외에 일반 당첨번호가 같다면
					count++; // count라는 변수에 횟수를 추가 한다.
					number[i]++; // 그리고 난중에 당첨 번호를 출력하기 위해서 number[]이라는 배열에 시스템의 배열과 똑같은 자리에 ++를 해준다.
				}
			}
		}
		System.out.print("당첨 번호는 :"); // 출력
		for (int i = 0; i < com.length - 1; i++) { // 보너스번호를 제외한 당첨번호를 출력하기 위한 반복문
			if (number[i] == 1) { // 아까 출력하기 위한 number[] 중에 만약에 1이 있다면 똑같은 숫자가 있다는 뜻이므로
				System.out.print(com[i] + " "); // 시스템 배열을 출력한다.
			}
		}
		System.out.println(); // 줄 바꿈
		if (count == 6) { // 만약에 당첨번호가 6개라면
			System.out.println("1등입니다.");
		} else if (count == 5 && bonus == 1) { // 만약에 당첨번호가 5개이고 보너스 번호까지 맞췄다면
			System.out.println("보너스 번호 :" + com[com.length - 1] + " 까지 맞추었기 때문에 2등입니다.");
		} else if (count == 5) { // 만약에 당첨번호가 5개이면
			System.out.println("3등입니다.");
		} else if (count == 4) { // 만약에 당첨번호가 4개이면
			System.out.println("4등입니다");
		} else if (count == 3) {// 만약에 당첨번호가 3개이면
			System.out.println("5등입니다.");
		} else { // 만약에 당첨번호가 3개도 안된다면
			System.out.println("꽝입니다..");
		}
	}

}
