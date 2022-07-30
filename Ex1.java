import java.util.Arrays;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int arr[] = new int[10]; // 배열 10 생성
		int max = -1; // 최대값 
		int min = 46; // 최소값 

		for (int i = 0; i < 10; i++) { // 반복문을 이용해서 배열에 값을 넣는 반복문
			arr[i] = (int) (Math.random() * 45)+1 ; // 랜덤함수 생성해서 랜덤 값 넣기

	

			for (int j = 0; j < i; j++) { // 중첩 반복문을 이용해서 중복값을 찾는 반복문
				if (arr[j] == arr[i]) { // 만약에 중복값이 있다면
					i--; // i-- 해주어서 다시 랜덤 값을 넣을수 있게 해준다
						break;
				}
			}
			if (max <= arr[i]) { // 만약에 max의 값보다 arr[i]의 값이 더 작다면
				max = arr[i]; // arr[i]의 값을 max에 넣어준다 왜냐하면 max는 최대값을 찾기 위한 변수이기 떄문
			} else if (min >= arr[i]) { // min이 arr[i]의 값보다 더 크다면
				min = arr[i]; // arr[i]의 값을 min에 넣어준다 왜냐하면 min는 최소값을 찾기 위한 변수이기 떄문
			}

		}

		System.out.println(Arrays.toString(arr)); // 배열의 값 출력
		System.out.println("최대값: " + max + ", 최소값: " + min); // 최대값과 최소값을 출력
	}

}
