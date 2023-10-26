package com.ll;

import java.util.Scanner;

class App {
    void run() {
        int index = 0;
        //String title = "제목", author = "작가";
        System.out.println("===명언앱 ===");


        while (true) {
            System.out.printf("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                //Scanner scanner1 = new Scanner(System.in);
                String title = scanner.nextLine();

                System.out.print("작가 : ");
                //Scanner scanner2 = new Scanner(System.in);
                String author = scanner.nextLine();
                index++;

                System.out.println(title);
                System.out.println(author);
                System.out.println(index + "번 명언이 등록되었습니다.");


            } else if (cmd.equals("목록")) {
                System.out.println(" 번호 / 작가 / 명언 ");
                System.out.println("------------------------");
                //System.out.println(index + "/" + author + "/" + title);
            }
        }
    }


}