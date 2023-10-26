package com.ll;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    void run() {

        //프로그램시작
        System.out.println("===명언앱 ===");
        int index = 0;
        //명어 넣을 배열 객체 한개 만들기
        //가변크기로 만들기
        List<Quotation> quotations =new ArrayList<>();
        while (true) {
            System.out.printf("명령) ");
            Scanner scanner = new Scanner(System.in);
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;
            } else if (cmd.equals("등록")) {
                System.out.print("명언 : ");
                String content =scanner.nextLine();
                //titleArr[index]= scanner.nextLine();
                System.out.print("작가 : ");
                //authorArr[index]= scanner.nextLine();
                String authorName =scanner.nextLine();

                System.out.println(content);
                System.out.println(authorName);
                index++;
                int id = index;
                //Quotation  클래스
                Quotation quotation = new Quotation(id,content,authorName);
                quotations.add(quotation);

                System.out.println(index + "번 명언이 등록되었습니다.");
            } else if (cmd.equals("목록")) {

                System.out.println("번호 / 작가 / 명언");

                System.out.println("---------------------");

                if (quotations.isEmpty())
                    System.out.println("등록된 명언이 없습니다");

                for (int i = quotations.size()-1; i >=0 ; i--) {
                    Quotation quotation = quotations.get(i);
                    System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
                }
 
            }
        }
    }


}