package com.ll;

import java.util.Scanner;

class App {
    void run() {
        int index = 0;
        //배열생성
        String[] titleArr = new String[5];
        String[] authorArr = new String[6];
        //프로그램시작
        System.out.println("===명언앱 ===");


        while (true) {
            System.out.printf("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                titleArr[index]= scanner.nextLine();
                System.out.print("작가 : ");
                authorArr[index]= scanner.nextLine();


                System.out.println(titleArr[index]);
                System.out.println(authorArr[index]);
                index++;
                System.out.println(index + "번 명언이 등록되었습니다.");
            } else if (cmd.equals("목록")) {
                System.out.println(" 번호 / 작가 / 명언 ");
                System.out.println("------------------------");
                for (int i = 0; i < titleArr.length; i++) {
                    System.out.println((i+1) +" / " + titleArr[i]+ " / " +authorArr[i]);
                }
            }
        }
    }


}