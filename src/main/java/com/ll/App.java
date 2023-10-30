package com.ll;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class App {
    Scanner scanner;
    int index;
    List<Quotation> quotations;

    //명어 넣을 배열 객체 한개 만들기
    //가변크기로 만들기
    App() {
        scanner = new Scanner(System.in);
        index = 0;
        quotations = new ArrayList<>();
    }

    void run() {
        System.out.println("===명언앱 ===");
        while (true) {
            System.out.printf("명령) ");
            String cmd = scanner.nextLine();
            //request 객체 생성
            Rq rq = new Rq(cmd);
            System.out.println("rq.getAction : " + rq.getAction());
            System.out.println("rq.getParamAsInt : " + rq.getParamAsInt("id", 0));


            switch (rq.getAction()) {
                case "종료":
                    return;
                case "등록":
                    actionWrite();
                    break;
                case "목록":
                    actionList();
                    break;
                case "삭제":
                    actionRemove(rq);
                    break;
                case "수정":
                    actionModify(rq);
                    break;
            }
        }
    }

    //등록
    void actionWrite() {
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String authorName = scanner.nextLine();

        index++;
        int id = index;

        Quotation quotation = new Quotation(id, content, authorName);
        quotations.add(quotation);
        System.out.println(id + "번 명언이 등록되었습니다.");

    }

    //목록
    void actionList() {
        System.out.println("번호 / 작가 / 명언");

        System.out.println("---------------------");
        if (quotations.isEmpty())
            System.out.println("등록된 명언이 없습니다");
        for (int i = quotations.size() - 1; i >= 0; i--) {
            Quotation quotation = quotations.get(i);

            System.out.printf("%d / %s / %s\n", quotation.id, quotation.authorName, quotation.content);
        }
    }

    //삭제
    void actionRemove(Rq rq) {
        //명령어와 id값을 찾아라.
        int id = rq.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; //함수를 끝낸다.
        }
        System.out.println(id + "번 명언을 삭제합니다");

    }

    void actionModify(Rq rq) {
        int id = rq.getParamAsInt("id", 0);

        if (id == 0) {
            System.out.println("id를 정확히 입력해주세요.");
            return; //함수를 끝낸다.
        }
        System.out.println(id + "번 명언을 수정합니다");

    }
}
